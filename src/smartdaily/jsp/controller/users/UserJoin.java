package smartdaily.jsp.controller.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import smartdaily.jsp.helper.BaseController;
import smartdaily.jsp.helper.WebHelper;

/**
 * Servlet implementation class UserJoin
 */
@WebServlet("/users/user_join.do")
public class UserJoin extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3192495712169480153L;
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	WebHelper web;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper 객체 생성 */
		web = WebHelper.getInstance(request, response);
		
		/** (3) 로그인 여부 검사 */
		// 로그인 중 이라면 이페이지를 동작시켜서는 안된다.
		if(web.getSession("loginInfo")!=null) {
			web.reredirect(web.getRootPath() + "/index.do", "이미 로그인 하셨습니다.");
			return null;
		}
		
		
		return "users/user_join";
	}
	

}
