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
import smartdaily.jsp.model.Locations;
import smartdaily.jsp.service.LocationsService;
import smartdaily.jsp.service.impl.LocationsServiceImpl;

/**
 * Servlet implementation class LocationEdit
 */
@WebServlet("/admin/users/location_edit.do")
public class LocationEdit extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1732941850652619058L;
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	LocationsService locationsService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2)사용하고자 하는 Helper + Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		locationsService = new LocationsServiceImpl(sqlSession, logger);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("adminLoginInfo")==null) {
			web.reredirect(web.getRootPath() + "/admin/users/admin_login.do", "관리자님 로그인 해 주세요.");
			return null;
		}
		
		/** (4) 농장 번호 파라미터 받기 */
		int locationid = web.getInt("locationid");
		int useridx = web.getInt("useridx");
		
		logger.debug("locationid = " + locationid);
		logger.debug("useridx = " + useridx);
		
		/** (5) 조회할 정보에 대한 Beans 생성 */
		Locations locations = new Locations();
		locations.setLocationid(locationid);
		
		Locations readLocations = null;
		
		try {
			readLocations = locationsService.selectLocations(locations);
		}catch (Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		/** (6) 조회 결과를 View페이지에 전달 */
		request.setAttribute("readLocations", readLocations);
		request.setAttribute("useridx", useridx);
		
		
		return "admin/users/location_edit";
	}
	

}
