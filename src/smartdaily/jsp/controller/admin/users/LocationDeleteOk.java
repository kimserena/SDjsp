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
import smartdaily.jsp.model.Assignments;
import smartdaily.jsp.model.Buildings;
import smartdaily.jsp.model.Locations;
import smartdaily.jsp.service.AssignmentsService;
import smartdaily.jsp.service.BuildingsService;
import smartdaily.jsp.service.LocationsService;
import smartdaily.jsp.service.impl.AssignmentsServiceImpl;
import smartdaily.jsp.service.impl.BuildingsServiceImpl;
import smartdaily.jsp.service.impl.LocationsServiceImpl;

/**
 * Servlet implementation class LocationDelete
 */
@WebServlet("/admin/users/location_delete_ok.do")
public class LocationDeleteOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 812453834591795951L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	LocationsService locationsService;
	BuildingsService buildingsService;
	AssignmentsService assignmentsService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		locationsService = new LocationsServiceImpl(sqlSession, logger);
		buildingsService = new BuildingsServiceImpl(sqlSession, logger);
		assignmentsService = new AssignmentsServiceImpl(sqlSession, logger);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("adminLoginInfo")==null) {
			web.reredirect(web.getRootPath() + "/admin/users/admin_login.do", "관리자님 로그인 해 주세요.");
			return null;
		}
		
		/** (4) 파라미터 받기 */
		int locationid = web.getInt("locationid");
		int useridx = web.getInt("useridx");
		
		
		if(locationid==0) {
			web.reredirect(null, "농장 번호가 지정되지 않았습니다.");
			sqlSession.close();
			return null;
		}
		
		logger.debug("locationid = " + locationid);
		logger.debug("useridx = " + useridx);
		
		/** (5) 삭제할 정보에 대한 Beans 생성 */
		Locations locations = new Locations();
		locations.setLocationid(locationid);
		
		Buildings buildings = new Buildings();
		buildings.setLocationid(locationid);
		
		Assignments assign = new Assignments();
		assign.setLocationid(locationid);
		
		try {
			buildingsService.deleteLocationBuildings(buildings);
			assignmentsService.deleteAssignmentsLocations(assign);
			locationsService.deleteLocations(locations);
		}catch (Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		/** (6) 삭제 후 유저 상세보기 페이지로 다시 이동 */
		String url = "%s/admin/users/admin_user_info.do?useridx=%s";
		url = String.format(url, web.getRootPath(), useridx);
		
		web.reredirect(url, "농장이 삭제 되었습니다.");
		
		return null;
	}
	

}
