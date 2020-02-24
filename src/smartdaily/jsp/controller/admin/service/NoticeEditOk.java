package smartdaily.jsp.controller.admin.service;

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
import smartdaily.jsp.model.Users;
import smartdaily.jsp.service.BoardService;
import smartdaily.jsp.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class NoticeEditOk
 */
@WebServlet("/admin/service/notice_edit_ok.do")
public class NoticeEditOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1501646941414585028L;
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
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("adminLoginInfo")==null) {
			web.reredirect(web.getRootPath() + "/admin/users/admin_login.do", "관리자님 로그인 해 주세요.");
			return null;
		}
		
		/** (4) 파라미터 받기 */
		int noti_no = web.getInt("noti_no");
		String subject = web.getString("subject");
		String content = web.getString("content");
		String board_ipaddress = web.getClientIP();
		int writer_useridx = 0;
		
		
		Users adminLoginInfo = (Users) web.getSession("adminLoginInfo");
		if(adminLoginInfo!=null) {
			writer_useridx = adminLoginInfo.getUseridx();
			
		}
		
		logger.debug("noti_no =" + noti_no);
		logger.debug("subject =" + subject);
		logger.debug("content =" + content);
		logger.debug("board_ipaddress =" + board_ipaddress);
		logger.debug("writer_useridx =" + writer_useridx);
		
		Board board = new Board();
		board.setIdx(noti_no);
		board.setWriter_useridx(writer_useridx);
		board.setSubject(subject);
		board.setContent(content);
		board.setBoard_ipaddress(board_ipaddress);
		
		/** (5) service를 통한 공지 등록  */
		try {
			boardService.updateBoardNotice(board);
		}catch(Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		/** (6) 공지 수정 후 상세보기 페이지로 이동 */
		String url = "%s/admin/service/notice_read.do?noti_no=%d";
		logger.debug("url", url);
		url = String.format(url, web.getRootPath(), board.getIdx());
		web.reredirect(url, "공지가 수정 되었습니다.");
		
		
		return null;
	}
	

}
