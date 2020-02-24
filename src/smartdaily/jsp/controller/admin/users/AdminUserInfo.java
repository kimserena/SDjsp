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
import smartdaily.jsp.model.Locations;
import smartdaily.jsp.model.Users;
import smartdaily.jsp.service.LocationsService;
import smartdaily.jsp.service.UsersService;
import smartdaily.jsp.service.impl.LocationsServiceImpl;
import smartdaily.jsp.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class AdminUserInfo
 */
@WebServlet("/admin/users/admin_user_info.do")
public class AdminUserInfo extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7081342555101450793L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UsersService usersService;
	LocationsService locationsService;
	

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		usersService = new UsersServiceImpl(sqlSession, logger);
		locationsService = new LocationsServiceImpl(sqlSession, logger);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("adminLoginInfo")==null) {
			web.reredirect(web.getRootPath() + "/admin/users/admin_login.do", "관리자님 로그인 해 주세요.");
			return null;
		}
		
		/** (4) 유저 번호 파라미터 받기 */
		int useridx = web.getInt("useridx");
		
		logger.debug("useridx" + useridx);
		
		/** (5) 조회할 정보에 대한 Beans 생성 */
		Users users = new Users();
		users.setUseridx(useridx);
		users.setMasterid(useridx);
		
		Locations loca = new Locations();
		loca.setloca_useridx(useridx);
		
		Users readUsers = null;
		List<Locations> locationsList = null;
		List<Users> subIdList = null;
		
		try {
			readUsers = usersService.selectUsers(users);
			locationsList = locationsService.selectLocationsList(loca);
			subIdList = usersService.selectUserSubidList(users);
		}catch (Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
	    logger.debug("subIdList = " + subIdList.toString());
	    logger.debug("locationsList : " + locationsList.toString());
	    
		/*
		 * for(int i=0; i<locationsList.size(); i++) { Locations location =
		 * locationsList.get(i); int locationid = location.getLocationid();
		 * logger.debug("locationid = " + locationid);
		 * 
		 * }
		 */
	    
	    
		
		/** (6) 조회 결과를 View페이지에 전달 */
		request.setAttribute("readUsers", readUsers);
		request.setAttribute("locationsList", locationsList);
		request.setAttribute("subIdList", subIdList);
		
		return "admin/users/admin_user_info";
	}
	

}
