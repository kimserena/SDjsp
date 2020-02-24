package smartdaily.jsp.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import smartdaily.jsp.model.JoinLocationsAssignUsers;
import smartdaily.jsp.service.JoinLocationsAssignUsersService;

public class JoinLocationsAssignUsersServiceImpl implements JoinLocationsAssignUsersService {
	Logger logger;
	SqlSession sqlSession;
	
	public JoinLocationsAssignUsersServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public List<JoinLocationsAssignUsers> selectJoinLocationsAssignUsersList(
			JoinLocationsAssignUsers joinLocationsAssignUsers) throws Exception {
        List<JoinLocationsAssignUsers> result = null;
		
		try {
			result = sqlSession.selectList("JoinLocationsAssignUsersMapper.selectJoinLocationsAssignUsersList", joinLocationsAssignUsers);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("농장별 권한정보 목록 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public List<JoinLocationsAssignUsers> selectFarmUsersList(JoinLocationsAssignUsers joinLocationsAssignUsers)
			throws Exception {
        List<JoinLocationsAssignUsers> result = null;
		
		try {
			result = sqlSession.selectList("JoinLocationsAssignUsersMapper.selectFarmUsersList", joinLocationsAssignUsers);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("농장주 목록 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public List<JoinLocationsAssignUsers> selectSubcontractorList(JoinLocationsAssignUsers joinLocationsAssignUsers)
			throws Exception {
List<JoinLocationsAssignUsers> result = null;
		
		try {
			result = sqlSession.selectList("JoinLocationsAssignUsersMapper.selectSubcontractorList", joinLocationsAssignUsers);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("협력사 목록 조회에 실패 했습니다.");
		}
		return result;
		
	}
	
	

}
