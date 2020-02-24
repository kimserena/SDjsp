package smartdaily.jsp.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import smartdaily.jsp.model.Assignments;
import smartdaily.jsp.service.AssignmentsService;

public class AssignmentsServiceImpl implements AssignmentsService {
	Logger logger;
	SqlSession sqlSession;
	
	public AssignmentsServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void insertAssignmentsSubid(Assignments assignments) throws Exception {
		try {
			int result = sqlSession.insert("AssignmentsMapper.insertAssignmentsSubid", assignments);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("등록된 데이터가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("서브아이디 권한 정보 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public List<Assignments> selectAssignmentsJoinLocationsAndUsersList(Assignments assignments) throws Exception {
		List<Assignments> result = null;
		
		try {
			result = sqlSession.selectList("AssignmentsMapper.selectAssignmentsJoinLocationsAndUsersList", assignments);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("농장별 서브아이디 권한정보 목록 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public void updateAssignmentsSubid(Assignments assignments) throws Exception {
		try{
			int result = sqlSession.update("AssignmentsMapper.updateAssignmentsSubid", assignments);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("수정할 권한정보가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("권한정보 수정에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public void deleteAssignmentsSubid(Assignments assignments) throws Exception {
		try{
			int result = sqlSession.delete("AssignmentsMapper.deleteAssignmentsSubid", assignments);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("삭제할 서브아이디 권한정보가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("서브아이디권한정보 삭제에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public void deleteAssignmentsLocations(Assignments assignments) throws Exception {
		try{
			int result = sqlSession.delete("AssignmentsMapper.deleteAssignmentsLocations", assignments);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("삭제할 농장 권한정보가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("농장권한정보 삭제에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public void deleteGuestAssignments(Assignments assignments) throws Exception {
		try{
			int result = sqlSession.delete("AssignmentsMapper.deleteGuestAssignments", assignments);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("삭제할 권한정보가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("권한정보 삭제에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}
	
	@Override
	public void selectGuestAssignmentsCount(Assignments assignments) throws Exception {
		try {
			int result = sqlSession.selectOne("AssignmentsMapper.selectGuestAssignmentsCount", assignments);
			
			if(result > 0){
				throw new NullPointerException();
			}
		}catch (NullPointerException e){
			throw new Exception("이미 등록된 협력사 권한 정보 입니다.");
		}catch (Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("협력사 권한정보 중복검사에 실패했습니다.");
		}
		
	}

	@Override
	public void insertGuestAssignments(Assignments assignments) throws Exception {
		// 협력사 권한등록 중복검사
		selectGuestAssignmentsCount(assignments);
		try {
			int result = sqlSession.insert("AssignmentsMapper.insertGuestAssignments", assignments);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("등록된 협력사 권한정보 데이터가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("협력사 읽기권한 정보 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
		
	}

	
	
	

}
