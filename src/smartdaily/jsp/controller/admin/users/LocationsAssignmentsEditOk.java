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
import smartdaily.jsp.service.AssignmentsService;
import smartdaily.jsp.service.impl.AssignmentsServiceImpl;

/**
 * Servlet implementation class LocationsAssignmentsEditOk
 */
@WebServlet("/admin/users/locations_assignments_edit_ok.do")
public class LocationsAssignmentsEditOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4326388286177739880L;
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	AssignmentsService assignmentsService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2)사용하고자 하는 Helper + Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		assignmentsService = new AssignmentsServiceImpl(sqlSession, logger);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("adminLoginInfo")==null) {
			web.reredirect(web.getRootPath() + "/admin/users/admin_login.do", "관리자님 로그인 해 주세요.");
			return null;
		}
		
		/** (4) 권한 수정에 필요한 파라미터 받기 */
		int useridx = web.getInt("useridx");
		int sub_useridx = web.getInt("sub_useridx");
		int locationid = web.getInt("locationid");
		int level = web.getInt("level");
		
		logger.debug("useridx = " + useridx);
		logger.debug("sub_useridx = " + sub_useridx);
		logger.debug("locationid = " + locationid);
		logger.debug("level = " + level);
		
		/** (5)입력값의 유효성 검사 */
		if(sub_useridx == 0) {
			sqlSession.close();
			web.reredirect(null, "서브아이디번호가 지정되지 않았습니다.");
			return null;
		}
		
		if(locationid == 0) {
			sqlSession.close();
			web.reredirect(null, "농장번호가 지정되지 않았습니다.");
			return null;
		}
		
		/** (6)전달받은 파라미터를 Beans 객체에 담는다. */
		Assignments assign = new Assignments();
		assign.setUseridx(sub_useridx);
		assign.setLocationid(locationid);
		assign.setLevel(level);
		
		/** (7)Service를 통한 데이터베이스 저장 처리 */
		try {
			assignmentsService.updateAssignmentsSubid(assign);
		}catch(Exception e) {
			sqlSession.close();
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/** (8) 농장권한정보 수정 후 서브아이디 상세보기 페이지로 다시 이동 */
		String url = "%s/admin/users/subid_read.do?sub_useridx=%s&useridx=%s";
		url = String.format(url, web.getRootPath(), sub_useridx, useridx);
		
		web.reredirect(url, "농장 권한정보가 수정 되었습니다.");
		
		return null;
	}
	

}
