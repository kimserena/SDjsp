package smartdaily.jsp.controller.admin.users;

import java.io.IOException;
import java.util.List;

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
import smartdaily.jsp.model.JoinLocationsAssignUsers;
import smartdaily.jsp.service.JoinLocationsAssignUsersService;
import smartdaily.jsp.service.impl.JoinLocationsAssignUsersServiceImpl;

/**
 * Servlet implementation class FarmViewInsert
 */
@WebServlet("/admin/users/farm_view_insert.do")
public class FarmViewInsert extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2075105755589402541L;
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	JoinLocationsAssignUsersService joinLocationsAssignUsersService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2)사용하고자 하는 Helper + Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		joinLocationsAssignUsersService = new JoinLocationsAssignUsersServiceImpl(sqlSession, logger);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("adminLoginInfo")==null) {
			web.reredirect(web.getRootPath() + "/admin/users/admin_login.do", "관리자님 로그인 해 주세요.");
			return null;
		}
		
		/** (4) 권한 추가에 필요한 파라미터 받기 */
		int useridx = web.getInt("useridx");
		
		logger.debug("useridx = " + useridx);
		
		/** (5) service를 이용한 농장주 조회 */
		JoinLocationsAssignUsers j = new JoinLocationsAssignUsers();
		List<JoinLocationsAssignUsers> farmUsersList = null;
		try {
			farmUsersList = joinLocationsAssignUsersService.selectFarmUsersList(j);
		}catch(Exception e) {
			sqlSession.close();
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/** (6) view에 조회한 값 전달 */
		request.setAttribute("farmUsersList", farmUsersList);
		request.setAttribute("useridx", useridx);
		
		return "admin/users/farm_view_insert";
	}
	

}
