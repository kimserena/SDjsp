package smartdaily.jsp.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import smartdaily.jsp.helper.BaseController;

/**
 * Servlet implementation class ServiceInfo
 */
@WebServlet("/board/service_info.do")
public class ServiceInfo extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4444900251537467553L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "board/service_info";
	}
	

}
