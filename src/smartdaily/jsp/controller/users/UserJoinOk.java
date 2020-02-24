package smartdaily.jsp.controller.users;

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
import smartdaily.jsp.helper.RegexHelper;
import smartdaily.jsp.helper.WebHelper;
import smartdaily.jsp.model.Users;
import smartdaily.jsp.service.UsersService;
import smartdaily.jsp.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class UserJoinOk
 */
@WebServlet("/users/user_join_ok.do")
public class UserJoinOk extends BaseController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2068761688168700220L;
	/** (1) 사용하고자 하는 Helper 객체 선언 */
	Logger logger;
	SqlSession sqlSession;
	WebHelper web;
	RegexHelper regex;
	UsersService usersService;

	@Override
	public String doRun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/** (2)사용하고자 하는 Helper + Service 객체 생성 */
		logger = LogManager.getFormatterLogger(request.getRequestURI());
		sqlSession = MybatisConnectionFactory.getSqlSession();
		web = WebHelper.getInstance(request, response);
		regex = RegexHelper.getInstance();
		usersService = new UsersServiceImpl(sqlSession, logger);
		
		/** (3)로그인 여부 검사 */
		// 로그인 중 이라면 이페이지를 동작 시켜서는 안된다.
		if(web.getSession("loginInfo")!=null){
			web.reredirect(web.getRootPath() + "/index.do", "이미 로그인 하셨습니다.");
			return null;
		}
		
		/** (4)파라미터 받기 */
		int usertype = web.getInt("usertype");
		String userid = web.getString("userid");
		String name = web.getString("name");
		String pw = web.getString("pw");
		String pw_re = web.getString("pw_re");
		String companyname = web.getString("companyname");
		String ceoname = web.getString("ceoname");
		String companyno = web.getString("companyno");
		String corpregistno = web.getString("corpregistno");
		String busicondition = web.getString("busicondition");
		String cateofbusiness = web.getString("cateofbusiness");
		
		String hyphen = "-";
		String compFax1 = web.getString("compFax1");
		String compFax2 = web.getString("compFax2");
		String compFax3 = web.getString("compFax3");
		
		String compFax = compFax1.concat(hyphen).concat(compFax2).concat(hyphen).concat(compFax3);
		
		String postcode = web.getString("postcode");
		String address11 = web.getString("address11");
		String address22 = web.getString("address22");
		
		String responsiblename = web.getString("responsiblename");
		
		String mngMail1 = web.getString("mngMail1");
		String center1 = "@";
		String mngMail2 = web.getString("mngMail2");
		
		String mngMail = mngMail1.concat(center1).concat(mngMail2);
		
		String responsibletel1 = web.getString("responsibletel1");
		String responsibletel2 = web.getString("responsibletel2");
		String responsibletel3 = web.getString("responsibletel3");
		
		String responsibletel = responsibletel1.concat(hyphen).concat(responsibletel2).concat(hyphen).concat(responsibletel3);
		
		String responsiblesellphon1 = web.getString("responsiblesellphon1");
		String responsiblesellphon2 = web.getString("responsiblesellphon2");
		String responsiblesellphon3 = web.getString("responsiblesellphon3");
		
		String responsiblesellphon = responsiblesellphon1.concat(hyphen).concat(responsiblesellphon2).concat(hyphen).concat(responsiblesellphon3);
		
		// 전달받은 파라미터는 값의 정상여부 확인을 위한 로그
		logger.debug("usertype = " + usertype);
		logger.debug("userid = " + userid);
		logger.debug("name = " + name);
		logger.debug("pw = " + pw);
		logger.debug("pw_re = " + pw_re);
		logger.debug("companyname = " + companyname);
		logger.debug("ceoname = " + ceoname);
		logger.debug("companyno = " + companyno);
		logger.debug("corpregistno = " + corpregistno);
		logger.debug("busicondition = " + busicondition);
		logger.debug("cateofbusiness = " + cateofbusiness);
		logger.debug("compFax = " + compFax);
		logger.debug("postcode = " + postcode);
		logger.debug("address11 = " + address11);
		logger.debug("address22 = " + address22);
		logger.debug("responsiblename = " + responsiblename);
		logger.debug("mngMail = " + mngMail);
		logger.debug("responsibletel = " + responsibletel);
		logger.debug("responsiblesellphon = " + responsiblesellphon);
		
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
		users.setCompanyname(companyname);
		users.setCeoname(ceoname);
		users.setCompanyno(companyno);
		users.setCorpregistno(corpregistno);
		users.setBusicondition(busicondition);
		users.setCateofbusiness(cateofbusiness);
		users.setFax(compFax);
		users.setPostcode(postcode);
		users.setAddress1(address11);
		users.setAddress2(address22);
		users.setResponsiblename(responsiblename);
		users.setResponsibleemail(mngMail);
		users.setResponsibletel(responsibletel);
		users.setResponsiblesellphon(responsiblesellphon);
		users.setUsertype(usertype);
		logger.debug("users >> " + users.toString());
		
		
		/** (7)Service를 통한 데이터베이스 저장 처리 */
		try {
			usersService.insertUsers(users);
		}catch(Exception e) {
			sqlSession.close();
			web.reredirect(null, e.getLocalizedMessage());
			return null;
		}
		
		/** (8)가입이 완료되었으므로 메인페이지로 이동 */
		web.reredirect(web.getRootPath() + "/index.do", "회원가입이 완료 되었습니다.");
		
		return null;
	}
	

}
