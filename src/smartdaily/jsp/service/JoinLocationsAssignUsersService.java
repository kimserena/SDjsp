package smartdaily.jsp.service;

import java.util.List;

import smartdaily.jsp.model.JoinLocationsAssignUsers;

public interface JoinLocationsAssignUsersService {
	
	public List<JoinLocationsAssignUsers> selectJoinLocationsAssignUsersList(JoinLocationsAssignUsers joinLocationsAssignUsers) throws Exception;
	public List<JoinLocationsAssignUsers> selectFarmUsersList(JoinLocationsAssignUsers joinLocationsAssignUsers) throws Exception;
	public List<JoinLocationsAssignUsers> selectSubcontractorList(JoinLocationsAssignUsers joinLocationsAssignUsers) throws Exception;

}
