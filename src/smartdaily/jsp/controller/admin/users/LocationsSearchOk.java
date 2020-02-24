package smartdaily.jsp.controller.admin.users;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import smartdaily.jsp.dao.MybatisConnectionFactory;
import smartdaily.jsp.helper.BaseController;
import smartdaily.jsp.helper.WebHelper;
import smartdaily.jsp.model.Locations;
import smartdaily.jsp.service.LocationsService;
import smartdaily.jsp.service.impl.LocationsServiceImpl;

/**
 * Servlet implementation class LocationsSearchOk
 */
@WebServlet("/admin/users/locations_search_ok.do")
public class LocationsSearchOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 868427066295912320L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	LocationsService locationsService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지 형식을 JSON으로 설정한다.
		response.setContentType("application/json");
		
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		locationsService = new LocationsServiceImpl(sqlSession, logger);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		/*
		 * if(web.getSession("adminLoginInfo")==null) { web.reredirect(web.getRootPath()
		 * + "/admin/users/admin_login.do", "관리자님 로그인 해 주세요."); return null; }
		 */
		
		/** (4) 유저 번호 파라미터 받기 */
        int useridx = web.getInt("useridx");
		
		logger.debug("useridx = " + useridx);
		
		/** (5) 조회할 정보에 대한 Beans 생성 */
		Locations locations = new Locations();
		locations.setloca_useridx(useridx);
		
		/** (6) Service를 통한 DB 조회 */
		List<Locations> locationsList = null;
		
		try {
			locationsList = locationsService.selectLocationsList(locations);
		}catch (Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("locationsList", locationsList);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getWriter(), data);
		
		
		return null;
	}
	
}
