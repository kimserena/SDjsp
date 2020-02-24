package smartdaily.jsp.controller.admin.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import smartdaily.jsp.helper.BaseController;

/**
 * Servlet implementation class SuspendUseUserInfo
 */
@WebServlet("/admin/users/suspend_use_user_info.do")
public class SuspendUseUserInfo extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2875717274634174582L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		return "admin/users/suspend_use_user_info";
	}
	

}
