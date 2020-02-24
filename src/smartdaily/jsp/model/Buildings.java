package smartdaily.jsp.model;

public class Buildings {
	private int buildingid;
	private String buildingname;
	private int locationid;
	private int areasize;
	
	// getter setter
	public int getBuildingid() {
		return buildingid;
	}
	public void setBuildingid(int buildingid) {
		this.buildingid = buildingid;
	}
	public String getBuildingname() {
		return buildingname;
	}
	public void setBuildingname(String buildingname) {
		this.buildingname = buildingname;
	}
	public int getLocationid() {
		return locationid;
	}
	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
	public int getAreasize() {
		return areasize;
	}
	public void setAreasize(int areasize) {
		this.areasize = areasize;
	}
	
	//toString
	@Override
	public String toString() {
		return "Buildings [buildingid=" + buildingid + ", buildingname=" + buildingname + ", locationid=" + locationid
				+ ", areasize=" + areasize + "]";
	}
	
	
		
	


}
