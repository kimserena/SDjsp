package smartdaily.jsp.model;

public class Assignments {
	private int idx;
	private int useridx;
	private int locationid;
	private int level;
	
	
	private String locationname;
	private String location;
	private int loca_useridx;
	
	// getter setter
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getUseridx() {
		return useridx;
	}
	public void setUseridx(int useridx) {
		this.useridx = useridx;
	}
	public int getLocationid() {
		return locationid;
	}
	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
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
	public int getLoca_useridx() {
		return loca_useridx;
	}
	public void setLoca_useridx(int loca_useridx) {
		this.loca_useridx = loca_useridx;
	}
	@Override
	public String toString() {
		return "Assignments [idx=" + idx + ", useridx=" + useridx + ", locationid=" + locationid + ", level=" + level
				+ ", locationname=" + locationname + ", location=" + location + ", loca_useridx=" + loca_useridx + "]";
	}
	
	
	
	
	

}
