package smartdaily.jsp.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import smartdaily.jsp.model.Buildings;
import smartdaily.jsp.service.BuildingsService;

public class BuildingsServiceImpl implements BuildingsService {
	Logger logger;
	SqlSession sqlSession;
	
	public BuildingsServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void insertBuildings(Buildings buildings) throws Exception {
		try {
			int result = sqlSession.insert("BuildingsMapper.insertBuildings", buildings);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("돈사 정보 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public List<Buildings> selectBuildingsList(Buildings buildings) throws Exception {
        List<Buildings> result = null;
		
		try {
			result = sqlSession.selectList("BuildingsMapper.selectBuildingsList", buildings);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("돈사 목록 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public void deleteBuildings(Buildings buildings) throws Exception {
		try{
			int result = sqlSession.delete("BuildingsMapper.deleteBuildings", buildings);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("존재하지 않는 돈사에 대한 요청입니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("돈사 삭제에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public void deleteLocationBuildings(Buildings buildings) throws Exception {
		try{
			sqlSession.delete("BuildingsMapper.deleteLocationBuildings", buildings);
			
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("농장에 속한 돈사 삭제에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

}
