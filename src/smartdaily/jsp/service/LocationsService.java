package smartdaily.jsp.service;

import java.util.List;

import smartdaily.jsp.model.Locations;

public interface LocationsService {
	
	public void insertLocations(Locations locations) throws Exception;
	
	public List<Locations> selectLocationsList(Locations locations) throws Exception;
	
	public Locations selectLocations(Locations locations) throws Exception;
	
	public void deleteLocations(Locations locations) throws Exception;
	
	public void updateLocations(Locations locations) throws Exception;
	
	

}
