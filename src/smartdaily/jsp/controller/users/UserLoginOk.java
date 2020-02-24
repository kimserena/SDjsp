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
 * Servlet implementation class UserLoginOk
 */
@WebServlet("/users/login_ok.do")
public class UserLoginOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1221705573521601962L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UsersService usersService;
	
	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		usersService = new UsersServiceImpl(sqlSession, logger);
		
		/** (3) 로그인 여부 검사 */
		// 로그인 중이라면 이페이지를 동작시켜서는 안된다.
		if(web.getSession("loginInfo")!=null){
			web.reredirect(web.getRootPath() + "/index.do", "이미 로그인 하셨습니다.");
			return null;
		}
		
		/** (4) 파라미터 처리 */
		String userid = web.getString("userid");
		String pw = web.getString("pw");
		
		logger.debug("userid=" + userid);
		logger.debug("pw=" + pw);
		
		if(userid==null || pw == null){
			sqlSession.close();
			web.reredirect(null, "아이디나 비밀번호를 입력해 주세요.");
		}
		
		/** (5) 전달받은 파라미터를 Beans에 설정한다. */
		Users users = new Users();
		users.setUserid(userid);
		users.setPw(pw);
		
		logger.debug("users >> " + users.toString());
		
		/** (6) Service를 통한 회원인증 */
		Users loginInfo = null;
		try {
			loginInfo = usersService.selectLoginInfo(users);
		}catch(Exception e){
			
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/** (7) 조회된 회원 정보를 세션에 저장 */
		// 로그인 처리는 아이디와 비밀번호를 기반으로 조회된 정보를
		// 세션에 보관하는 과정을 말한다.
		// 로그인에 대한 판별은 저장된 세션정보의 존재 여부로 판별한다.
		web.setSession("loginInfo", loginInfo);
		
		/** (8) 메인페이지로 이동 */
		sqlSession.close();
		web.reredirect(web.getRootPath() + "/index.do", "로그인 되었습니다.");
		
		return null;
	}
	

}
