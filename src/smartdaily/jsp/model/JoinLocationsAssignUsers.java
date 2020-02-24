package smartdaily.jsp.model;

public class JoinLocationsAssignUsers {
	private int useridx;
	private int usertype;
	private int userlevel;
	private String companyname;
	
	private int locationid;
	private String locationname;
	private String location;
	private int locationsort;
	private int loca_useridx;
	
	private int idx;
	private int level;
	
	public int getUseridx() {
		return useridx;
	}
	public void setUseridx(int useridx) {
		this.useridx = useridx;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public int getUserlevel() {
		return userlevel;
	}
	public void setUserlevel(int userlevel) {
		this.userlevel = userlevel;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
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
	public int getLoca_useridx() {
		return loca_useridx;
	}
	public void setLoca_useridx(int loca_useridx) {
		this.loca_useridx = loca_useridx;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	@Override
	public String toString() {
		return "JoinLocationsAssignUsers [useridx=" + useridx + ", usertype=" + usertype + ", userlevel=" + userlevel
				+ ", companyname=" + companyname + ", locationid=" + locationid + ", locationname=" + locationname
				+ ", location=" + location + ", locationsort=" + locationsort + ", loca_useridx=" + loca_useridx
				+ ", idx=" + idx + ", level=" + level + "]";
	}
	
	

}
