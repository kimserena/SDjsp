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
import smartdaily.jsp.model.Users;
import smartdaily.jsp.service.AssignmentsService;
import smartdaily.jsp.service.UsersService;
import smartdaily.jsp.service.impl.AssignmentsServiceImpl;
import smartdaily.jsp.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class SubDeleteOk
 */
@WebServlet("/admin/users/sub_delete_ok.do")
public class SubDeleteOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4303059925366012112L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	UsersService usersService;
	AssignmentsService assignmentsService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		usersService = new UsersServiceImpl(sqlSession, logger);
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
		
		if(sub_useridx==0) {
			web.reredirect(null, "서브아이디 번호가 지정되지 않았습니다.");
			sqlSession.close();
			return null;
		}
		
		logger.debug("useridx = " + useridx);
		logger.debug("sub_useridx = " + sub_useridx);
		
		/** (5) 삭제할 정보에 대한 Beans 생성 */
		Users users = new Users();
		users.setUseridx(sub_useridx);
		
		Assignments assign = new Assignments();
		assign.setUseridx(sub_useridx);
		
		/** (7)Service를 통한 데이터베이스 삭제 처리 */
		try {
			assignmentsService.deleteAssignmentsSubid(assign);
			usersService.deleteUsersSubID(users);
			
		}catch (Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		
		/** (8) 서브아이디 삭제 후 유저 상세보기 페이지로 다시 이동 */
		String url = "%s/admin/users/admin_user_info.do?useridx=%s";
		url = String.format(url, web.getRootPath(), useridx);
		
		web.reredirect(url, "서브아이디가 삭제 되었습니다.");
		
		
		return null;
	}
	

}
