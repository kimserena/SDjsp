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
 * Servlet implementation class EstimateEnquiryInsertOk
 */
@WebServlet("/board/estimate_enquiry_insert_ok.do")
public class EstimateEnquiryInsertOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8246904002613274296L;
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	BoardService boardService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2)사용하고자 하는 Helper + Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		boardService = new BoardServiceImpl(sqlSession, logger);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		/*
		 * if(web.getSession("loginInfo")==null) { sqlSession.close();
		 * web.reredirect(null, "로그인 후 이용해 주세요."); return null; }
		 */
		
		/** (4) 파라미터 받기 */
		int writer_useridx = web.getInt("writer_useridx");
		String name = web.getString("name");
		String postcode = web.getString("postcode");
		String address11 = web.getString("address11");
		String address22 = web.getString("address22");
		
		String mngMail1 = web.getString("mngMail1");
		String center1 = "@";
		String mngMail2 = web.getString("mngMail2");
		
		String mngMail = mngMail1.concat(center1).concat(mngMail2);
		
		String hyphen = "-";
		String responsibletel1 = web.getString("responsibletel1");
		String responsibletel2 = web.getString("responsibletel2");
		String responsibletel3 = web.getString("responsibletel3");
		
		String responsibletel = responsibletel1.concat(hyphen).concat(responsibletel2).concat(hyphen).concat(responsibletel3);
		
		String inquire_cate = web.getString("inquire_cate");
		String content = web.getString("content");
		String board_ipaddress = web.getClientIP();
		
		// 전달받은 파라미터는 값의 정상여부 확인을 위한 로그
		logger.debug("writer_useridx = " + writer_useridx);
		logger.debug("name = " + name);
		logger.debug("postcode = " + postcode);
		logger.debug("address11 = " + address11);
		logger.debug("address22 = " + address22);
		logger.debug("mngMail = " + mngMail);
		logger.debug("responsibletel = " + responsibletel);
		logger.debug("inquire_cate = " + inquire_cate);
		logger.debug("content = " + content);
		logger.debug("board_ipaddress = " + board_ipaddress);
		
		/** (5)입력값의 유효성 검사 */
		if (inquire_cate==null) {
			sqlSession.close();
			web.reredirect(null, "농장 정보를 선택해 주세요.");
			return null;
		}
		
		
		/** (6)전달받은 파라미터를 Beans 객체에 담는다. */
		Board board = new Board();
		board.setWriter_useridx(writer_useridx);
		board.setWriter(name);
		board.setPostcode(postcode);
		board.setAddress1(address11);
		board.setAddress2(address22);
		board.setEmail(mngMail);
		board.setTel(responsibletel);
		board.setInquire_cate(inquire_cate);
		board.setContent(content);
		board.setBoard_ipaddress(board_ipaddress);
		logger.debug("board >>" + board.toString());
		
		/** (7)Service를 통한 데이터베이스 저장 처리 */
		try {
			boardService.insertBoardEstimate(board);
		}catch(Exception e) {
			sqlSession.close();
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/** (8)수정이 완료되었으므로 메인페이지로 이동 */
		web.reredirect(web.getRootPath() + "/index.do", "견적 문의가 정상적으로 등록 되었습니다.");
		
		return null;
	}
	

}
