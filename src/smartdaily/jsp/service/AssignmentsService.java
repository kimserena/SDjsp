package smartdaily.jsp.service;

import java.util.List;

import smartdaily.jsp.model.Assignments;

public interface AssignmentsService {
	
	public void insertAssignmentsSubid(Assignments assignments) throws Exception;
	
	public List<Assignments> selectAssignmentsJoinLocationsAndUsersList(Assignments assignments) throws Exception;
	
	public void updateAssignmentsSubid(Assignments assignments) throws Exception;
	
	public void deleteAssignmentsSubid(Assignments assignments) throws Exception;
	
	public void deleteAssignmentsLocations(Assignments assignments) throws Exception;
	
	public void deleteGuestAssignments(Assignments assignments) throws Exception;
	
	public void insertGuestAssignments(Assignments assignments) throws Exception;
	
	public void selectGuestAssignmentsCount(Assignments assignments) throws Exception;

}
