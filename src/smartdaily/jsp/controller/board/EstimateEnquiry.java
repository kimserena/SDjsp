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
import smartdaily.jsp.model.Users;
import smartdaily.jsp.service.BoardService;
import smartdaily.jsp.service.impl.BoardServiceImpl;

/**
 * Servlet implementation class EstimateEnquiry
 */
@WebServlet("/board/estimate_enquiry.do")
public class EstimateEnquiry extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8080508313032958502L;
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
		// 로그인 중이 아니라도 페이지가 동작해야 한다.
		if(web.getSession("loginInfo")==null) {
			
		}else if(web.getSession("loginInfo")!=null){
			/** (4) loginInfo 정보의 필요한 값들 받기 */
			int writer_useridx = 0;
			String name = null;
			String responsibletel = null;
			String responsibleemail = null;
			String postcode = null;
			String address1 = null;
			String address2 = null;
			
			Users loginInfo = (Users) web.getSession("loginInfo");
			if(loginInfo!=null) {
				writer_useridx = loginInfo.getUseridx();
				name = loginInfo.getName();
				responsibletel = loginInfo.getResponsibletel();
				responsibleemail = loginInfo.getResponsibleemail();
				postcode = loginInfo.getPostcode();
				address1 = loginInfo.getAddress1();
				address2 = loginInfo.getAddress2();
			}
			
			logger.debug("writer_useridx =" + writer_useridx);
			logger.debug("name =" + name);
			logger.debug("responsibletel =" + responsibletel);
			logger.debug("responsibleemail =" + responsibleemail);
			logger.debug("postcode =" + postcode);
			logger.debug("address1 =" + address1);
			logger.debug("address2 =" + address2);
			
			String[] result1 = responsibleemail.split("\\@");
	        for(int i = 0; i<result1.length; i++) {
				
				request.setAttribute("email1", result1[0]);
				request.setAttribute("email2", result1[1]);
				
			}
			logger.debug("responsibleemail1 = " + result1[0]);
			logger.debug("responsibleemail2 = " + result1[1]);
			
			String[] result2 = responsibletel.split("\\-");
	        for(int i = 0; i<result2.length; i++) {
				
				request.setAttribute("responsibletel1", result2[0]);
				request.setAttribute("responsibletel2", result2[1]);
				request.setAttribute("responsibletel3", result2[2]);
			}
	        logger.debug("responsibletel1 = " + result2[0]);
			logger.debug("responsibletel2 = " + result2[1]);
			logger.debug("responsibletel3 = " + result2[2]);
			
			request.setAttribute("writer_useridx", writer_useridx);
			request.setAttribute("name", name);
			request.setAttribute("postcode", postcode);
			request.setAttribute("address1", address1);
			request.setAttribute("address2", address2);
		}
		
		
		
		return "board/estimate_enquiry";
	}
	

}
