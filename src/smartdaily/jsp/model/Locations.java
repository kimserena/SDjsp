package smartdaily.jsp.model;

public class Locations {
	private int locationid;
	private String locationname;
	private String location;
	private int locationsort;
	private int loca_useridx;
	
	// getter setter
	public int getLocationid() {
		return locationid;
	}
	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
	public String getLocationname() {
		return locationname;
	}
	public void setLocationname(String locationname) {
		this.locationname = locationname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getLocationsort() {
		return locationsort;
	}
	public void setLocationsort(int locationsort) {
		this.locationsort = locationsort;
	}
	public int getloca_useridx() {
		return loca_useridx;
	}
	public void setloca_useridx(int loca_useridx) {
		this.loca_useridx = loca_useridx;
	}
	
	// toString
	@Override
	public String toString() {
		return "Locations [locationid=" + locationid + ", locationname=" + locationname + ", location=" + location
				+ ", locationsort=" + locationsort + ", loca_useridx=" + loca_useridx + "]";
	}
	
	

}
