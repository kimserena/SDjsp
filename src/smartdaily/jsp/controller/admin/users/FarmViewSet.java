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
 * Servlet implementation class FarmViewEdit
 */
@WebServlet("/admin/users/farm_view_set.do")
public class FarmViewSet extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1866689849331397821L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	JoinLocationsAssignUsersService joinLocationsAssignUsersService; 
	

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
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
		
		/** (4) 유저 번호 파라미터 받기 */
		int useridx = web.getInt("useridx");
		
		logger.debug("useridx = " + useridx);
		
		/** (5) 조회할 정보에 대한 Beans 생성 */
		JoinLocationsAssignUsers j = new JoinLocationsAssignUsers();
		j.setUseridx(useridx);
		
		/** (6) Service를 통한 DB 조회 */
		List<JoinLocationsAssignUsers> joinList = null;
		
		try {
			joinList = joinLocationsAssignUsersService.selectJoinLocationsAssignUsersList(j);
		}catch (Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		logger.debug("joinList >> " + joinList.toString());
		
		/** (7) 조회 결과를 View페이지에 전달 */
		request.setAttribute("joinList", joinList);
		request.setAttribute("useridx", useridx);
		
		return "admin/users/farm_view_set";
	}
	

}
