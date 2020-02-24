package smartdaily.jsp.controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import smartdaily.jsp.helper.BaseController;

/**
 * Servlet implementation class OperationGuide
 */
@WebServlet("/board/operation_guide.do")
public class OperationGuide extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 452456072597971807L;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "board/operation_guide";
	}
	

}
