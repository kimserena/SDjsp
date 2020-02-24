package smartdaily.jsp.service;

import java.util.List;

import smartdaily.jsp.model.Board;

public interface BoardService {
	
	// 공지사항
	public void insertBoardNotice(Board board) throws Exception;
	public List<Board> selectBoardNoticeList(Board board) throws Exception;
	public Board selectBoardNotice(Board board) throws Exception;
	public void updateBoardNotice(Board board) throws Exception;
	public void deleteBoardNotice(Board board) throws Exception;
	public int selectBoardNoticeCount(Board board) throws Exception;
	
	// 서비스 문의
	public void insertBoardService(Board board) throws Exception;
	public List<Board> selectBoardServiceList(Board board) throws Exception;
	public Board selectBoardService(Board board) throws Exception;
	public void updateBoardService(Board board) throws Exception;
	public void deleteBoardService(Board board) throws Exception;
	public int selectBoardServiceCount(Board board) throws Exception;
	
	// 고장 문의
	public List<Board> selectBoardAsList(Board board) throws Exception;
	public Board selectBoardAs(Board board) throws Exception;
	public void updateBoardAs(Board board) throws Exception;
	public void deleteBoardAs(Board board) throws Exception;
	public int selectBoardAsCount(Board board) throws Exception;
	
	// 견적 문의
	public void insertBoardEstimate(Board board) throws Exception;
	public List<Board> selectBoardEstimateList(Board board) throws Exception;
	public Board selectBoardEstimate(Board board) throws Exception;
	public void updateBoardEstimate(Board board) throws Exception;
	public void deleteBoardEstimate(Board board) throws Exception;
	public int selectBoardEstimateCount(Board board) throws Exception;
	
	// 권한 신청 게시판
	public void insertBoardFarmViewAuth(Board board) throws Exception;
	public List<Board> selectBoardFarmViewAuthList(Board board) throws Exception;
	public Board selectBoardFarmViewAuth(Board board) throws Exception;
	public int selectBoardFarmViewAuthCount(Board board) throws Exception;
	
	// board_confirm 업데이트
	public void updateBoardConfirmComplete(Board board) throws Exception;

}
