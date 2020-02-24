package smartdaily.jsp.controller.admin.index;

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
import smartdaily.jsp.helper.PageHelper;
import smartdaily.jsp.helper.WebHelper;
import smartdaily.jsp.model.Board;
import smartdaily.jsp.model.Users;
import smartdaily.jsp.service.BoardService;
import smartdaily.jsp.service.UsersService;
import smartdaily.jsp.service.impl.BoardServiceImpl;
import smartdaily.jsp.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class AdminIndex
 */
@WebServlet("/admin/index/admin_index.do")
public class AdminIndex extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1806161205357263579L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	PageHelper pageHelper;
	UsersService usersService;
	

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		pageHelper = PageHelper.getInstance();
		usersService = new UsersServiceImpl(sqlSession, logger);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("adminLoginInfo")==null) {
			web.reredirect(web.getRootPath() + "/admin/users/admin_login.do", "관리자님 로그인 해 주세요.");
			return null;
		}
		
		/** (4) 검색어 파라미터 받기 */
		String keyword = web.getString("keyword");
		logger.debug("keyword = " + keyword);
		
		/** (5) 조회할 정보에 대한 Beans 생성 */
		// 현재 페이지 수 --> 기본값은 1페이지로 설정
		int page = web.getInt("page", 1);
		
		Users users = new Users();
		users.setUserid(keyword);
		
		int totalCount = 0;
		List<Users> newUserList = null;
		
		try {
			// 전체 게시물 수 
			totalCount = usersService.selectNewUsersCount(users);
			// 나머지 페이지 번호 계산하기 
			pageHelper.pageProcess(page, totalCount, 10, 5);
			
			// 페이지 번호 계산 결과에서 Limit절에 필요한 값을 Beans에 추가
			users.setLimit_start(pageHelper.getLimit_start());
			users.setList_count(pageHelper.getList_count());
			
			newUserList = usersService.selectAdminNewUserList(users);
		}catch(Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		/** (6) 조회 결과를 View에 전달 */
		request.setAttribute("keyword", keyword);
		request.setAttribute("newUserList", newUserList);
		request.setAttribute("pageHelper", pageHelper);
		
		return "admin/index/admin_index";
	}
	

}
