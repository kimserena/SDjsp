package smartdaily.jsp.model;

public class Users {
	private int useridx;
	private String userid;
	private String pw;
	private String re_pw;
	private String name;
	private int usertype;
	private int masterid;
	private int userlevel;
	private String companyname;
	private String ceoname;
	private String companyno;
	private String corpregistno;
	private String busicondition;
	private String cateofbusiness;
	private String fax;
	private String postcode;
	private String address1;
	private String address2;
	private String responsiblename;
	private String responsibleemail;
	private String responsibletel;
	private String responsiblesellphon;
	
	// 페이지 구현을 위해서 추가된 값
	private int limit_start;
	private int list_count;
	
	
	public int getUseridx() {
		return useridx;
	}
	public void setUseridx(int useridx) {
		this.useridx = useridx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getRe_pw() {
		return re_pw;
	}
	public void setRe_pw(String re_pw) {
		this.re_pw = re_pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public int getMasterid() {
		return masterid;
	}
	public void setMasterid(int masterid) {
		this.masterid = masterid;
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
	public String getCeoname() {
		return ceoname;
	}
	public void setCeoname(String ceoname) {
		this.ceoname = ceoname;
	}
	public String getCompanyno() {
		return companyno;
	}
	public void setCompanyno(String companyno) {
		this.companyno = companyno;
	}
	public String getCorpregistno() {
		return corpregistno;
	}
	public void setCorpregistno(String corpregistno) {
		this.corpregistno = corpregistno;
	}
	public String getBusicondition() {
		return busicondition;
	}
	public void setBusicondition(String busicondition) {
		this.busicondition = busicondition;
	}
	public String getCateofbusiness() {
		return cateofbusiness;
	}
	public void setCateofbusiness(String cateofbusiness) {
		this.cateofbusiness = cateofbusiness;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getResponsiblename() {
		return responsiblename;
	}
	public void setResponsiblename(String responsiblename) {
		this.responsiblename = responsiblename;
	}
	public String getResponsibleemail() {
		return responsibleemail;
	}
	public void setResponsibleemail(String responsibleemail) {
		this.responsibleemail = responsibleemail;
	}
	public String getResponsibletel() {
		return responsibletel;
	}
	public void setResponsibletel(String responsibletel) {
		this.responsibletel = responsibletel;
	}
	public String getResponsiblesellphon() {
		return responsiblesellphon;
	}
	public void setResponsiblesellphon(String responsiblesellphon) {
		this.responsiblesellphon = responsiblesellphon;
	}
	public int getLimit_start() {
		return limit_start;
	}
	public void setLimit_start(int limit_start) {
		this.limit_start = limit_start;
	}
	public int getList_count() {
		return list_count;
	}
	public void setList_count(int list_count) {
		this.list_count = list_count;
	}
	@Override
	public String toString() {
		return "Users [useridx=" + useridx + ", userid=" + userid + ", pw=" + pw + ", re_pw=" + re_pw + ", name=" + name
				+ ", usertype=" + usertype + ", masterid=" + masterid + ", userlevel=" + userlevel + ", companyname="
				+ companyname + ", ceoname=" + ceoname + ", companyno=" + companyno + ", corpregistno=" + corpregistno
				+ ", busicondition=" + busicondition + ", cateofbusiness=" + cateofbusiness + ", fax=" + fax
				+ ", postcode=" + postcode + ", address1=" + address1 + ", address2=" + address2 + ", responsiblename="
				+ responsiblename + ", responsibleemail=" + responsibleemail + ", responsibletel=" + responsibletel
				+ ", responsiblesellphon=" + responsiblesellphon + ", limit_start=" + limit_start + ", list_count="
				+ list_count + "]";
	}
	
	
	
	
	
	
	
	
	
	


}
