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
 * Servlet implementation class FarmViewDeleteOk
 */
@WebServlet("/admin/users/farm_view_delete_ok.do")
public class FarmViewDeleteOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6633515689366039445L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
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
		
		/** (4) 유저 번호 파라미터 받기 */
		int useridx = web.getInt("useridx");
		int locationid = web.getInt("locationid");
		
		if(useridx == 0) {
			sqlSession.close();
			web.reredirect(null, "유저번호가 없습니다.");
			return null;
		}
		
		if(locationid == 0) {
			sqlSession.close();
			web.reredirect(null, "농장번호가 없습니다.");
			return null;
		}
		
		logger.debug("useridx = " + useridx);
		logger.debug("locationid = " + locationid);
		
		/** (5) 조회할 정보에 대한 Beans 생성 */
		Assignments assign = new Assignments();
		assign.setUseridx(useridx);
		assign.setLocationid(locationid);
		
		/** (6) service를 이용해 DB의 정보 삭제처리 */
		try {
			assignmentsService.deleteGuestAssignments(assign);
		}catch (Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		/** (7) 농장권한정보 수정 후 서브아이디 상세보기 페이지로 다시 이동 */
		String url = "%s/admin/users/farm_view_set.do?useridx=%s";
		url = String.format(url, web.getRootPath(), useridx);
		
		web.reredirect(url, "권한정보가 삭제 되었습니다.");
		
		return null;
	}
	

}
