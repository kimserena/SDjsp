package smartdaily.jsp.model;

public class Board {
	private int idx;
	private String cate;
	private String inquire_cate;
	private String writer;
	private int writer_useridx;
	private String content;
	private String regdate;
	private String editdate;
	private String board_ipaddress;
	private int board_confirm;
	private String subject;
	private String designation;
	private String tel;
	private String email;
	private String postcode;
	private String address1;
	private String address2;
	
	// 페이지 구현을 위해서 추가된 값
	private int limit_start;
	private int list_count;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCate() {
		return cate;
	}
	public void setCate(String cate) {
		this.cate = cate;
	}
	public String getInquire_cate() {
		return inquire_cate;
	}
	public void setInquire_cate(String inquire_cate) {
		this.inquire_cate = inquire_cate;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getWriter_useridx() {
		return writer_useridx;
	}
	public void setWriter_useridx(int writer_useridx) {
		this.writer_useridx = writer_useridx;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getEditdate() {
		return editdate;
	}
	public void setEditdate(String editdate) {
		this.editdate = editdate;
	}
	public String getBoard_ipaddress() {
		return board_ipaddress;
	}
	public void setBoard_ipaddress(String board_ipaddress) {
		this.board_ipaddress = board_ipaddress;
	}
	public int getBoard_confirm() {
		return board_confirm;
	}
	public void setBoard_confirm(int board_confirm) {
		this.board_confirm = board_confirm;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
		return "Board [idx=" + idx + ", cate=" + cate + ", inquire_cate=" + inquire_cate + ", writer=" + writer
				+ ", writer_useridx=" + writer_useridx + ", content=" + content + ", regdate=" + regdate + ", editdate="
				+ editdate + ", board_ipaddress=" + board_ipaddress + ", board_confirm=" + board_confirm + ", subject="
				+ subject + ", designation=" + designation + ", tel=" + tel + ", email=" + email + ", postcode="
				+ postcode + ", address1=" + address1 + ", address2=" + address2 + ", limit_start=" + limit_start
				+ ", list_count=" + list_count + "]";
	}
	
	
	
	
	
	
	
	

}
