package smartdaily.jsp.service;

import java.util.List;

import smartdaily.jsp.model.Users;

public interface UsersService {
	// userid 중복검사
	public void selectUserIdCount(Users users) throws Exception;
	// 사업자등록번호 중복검사
	public void selectCompanynoCount(Users users) throws Exception;
	// 법인등록번호 중복검사
	public void selectCorpregistnoCount(Users users) throws Exception;
	// 회원정보 등록
	public void insertUsers(Users users) throws Exception;
	//
	public Users selectLoginInfo(Users users) throws Exception;
	
	public Users selectUsers(Users users) throws Exception;
	
	public void updateUsers(Users users) throws Exception;
	
	public Users selectAdminLoginInfo(Users users) throws Exception;
	
	public List<Users> selectAdminUserList(Users users) throws Exception;
	
	public int selectUsersCount(Users users) throws Exception;
	
	public List<Users> selectUserSubidList(Users users) throws Exception;
	
	public void insertUsersSubID(Users users) throws Exception;
	
	public void updateUsersSubID(Users users) throws Exception;
	
	public void deleteUsersSubID(Users users) throws Exception;
	
    public List<Users> selectAdminNewUserList(Users users) throws Exception;
	
	public int selectNewUsersCount(Users users) throws Exception;
	
	public void updateNewUsers(Users users) throws Exception;
	
	public void updateSuspendUseUsers(Users users) throws Exception;
	
    public List<Users> selectAdminSuspendUseUserList(Users users) throws Exception;
	
	public int selectSuspendUseUsersCount(Users users) throws Exception;

}
