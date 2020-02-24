package smartdaily.jsp.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import smartdaily.jsp.model.Users;
import smartdaily.jsp.service.UsersService;


public class UsersServiceImpl implements UsersService {
	Logger logger;
	SqlSession sqlSession;
	
	public UsersServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	// userid 중복검사
	@Override
	public void selectUserIdCount(Users users) throws Exception {
		try {
			int result = sqlSession.selectOne("UsersMapper.selectUserIdCount", users);
			
			if(result > 0){
				throw new NullPointerException();
			}
		}catch (NullPointerException e){
			throw new Exception("이미 사용중인 아이디 입니다.");
		}catch (Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("아이디 중복검사에 실패했습니다.");
		}
		
	}
	
	// 사업자등록번호 중복검사
	@Override
	public void selectCompanynoCount(Users users) throws Exception {
		try {
			int result = sqlSession.selectOne("UsersMapper.selectCompanynoCount", users);
			
			if(result > 0){
				throw new NullPointerException();
			}
		}catch (NullPointerException e){
			throw new Exception("이미 사용중인 사업자번호 입니다.");
		}catch (Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("사업자번호 중복검사에 실패했습니다.");
		}
		
	}
	
	// 법인등록번호 중복검사
	@Override
	public void selectCorpregistnoCount(Users users) throws Exception {
		try {
			int result = sqlSession.selectOne("UsersMapper.selectCorpregistnoCount", users);
			
			if(result > 0){
				throw new NullPointerException();
			}
		}catch (NullPointerException e){
			throw new Exception("이미 사용중인 법인등록번호 입니다.");
		}catch (Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("법인등록번호 중복검사에 실패했습니다.");
		}
		
	}
	
	// 회원가입
	@Override
	public void insertUsers(Users users) throws Exception {
		// userid 중복검사
		selectUserIdCount(users);
		
		try {
			int result = sqlSession.insert("UsersMapper.insertUsers", users);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("회원 정보 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public Users selectLoginInfo(Users users) throws Exception {
		Users result = null;
		try {
			result = sqlSession.selectOne("UsersMapper.selectLoginInfo", users);
			// 조회된 데이터가 없다는 것은 WHERE절 조건에 맞는 데이터가 없다는 것.
			// --> WHERE절은 아이디와 비밀번호가 일치하는 항목을 지정하므로
			// 조회된 데이터가 없다는 것은 아이디나 비밀번호가 잘못되었음을 의미한다.
			if(result==null){
			    throw new NullPointerException();
			}
		}catch(NullPointerException e){
			throw new Exception("아이디나 비밀번호가 잘못되었습니다.");
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("로그인에 실패했습니다.");
		}
		return result;
	}

	@Override
	public Users selectUsers(Users users) throws Exception {
		Users result = null;
		try{
			result = sqlSession.selectOne("UsersMapper.selectUsers", users);
			
			// 조회된 데이터가 없다는 것은 WHERE절 조건에 맞는 데이터가 없다는 것.
			// --> WHERE절은 아이디와 비밀번호가 일치하는 항목을 지정하므로
			// 조회된 데이터가 없다는 것은 아이디나 비밀번호가 잘못되었음을 의미한다.
			if(result==null){
				throw new NullPointerException();
			}
		
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("회원 정보가 없거나 이용이 중지된 아이디 입니다. 고객센터로 문의 바랍니다.");
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("회원정보 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public void updateUsers(Users users) throws Exception {
		try{
			int result = sqlSession.update("UsersMapper.updateUsers", users);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("수정할 회원정보가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("회원정보 수정에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public Users selectAdminLoginInfo(Users users) throws Exception {
		Users result = null;
		try {
			result = sqlSession.selectOne("UsersMapper.selectAdminLoginInfo", users);
			// 조회된 데이터가 없다는 것은 WHERE절 조건에 맞는 데이터가 없다는 것.
			// --> WHERE절은 아이디와 비밀번호가 일치하는 항목을 지정하므로
			// 조회된 데이터가 없다는 것은 아이디나 비밀번호가 잘못되었음을 의미한다.
			if(result==null){
			    throw new NullPointerException();
			}
		}catch(NullPointerException e){
			throw new Exception("관리자 아이디나 비밀번호가 잘못되었습니다.");
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("관리자 로그인에 실패했습니다.");
		}
		return result;
	}

	@Override
	public List<Users> selectAdminUserList(Users users) throws Exception {
        List<Users> result = null;
		
		try {
			result = sqlSession.selectList("UsersMapper.selectAdminUserList", users);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("고객정보 목록 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public int selectUsersCount(Users users) throws Exception {
        int result = 0;
		
		try {
			result = sqlSession.selectOne("UsersMapper.selectUsersCount", users);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("유저 수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public List<Users> selectUserSubidList(Users users) throws Exception {
        List<Users> result = null;
		
		try {
			result = sqlSession.selectList("UsersMapper.selectUserSubidList", users);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("서브아이디 목록 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public void insertUsersSubID(Users users) throws Exception {
        // 아이디 중복 검사
        selectUserIdCount(users);
		
		try {
			int result = sqlSession.insert("UsersMapper.insertUsersSubID", users);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("서브 아이디 정보 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public void updateUsersSubID(Users users) throws Exception {
		try{
			int result = sqlSession.update("UsersMapper.updateUsersSubID", users);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("기존 비밀번호가 맞지않아 정보를 수정 할 수 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("서브아이디정보 수정에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public void deleteUsersSubID(Users users) throws Exception {
		try{
			int result = sqlSession.delete("UsersMapper.deleteUsersSubID", users);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("삭제할 서브아이디가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("서브아이디정보 삭제에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public List<Users> selectAdminNewUserList(Users users) throws Exception {
        List<Users> result = null;
		
		try {
			result = sqlSession.selectList("UsersMapper.selectAdminNewUserList", users);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("신규가입 고객정보 목록 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public int selectNewUsersCount(Users users) throws Exception {
        int result = 0;
		
		try {
			result = sqlSession.selectOne("UsersMapper.selectNewUsersCount", users);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("신규 유저 수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateNewUsers(Users users) throws Exception {
		try{
			int result = sqlSession.update("UsersMapper.updateNewUsers", users);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("수정할 회원정보가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("회원정보 수정에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public void updateSuspendUseUsers(Users users) throws Exception {
		try{
			int result = sqlSession.update("UsersMapper.updateSuspendUseUsers", users);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("수정할 회원정보가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("회원정보 수정에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public List<Users> selectAdminSuspendUseUserList(Users users) throws Exception {
        List<Users> result = null;
		
		try {
			result = sqlSession.selectList("UsersMapper.selectAdminSuspendUseUserList", users);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("이용정지 고객정보 목록 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public int selectSuspendUseUsersCount(Users users) throws Exception {
        int result = 0;
		
		try {
			result = sqlSession.selectOne("UsersMapper.selectSuspendUseUsersCount", users);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("이용정지 유저 수 조회에 실패했습니다.");
		}
		return result;
	}

	

}
