package smartdaily.jsp.service;

import java.util.List;

import smartdaily.jsp.model.Buildings;

public interface BuildingsService {
	
	public void insertBuildings(Buildings buildings) throws Exception;
	
	public List<Buildings> selectBuildingsList(Buildings buildings) throws Exception;
	
	public void deleteBuildings(Buildings buildings) throws Exception;
	
	public void deleteLocationBuildings(Buildings buildings) throws Exception;

}
