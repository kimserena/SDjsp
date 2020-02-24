package smartdaily.jsp.controller.board;

import java.io.IOException;
import java.util.List;

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
import smartdaily.jsp.model.JoinLocationsAssignUsers;
import smartdaily.jsp.model.Users;
import smartdaily.jsp.service.JoinLocationsAssignUsersService;
import smartdaily.jsp.service.impl.JoinLocationsAssignUsersServiceImpl;

/**
 * Servlet implementation class DailyCheck
 */
@WebServlet("/board/daily_check.do")
public class DailyCheck extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3256015883459995055L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	JoinLocationsAssignUsersService joinLocationsAssignUsersService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		joinLocationsAssignUsersService = new JoinLocationsAssignUsersServiceImpl(sqlSession, logger);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("loginInfo")==null) {
			sqlSession.close();
			web.reredirect(null, "로그인 후 이용해 주세요.");
			return null;
		}
		
		/** (4) loginInfo 정보의 필요한 값들 받기 */
		int writer_useridx = 0;
		String name = null;
		String responsibletel = null;
		String responsibleemail = null;
		String postcode = null;
		String address1 = null;
		String address2 = null;
		int usertype = 0;
		
		Users loginInfo = (Users) web.getSession("loginInfo");
		if(loginInfo!=null) {
			writer_useridx = loginInfo.getUseridx();
			name = loginInfo.getName();
			responsibletel = loginInfo.getResponsibletel();
			responsibleemail = loginInfo.getResponsibleemail();
			postcode = loginInfo.getPostcode();
			address1 = loginInfo.getAddress1();
			address2 = loginInfo.getAddress2();
			usertype = loginInfo.getUsertype();
		}
		
		logger.debug("writer_useridx =" + writer_useridx);
		logger.debug("name =" + name);
		logger.debug("responsibletel =" + responsibletel);
		logger.debug("responsibleemail =" + responsibleemail);
		logger.debug("postcode =" + postcode);
		logger.debug("address1 =" + address1);
		logger.debug("address2 =" + address2);
		logger.debug("usertype =" + usertype);
		
		
		
		// loginInfo에서 받은 값 view 페이지로 전달
		
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
		
		
		/** (5) service를 이용한 농장주 조회 */
		JoinLocationsAssignUsers j = new JoinLocationsAssignUsers();
		List<JoinLocationsAssignUsers> farmUsersList = null;
		List<JoinLocationsAssignUsers> subcontractorList = null;
		try {
			farmUsersList = joinLocationsAssignUsersService.selectFarmUsersList(j);
			subcontractorList = joinLocationsAssignUsersService.selectSubcontractorList(j);
		}catch(Exception e) {
			sqlSession.close();
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/** (6) view에 조회한 값 전달 */
		request.setAttribute("farmUsersList", farmUsersList);
		request.setAttribute("subcontractorList", subcontractorList);
		request.setAttribute("usertype", usertype);
		
		return "board/daily_check";
	}
	

}
