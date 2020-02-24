package smartdaily.jsp.controller.admin.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import smartdaily.jsp.helper.BaseController;
import smartdaily.jsp.helper.WebHelper;
import smartdaily.jsp.model.Users;

/**
 * Servlet implementation class Logout
 */
@WebServlet("/admin/users/logout.do")
public class Logout extends BaseController {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2061284290896723261L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	WebHelper web;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 필요한 헬퍼 객체 생성 */
		web = WebHelper.getInstance(request, response);
		
		/** (3) 로그인 여부 검사 */
		Users adminLoginInfo = (Users) web.getSession("adminLoginInfo");
		
		if(adminLoginInfo==null) {
			web.reredirect(web.getRootPath() + "/admin/users/admin_login.do", "로그인 후에 이용 가능합니다.");
			return null;
		}
		
		/** (4) 로그아웃 */
		// 로그아웃은 모든 세션 정보를 삭제하는 처리.
		web.removeAllSession();
		
		/** (5) 페이지 이동 */
		web.reredirect(web.getRootPath() + "/admin/users/admin_login.do", "로그아웃 되었습니다.");
		
		return null;
	}
	

}
