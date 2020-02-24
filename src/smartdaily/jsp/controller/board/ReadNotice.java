package smartdaily.jsp.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import smartdaily.jsp.dao.MybatisConnectionFactory;
import smartdaily.jsp.helper.BaseController;
import smartdaily.jsp.helper.WebHelper;
import smartdaily.jsp.model.Board;
import smartdaily.jsp.service.BoardService;
import smartdaily.jsp.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class ReadNotice
 */
@WebServlet("/board/read_notice.do")
public class ReadNotice extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4593705608572974880L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	BoardService boardService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		boardService = new BoardServiceImpl(sqlSession, logger);
		
		/** (3) 파라미터 받기 */
		int noti_no = web.getInt("noti_no");
		
		if(noti_no==0) {
			web.reredirect(null, "공지글 번호가 지정되지 않았습니다.");
			sqlSession.close();
			return null;
		}
		
		logger.debug("noti_no =" + noti_no);
		
		/** (4) 조회할 정보에 대한 Beans 생성 */
		Board board = new Board();
		board.setIdx(noti_no);
		
		Board readBoard = null;
		
		try {
			readBoard = boardService.selectBoardNotice(board);
		}catch(Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		/** (5) 조회 결과를 View에 전달 */
		request.setAttribute("readBoard", readBoard);
		
		
		
		return "board/read_notice";
	}
	

}
