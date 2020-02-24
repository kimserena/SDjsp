package smartdaily.jsp.controller.admin.users;

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

/**
 * Servlet implementation class BuildingInsert
 */
@WebServlet("/admin/users/building_insert.do")
public class BuildingInsert extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5096077622803615924L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("adminLoginInfo")==null) {
			web.reredirect(web.getRootPath() + "/admin/users/admin_login.do", "관리자님 로그인 해 주세요.");
			return null;
		}
		
		/** (4) 파라미터 받기 */
		int locationid = web.getInt("locationid");
		int useridx = web.getInt("useridx");
		
		logger.debug("locationid = " + locationid);
		logger.debug("useridx = " + useridx);
		
		/** (6) 이전 페이지에서 받은 값 View페이지에 전달 */
		request.setAttribute("useridx", useridx);
		request.setAttribute("locationid", locationid);
		
		return "admin/users/building_insert";
	}
	

}
