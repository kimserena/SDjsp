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
 * Servlet implementation class AdminSubInsertOk
 */
@WebServlet("/admin/users/admin_sub_insert_ok.do")
public class AdminSubInsertOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1151285929174492573L;
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
		String userid = web.getString("userid");
		String name = web.getString("name");
		String pw = web.getString("pw");
		String pw_re = web.getString("pw_re");
		
		logger.debug("useridx = " + useridx);
		logger.debug("userid = " + userid);
		logger.debug("name = " + name);
		logger.debug("pw = " + pw);
		logger.debug("pw_re = " + pw_re);
		
		/** (5)입력값의 유효성 검사 */
		// 비밀번호 확인
		if(!pw.equals(pw_re)){
		    sqlSession.close();
			web.reredirect(null, "비밀번호 확인이 잘못되었습니다.");
			return null;
	    }
		
		/** (6)전달받은 파라미터를 Beans 객체에 담는다. */
		Users users = new Users();
		users.setUserid(userid);
		users.setName(name);
		users.setPw(pw_re);
		users.setMasterid(useridx);
		
		logger.debug("users >> " + users.toString());
		
		/** (7)Service를 통한 데이터베이스 저장 처리 */
		
		
		
		try {
			usersService.insertUsersSubID(users);
		}catch(Exception e) {
			
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}
		
		// insert한 subid의 useridx값 받아오기
		int insert_idx = users.getUseridx();
		
		logger.debug("insert_idx = " + insert_idx);
		
		// subid를 소유한 농장주의 농장에 대한 권한정보 등록
		Locations locations = new Locations();
		locations.setloca_useridx(useridx);
		
		List<Locations> locationsList = null;
		
		try {
			locationsList = locationsService.selectLocationsList(locations);
		}catch(Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}
		
		logger.debug("locationsList : " + locationsList);
		
		for(int i=0; i<locationsList.size(); i++) {
			Locations loca = locationsList.get(i);
			int locationid = loca.getLocationid();
			logger.debug("locationid = " + locationid);
			Assignments assign = new Assignments();
			assign.setUseridx(insert_idx);
			assign.setLocationid(locationid);
			try {
				
				
				assignmentsService.insertAssignmentsSubid(assign);
			}catch (Exception e) {
				web.reredirect(null, e.getLocalizedMessage());
				return null;
			}
		}
		
		/** (8)서브아이디 생성이 완료되었으므로 메인페이지로 이동 */
		sqlSession.close();
		String url = "%s/admin/users/admin_user_info.do?useridx=%d";
		logger.debug("url", url);
		url = String.format(url, web.getRootPath(), useridx);
		web.reredirect(url, "서브아이디가 생성되었습니다.");
		
		return null;
	}
	

}
