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
import smartdaily.jsp.model.Assignments;
/*import smartdaily.jsp.model.Locations;*/
import smartdaily.jsp.model.Users;
import smartdaily.jsp.service.AssignmentsService;
import smartdaily.jsp.service.LocationsService;
import smartdaily.jsp.service.UsersService;
import smartdaily.jsp.service.impl.AssignmentsServiceImpl;
import smartdaily.jsp.service.impl.LocationsServiceImpl;
import smartdaily.jsp.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class SubidRead
 */
@WebServlet("/admin/users/subid_read.do")
public class SubidRead extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8483602197581407628L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UsersService usersService;
	LocationsService locationsService;
	AssignmentsService assignmentsService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		usersService = new UsersServiceImpl(sqlSession, logger);
		locationsService = new LocationsServiceImpl(sqlSession, logger);
		assignmentsService = new AssignmentsServiceImpl(sqlSession, logger);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("adminLoginInfo")==null) {
			web.reredirect(web.getRootPath() + "/admin/users/admin_login.do", "관리자님 로그인 해 주세요.");
			return null;
		}
		
		/** (4) 서브아이디 정보 파라미터 받기 */
		int useridx = web.getInt("useridx");
		int sub_useridx = web.getInt("sub_useridx");
		
		logger.debug("useridx = " + useridx);
		logger.debug("sub_useridx = " + sub_useridx);
		
		/** (5) 조회할 정보에 대한 Beans 생성 / service를 통한 조회 */
		Users users = new Users();
		users.setUseridx(sub_useridx);
		
		/* Locations loca = new Locations(); */
		/* loca.setloca_useridx(useridx); */
		
		Assignments assign = new Assignments();
		assign.setUseridx(sub_useridx);
		
		Users readSubId = null;
		/* List<Locations> locationsList = null; */
		List<Assignments> locationsAssignList = null;
		
		try {
			readSubId = usersService.selectUsers(users);
			/* locationsList = locationsService.selectLocationsList(loca); */
			locationsAssignList = assignmentsService.selectAssignmentsJoinLocationsAndUsersList(assign);
		}catch (Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		logger.debug("readSubId = " + readSubId.toString());
		logger.debug("locationsAssignList = " + locationsAssignList.toString());
		
		/** (6) 조회 결과를 View페이지에 전달 */
		request.setAttribute("readSubId", readSubId);
		/* request.setAttribute("locationsList", locationsList); */
		request.setAttribute("locationsAssignList", locationsAssignList);
		request.setAttribute("useridx", useridx);
		request.setAttribute("sub_useridx", sub_useridx);
		
		return "admin/users/subid_read";
	}
	

}
