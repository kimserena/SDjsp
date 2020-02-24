package smartdaily.jsp.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import smartdaily.jsp.model.Board;
import smartdaily.jsp.service.BoardService;

public class BoardServiceImpl implements BoardService {
	Logger logger;
	SqlSession sqlSession;
	
	public BoardServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}
	
	// 공지사항

	@Override
	public void insertBoardNotice(Board board) throws Exception {
		try {
			int result = sqlSession.insert("BoardMapper.insertBoardNotice", board);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("공지사항 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public List<Board> selectBoardNoticeList(Board board) throws Exception {
        List<Board> result = null;
		
		try {
			result = sqlSession.selectList("BoardMapper.selectBoardNoticeList", board);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("공지사항 목록 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public Board selectBoardNotice(Board board) throws Exception {
		Board result = null;
		try {
			result = sqlSession.selectOne("BoardMapper.selectBoardNotice", board);
			
			if(result==null){
			    throw new NullPointerException();
			}
		}catch(NullPointerException e){
			throw new Exception("공지번호가 없습니다.");
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("공지사항 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateBoardNotice(Board board) throws Exception {
		try{
			int result = sqlSession.update("BoardMapper.updateBoardNotice", board);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("수정할 공지사항이 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("공지사항 수정에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public void deleteBoardNotice(Board board) throws Exception {
		try{
			int result = sqlSession.delete("BoardMapper.deleteBoardNotice", board);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("삭제할 공지사항이 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("공지사항 삭제에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}
	
	// 서비스 문의사항

	@Override
	public void insertBoardService(Board board) throws Exception {
		try {
			int result = sqlSession.insert("BoardMapper.insertBoardService", board);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("문의사항 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public List<Board> selectBoardServiceList(Board board) throws Exception {
        List<Board> result = null;
		
		try {
			result = sqlSession.selectList("BoardMapper.selectBoardServiceList", board);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("서비스문의 목록 조회에 실패 했습니다.");
		}
		return result;
	}
	
	

	@Override
	public Board selectBoardService(Board board) throws Exception {
		Board result = null;
		try {
			result = sqlSession.selectOne("BoardMapper.selectBoardService", board);
			
			if(result==null){
			    throw new NullPointerException();
			}
		}catch(NullPointerException e){
			throw new Exception("서비스문의 번호가 없습니다.");
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("서비스문의 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateBoardService(Board board) throws Exception {
		try{
			int result = sqlSession.update("BoardMapper.updateBoardService", board);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("수정할 서비스문의가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("서비스문의 수정에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public void deleteBoardService(Board board) throws Exception {
		try{
			int result = sqlSession.delete("BoardMapper.deleteBoardService", board);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("삭제할 서비스문의가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("서비스문의 삭제에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}
	
	// 고장 문의
	
	@Override
	public List<Board> selectBoardAsList(Board board) throws Exception {
        List<Board> result = null;
		
		try {
			result = sqlSession.selectList("BoardMapper.selectBoardAsList", board);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("고장문의 목록 조회에 실패 했습니다.");
		}
		return result;
	}
	
	@Override
	public Board selectBoardAs(Board board) throws Exception {
		Board result = null;
		try {
			result = sqlSession.selectOne("BoardMapper.selectBoardAs", board);
			
			if(result==null){
			    throw new NullPointerException();
			}
		}catch(NullPointerException e){
			throw new Exception("고장문의 번호가 없습니다.");
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("고장문의 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateBoardAs(Board board) throws Exception {
		try{
			int result = sqlSession.update("BoardMapper.updateBoardAs", board);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("수정할 고장문의가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("고장문의 수정에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public void deleteBoardAs(Board board) throws Exception {
		try{
			int result = sqlSession.delete("BoardMapper.deleteBoardAs", board);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("삭제할 고장문의가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("고장문의 삭제에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}
	
	// 견적문의

	@Override
	public void insertBoardEstimate(Board board) throws Exception {
		try {
			int result = sqlSession.insert("BoardMapper.insertBoardEstimate", board);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("견적문의 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public List<Board> selectBoardEstimateList(Board board) throws Exception {
        List<Board> result = null;
		
		try {
			result = sqlSession.selectList("BoardMapper.selectBoardEstimateList", board);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("견적문의 목록 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public Board selectBoardEstimate(Board board) throws Exception {
		Board result = null;
		try {
			result = sqlSession.selectOne("BoardMapper.selectBoardEstimate", board);
			
			if(result==null){
			    throw new NullPointerException();
			}
		}catch(NullPointerException e){
			throw new Exception("견적문의번호가 없습니다.");
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("견적문의 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateBoardEstimate(Board board) throws Exception {
		try{
			int result = sqlSession.update("BoardMapper.updateBoardEstimate", board);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("수정할 견적문의가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("견적문의 수정에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	@Override
	public void deleteBoardEstimate(Board board) throws Exception {
		try{
			int result = sqlSession.delete("BoardMapper.deleteBoardEstimate", board);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("삭제할 견적문의가 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("견적문의 삭제에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}
	
	// 각 항목들의 카운트 쿼리(페이징처리를 위함)

	@Override
	public int selectBoardNoticeCount(Board board) throws Exception {
        int result = 0;
		
		try {
			result = sqlSession.selectOne("BoardMapper.selectBoardNoticeCount", board);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("공지사항 수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectBoardServiceCount(Board board) throws Exception {
        int result = 0;
		
		try {
			result = sqlSession.selectOne("BoardMapper.selectBoardServiceCount", board);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("서비스 문의 수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectBoardEstimateCount(Board board) throws Exception {
        int result = 0;
		
		try {
			result = sqlSession.selectOne("BoardMapper.selectBoardEstimateCount", board);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("견적문의 수 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectBoardAsCount(Board board) throws Exception {
        int result = 0;
		
		try {
			result = sqlSession.selectOne("BoardMapper.selectBoardAsCount", board);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("고장 문의 수 조회에 실패했습니다.");
		}
		return result;
	}
	
	
	
	// 권한 신청 게시판

	@Override
	public void insertBoardFarmViewAuth(Board board) throws Exception {
		try {
			int result = sqlSession.insert("BoardMapper.insertBoardFarmViewAuth", board);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("권한신청/해지 글 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
		
	}

	@Override
	public List<Board> selectBoardFarmViewAuthList(Board board) throws Exception {
        List<Board> result = null;
		
		try {
			result = sqlSession.selectList("BoardMapper.selectBoardFarmViewAuthList", board);
			
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("권한 요청/해지 목록 조회에 실패 했습니다.");
		}
		return result;
	}

	@Override
	public Board selectBoardFarmViewAuth(Board board) throws Exception {
		Board result = null;
		try {
			result = sqlSession.selectOne("BoardMapper.selectBoardFarmViewAuth", board);
			
			if(result==null){
			    throw new NullPointerException();
			}
		}catch(NullPointerException e){
			throw new Exception("권한 요청/해지 번호가 없습니다.");
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("권한 요청/해지  조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public int selectBoardFarmViewAuthCount(Board board) throws Exception {
        int result = 0;
		
		try {
			result = sqlSession.selectOne("BoardMapper.selectBoardFarmViewAuthCount", board);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("권한 요청/해지 수 조회에 실패했습니다.");
		}
		return result;
	}


	@Override
	public void updateBoardConfirmComplete(Board board) throws Exception {
		try{
			int result = sqlSession.update("BoardMapper.updateBoardConfirmComplete", board);
			if(result==0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("처리완료로 전환 할 글이 없습니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("처리완료 전환에 실패했습니다.");
		}finally{
			sqlSession.commit();
		}
		
	}

	

	

}
