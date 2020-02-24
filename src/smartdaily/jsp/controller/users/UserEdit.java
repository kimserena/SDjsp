package smartdaily.jsp.controller.users;

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
import smartdaily.jsp.service.UsersService;
import smartdaily.jsp.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class UserEdit
 */
@WebServlet("/users/user_edit.do")
public class UserEdit extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1093086844933894937L;
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UsersService usersService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2)사용하고자 하는 Helper + Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		usersService = new UsersServiceImpl(sqlSession, logger);
		
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("loginInfo")==null){
			web.reredirect(null, "로그인 해 주세요.");
			return null;
		}
		
		/** (4) user 정보의 회원 번호 받기 */
		int useridx = 0;
		Users loginInfo = (Users) web.getSession("loginInfo");
		if(loginInfo!=null) {
			useridx = loginInfo.getUseridx();
		}
		
		logger.debug("useridx = " + useridx);
		
		/** (5)전달받은 회원번호를 Beans 객체에 담는다. */
		Users users = new Users();
		users.setUseridx(useridx);
		
		/** (6)Service를 통한 데이터베이스 조회 처리 */
		Users readUser = null;
		try {
			readUser = usersService.selectUsers(users);
		}catch(Exception e) {
			sqlSession.close();
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}
		
		String fax = readUser.getFax();
		String[] result = fax.split("\\-");
		
		for(int i = 0; i<result.length; i++) {
			
			request.setAttribute("comFax1", result[0]);
			request.setAttribute("comFax2", result[1]);
			request.setAttribute("comFax3", result[2]);
		}
		logger.debug("comFax1 = " + result[0]);
		logger.debug("comFax2 = " + result[1]);
		logger.debug("comFax3 = " + result[2]);
		
		String email = readUser.getResponsibleemail();
		String[] result1 = email.split("\\@");
        for(int i = 0; i<result1.length; i++) {
			
			request.setAttribute("email1", result1[0]);
			request.setAttribute("email2", result1[1]);
			
		}
		logger.debug("email1 = " + result1[0]);
		logger.debug("email2 = " + result1[1]);
		
		
		String responsibletel = readUser.getResponsibletel();
		String[] result2 = responsibletel.split("\\-");
		
		for(int i = 0; i<result2.length; i++) {
			
			request.setAttribute("responsibletel1", result2[0]);
			request.setAttribute("responsibletel2", result2[1]);
			request.setAttribute("responsibletel3", result2[2]);
		}
		logger.debug("responsibletel1 = " + result2[0]);
		logger.debug("responsibletel2 = " + result2[1]);
		logger.debug("responsibletel3 = " + result2[2]);
		
		String responsiblesellphon = readUser.getResponsiblesellphon();
		String[] result3 = responsiblesellphon.split("\\-");
		
		for(int i = 0; i<result3.length; i++) {
			
			request.setAttribute("responsiblesellphon1", result3[0]);
			request.setAttribute("responsiblesellphon2", result3[1]);
			request.setAttribute("responsiblesellphon3", result3[2]);
		}
		logger.debug("responsiblesellphon1 = " + result3[0]);
		logger.debug("responsiblesellphon2 = " + result3[1]);
		logger.debug("responsiblesellphon3 = " + result3[2]);
		
		request.setAttribute("readUser", readUser);
		
		/** (8)수정이 완료되었으므로 메인페이지로 이동 */
		
		
		
		return "users/user_edit";
	}
	

}
