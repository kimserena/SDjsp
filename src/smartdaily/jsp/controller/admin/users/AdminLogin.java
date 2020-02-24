package smartdaily.jsp.controller.admin.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import smartdaily.jsp.helper.BaseController;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/admin/users/admin_login.do")
public class AdminLogin extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6019411975824097580L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "admin/users/admin_login";
	}
	

}
