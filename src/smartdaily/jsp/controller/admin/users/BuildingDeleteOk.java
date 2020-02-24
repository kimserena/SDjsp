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
import smartdaily.jsp.model.Buildings;
import smartdaily.jsp.service.BuildingsService;
import smartdaily.jsp.service.impl.BuildingsServiceImpl;

/**
 * Servlet implementation class BuildingDeleteOk
 */
@WebServlet("/admin/users/building_delete_ok.do")
public class BuildingDeleteOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -751631221409329757L;
	/** (1) 사용하고자 하는 Helper+Service 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	BuildingsService buildingsService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2) 사용하고자 하는 Helper+Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		buildingsService = new BuildingsServiceImpl(sqlSession, logger);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중이 아니라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("adminLoginInfo")==null) {
			web.reredirect(web.getRootPath() + "/admin/users/admin_login.do", "관리자님 로그인 해 주세요.");
			return null;
		}
		
		/** (4) 파라미터 받기 */
		int locationid = web.getInt("locationid");
		int useridx = web.getInt("useridx");
		int buildingid = web.getInt("buildingid");
		
		if(buildingid==0) {
			web.reredirect(null, "돈사 번호가 지정되지 않았습니다.");
			sqlSession.close();
			return null;
		}
		
		logger.debug("locationid = " + locationid);
		logger.debug("useridx = " + useridx);
		logger.debug("buildingid = " + buildingid);
		
		/** (5) 삭제할 돈사에 대한 Beans 생성 / 삭제처리 */
		Buildings buildings = new Buildings();
		buildings.setBuildingid(buildingid);
		
		try {
			buildingsService.deleteBuildings(buildings);
		}catch (Exception e) {
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}finally {
			sqlSession.close();
		}
		
		/** (6) 삭제 후 농장 상세보기 페이지로 다시 이동 */
		String url = "%s/admin/users/locations_info.do?useridx=%s&locationid=%s";
		url = String.format(url, web.getRootPath(), useridx, locationid);
		
		web.reredirect(url, "돈사가 삭제 되었습니다.");
		
		return null;
	}
	

}
