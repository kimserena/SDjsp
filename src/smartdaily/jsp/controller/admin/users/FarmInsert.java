package smartdaily.jsp.controller.admin.users;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import smartdaily.jsp.helper.BaseController;
import smartdaily.jsp.helper.WebHelper;

/**
 * Servlet implementation class FarmInsert
 */
@WebServlet("/admin/users/farm_insert.do")
public class FarmInsert extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1488728984300146887L;
	WebHelper web;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		web = WebHelper.getInstance(request, response);
		
		int useridx = web.getInt("useridx");
		
		logger.debug("useridx = " + useridx);
		
		request.setAttribute("useridx", useridx);
		
		return "admin/users/farm_insert";
	}
	

}
