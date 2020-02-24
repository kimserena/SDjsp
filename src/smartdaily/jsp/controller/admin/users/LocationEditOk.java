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
 * Servlet implementation class LocationEditOk
 */
@WebServlet("/admin/users/location_edit_ok.do")
public class LocationEditOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -867186781627771928L;
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
		
		/** (4) 농장 수정 페이지에서 보낸 파라미터 받기 */
		int locationid = web.getInt("locationid");
		int useridx = web.getInt("useridx");
		String locationname = web.getString("locationname");
		String location = web.getString("location");
		int locationsort = web.getInt("locationsort");
		
		logger.debug("locationid = " + locationid);
		logger.debug("useridx = " + useridx);
		logger.debug("locationname = " + locationname);
		logger.debug("location = " + location);
		logger.debug("locationsort = " + locationsort);
		
        /** (5)입력값의 유효성 검사 */
		
		
		/** (6)전달받은 파라미터를 Beans 객체에 담는다. */
		Locations locations = new Locations();
		locations.setLocationid(locationid);
		locations.setLocationname(locationname);
		locations.setLocation(location);
		locations.setLocationsort(locationsort);
		logger.debug("locations >> " + locations.toString());
		
		/** (7)Service를 통한 데이터베이스 저장 처리 */
		try {
			locationsService.updateLocations(locations);
		}catch(Exception e) {
			sqlSession.close();
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/** (8) 농장정보 수정 후 농장 상세보기 페이지로 다시 이동 */
		String url = "%s/admin/users/locations_info.do?useridx=%s&locationid=%s";
		url = String.format(url, web.getRootPath(), useridx, locationid);
		
		web.reredirect(url, "농장 정보가 수정 되었습니다.");
		
		return null;
	}
	

}
