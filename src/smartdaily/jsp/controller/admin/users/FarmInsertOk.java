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
import smartdaily.jsp.model.Locations;
import smartdaily.jsp.model.Users;
import smartdaily.jsp.service.AssignmentsService;
import smartdaily.jsp.service.LocationsService;
import smartdaily.jsp.service.UsersService;
import smartdaily.jsp.service.impl.AssignmentsServiceImpl;
import smartdaily.jsp.service.impl.LocationsServiceImpl;
import smartdaily.jsp.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class FarmInsertOk
 */
@WebServlet("/admin/users/farm_insert_ok.do")
public class FarmInsertOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4941135083383273929L;
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
		
		/** (4) 농장 정보 파라미터 받기 */
		int useridx = web.getInt("useridx");
		String locationname = web.getString("locationname");
		String location = web.getString("location");
		int locationsort = web.getInt("locationsort");
		
		logger.debug("useridx =" + useridx);
		logger.debug("locationname =" + locationname);
		logger.debug("location =" + location);
		logger.debug("locationsort =" + locationsort);
		
		/** (5) 등록할 농장정보에 대한 Beans 생성 */
		Locations loca = new Locations();
		loca.setloca_useridx(useridx);
		loca.setLocationname(locationname);
		loca.setLocation(location);
		loca.setLocationsort(locationsort);
		
		/** (6)Service를 통한 데이터베이스 저장 처리 */
		try {
			locationsService.insertLocations(loca);
		}catch(Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}
		
		// insert한 locations의 locationid값 받아오기
		int insert_locationid = loca.getLocationid();
		
		// subid를 소유한 농장주의 인덱스 값으로 서브아이디 인덱스 값 가져와서 권한 정보 초기화 하기
		Users users = new Users();
		users.setMasterid(useridx);
		
		List<Users> subidList = null;
		
		try{
			subidList = usersService.selectUserSubidList(users);
		}catch(Exception e){
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}
		
		logger.debug("subidList >> " + subidList);
		
		for(int i=0; i<subidList.size(); i++) {
			Users user = subidList.get(i);
			int user_idx = user.getUseridx();
			logger.debug("user_idx = " + user_idx);
			Assignments assign = new Assignments();
			assign.setUseridx(user_idx);
			assign.setLocationid(insert_locationid);
			try {
				
				
				assignmentsService.insertAssignmentsSubid(assign);
			}catch (Exception e) {
				web.reredirect(null, e.getLocalizedMessage());
				return null;
			}
		}
		
		
		
		/** (7) 농장정보 입력 후 페이지 이동 */
		sqlSession.close();
		String url = "%s/admin/users/admin_user_info.do?useridx=%d";
		logger.debug("url", url);
		url = String.format(url, web.getRootPath(), useridx);
		web.reredirect(url, "농장 정보가 저장되었습니다.");
		
		
		
		return null;
	}
	

}
