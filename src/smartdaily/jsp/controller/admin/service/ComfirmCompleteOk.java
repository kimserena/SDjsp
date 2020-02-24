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
import smartdaily.jsp.service.BoardService;
import smartdaily.jsp.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class ComfirmCompleteOk
 */
@WebServlet("/admin/service/comfirm_complete_ok.do")
public class ComfirmCompleteOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6833800308155834612L;
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
		
		/** (4) web에서 전달 받은 값 객체에 담기 */
		int subscrip_no = web.getInt("subscrip_no");
		int as_no = web.getInt("as_no");
		int qna_no = web.getInt("qna_no");
		int estimate_no = web.getInt("estimate_no");
		int board_confirm = web.getInt("board_confirm");
		
		
		if(board_confirm==0) {
			web.reredirect(null, "처리상태 번호가 지정되지 않았습니다.");
			sqlSession.close();
			return null;
		}
		
		logger.debug("subscrip_no = " + subscrip_no);
		logger.debug("as_no = " + as_no);
		logger.debug("qna_no = " + qna_no);
		logger.debug("estimate_no = " + estimate_no);
		logger.debug("board_confirm = " + board_confirm);
		
		if(board_confirm==1) {
			if(subscrip_no!=0) {
				/** (5) 업데이트할 정보에 대한 Beans 생성 */
				Board board = new Board();
				board.setIdx(subscrip_no);
				board.setBoard_confirm(board_confirm);
				
				/** (6) service를 통한 처리완료 상태로 업데이트  */
				try {
					boardService.updateBoardConfirmComplete(board);
				}catch(Exception e) {
					web.reredirect(null, e.getLocalizedMessage());
					return null;
				}finally {
					sqlSession.close();
				}
				
				/** (7) 처리완료 업데이트 후 상세보기 페이지로 이동 */
				String url = "%s/admin/service/farm_view_auth_read.do?subscrip_no=%d";
				logger.debug("url", url);
				url = String.format(url, web.getRootPath(), subscrip_no);
				web.reredirect(url, "현재 글이 처리 완료로 전환 되었습니다.");
				
				
			}else if(as_no!=0) {
				/** (5) 업데이트할 정보에 대한 Beans 생성 */
				Board board = new Board();
				board.setIdx(as_no);
				board.setBoard_confirm(board_confirm);
				
				/** (6) service를 통한 처리완료 상태로 업데이트  */
				try {
					boardService.updateBoardConfirmComplete(board);
				}catch(Exception e) {
					web.reredirect(null, e.getLocalizedMessage());
					return null;
				}finally {
					sqlSession.close();
				}
				
				/** (7) 처리완료 업데이트 후 상세보기 페이지로 이동 */
				String url = "%s/admin/service/afterservice_read.do?as_no=%d";
				logger.debug("url", url);
				url = String.format(url, web.getRootPath(), as_no);
				web.reredirect(url, "현재 글이 처리 완료로 전환 되었습니다.");
				
				
			}else if(qna_no != 0) {
				/** (5) 업데이트할 정보에 대한 Beans 생성 */
				Board board = new Board();
				board.setIdx(qna_no);
				board.setBoard_confirm(board_confirm);
				
				/** (6) service를 통한 처리완료 상태로 업데이트  */
				try {
					boardService.updateBoardConfirmComplete(board);
				}catch(Exception e) {
					web.reredirect(null, e.getLocalizedMessage());
					return null;
				}finally {
					sqlSession.close();
				}
				
				/** (7) 처리완료 업데이트 후 상세보기 페이지로 이동 */
				String url = "%s/admin/service/qna_read.do?qna_no=%d";
				logger.debug("url", url);
				url = String.format(url, web.getRootPath(), qna_no);
				web.reredirect(url, "현재 글이 처리 완료로 전환 되었습니다.");
				
				
			}else if(estimate_no!=0) {
				/** (5) 업데이트할 정보에 대한 Beans 생성 */
				Board board = new Board();
				board.setIdx(estimate_no);
				board.setBoard_confirm(board_confirm);
				
				/** (6) service를 통한 처리완료 상태로 업데이트  */
				try {
					boardService.updateBoardConfirmComplete(board);
				}catch(Exception e) {
					web.reredirect(null, e.getLocalizedMessage());
					return null;
				}finally {
					sqlSession.close();
				}
				
				/** (7) 처리완료 업데이트 후 상세보기 페이지로 이동 */
				String url = "%s/admin/service/estimate_read.do?estimate_no=%d";
				logger.debug("url", url);
				url = String.format(url, web.getRootPath(), estimate_no);
				web.reredirect(url, "현재 글이 처리 완료로 전환 되었습니다.");
			}
			
			
		}else if(board_confirm==2) {
			sqlSession.close();
			web.reredirect(null, "이미 완료 처리된 글 입니다.");
			return null;
		}
		
		return null;
	}
	

}
