package smartdaily.jsp.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import smartdaily.jsp.model.Locations;
import smartdaily.jsp.service.LocationsService;

public class LocationsServiceImpl implements LocationsService {
	Logger logger;
	SqlSession sqlSession;
	
	public LocationsServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void insertLocations(Locations locations) throws Exception {
		try {
			int result = sqlSession.insert("LocationsMapper.insertLocations", locations);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("농장 정보 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public List<Locations> selectLocationsList(Locations locations) throws Exception {
        List<Locations> result = null;
		
		try {
			result = sqlSession.selectList("LocationsMapper.selectLocationsList", locations);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("농장 목록 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public Locations selectLocations(Locations locations) throws Exception {
		Locations result = null;
		try{
			result = sqlSession.selectOne("LocationsMapper.selectLocations", locations);
			
			// 조회된 데이터가 없다는 것은 WHERE절 조건에 맞는 데이터가 없다는 것.
			// --> WHERE절은 아이디와 비밀번호가 일치하는 항목을 지정하므로
			// 조회된 데이터가 없다는 것은 아이디나 비밀번호가 잘못되었음을 의미한다.
			if(result==null){
				throw new NullPointerException();
			}
		}catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 농장에 대한 요청입니다.");
		
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("농장 정보 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public void deleteLocations(Locations locations) throws Exception {
		try{
			int result = sqlSession.delete("LocationsMapper.deleteLocations", locations);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("존재하지 않는 농장에 대한 요청입니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("농장 삭제에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public void updateLocations(Locations locations) throws Exception {
		try{
			int result = sqlSession.update("LocationsMapper.updateLocations", locations);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("수정할 농장정보가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("농장정보 수정에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

}
