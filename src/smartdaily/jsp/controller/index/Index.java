package smartdaily.jsp.controller.index;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import smartdaily.jsp.helper.BaseController;

/**
 * Servlet implementation class Index
 */
@WebServlet("/index.do")
public class Index extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -89839535758691095L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "index";
	}
	

}
