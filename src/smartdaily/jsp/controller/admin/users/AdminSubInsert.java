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
 * Servlet implementation class AdminSubInsert
 */
@WebServlet("/admin/users/admin_sub_insert.do")
public class AdminSubInsert extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7395149496380342780L;
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
		
		/** (4) 이전 페이지 정보 파라미터 받기 */
		int useridx = web.getInt("useridx");
		
		if(useridx==0) {
			sqlSession.close();
			web.reredirect(null, "농장주 번호가 없습니다.");
			return null;
		}
		
		logger.debug("useridx =" + useridx);
		
		/** (5) view에 농장주 useridx 전달 */
		request.setAttribute("useridx", useridx);
		
		
		return "admin/users/admin_sub_insert";
	}
	

}
