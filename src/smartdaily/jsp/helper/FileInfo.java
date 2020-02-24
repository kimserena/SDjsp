package smartdaily.jsp.helper;

/**
 * 업로드 된 파일의 정보를 저장하기 위한 JavaBeans
 * - 이 클래스의 객체가 업로드 된 파일의 수 만큼 생성되어 List 형태로 보관된다.
 */
public class FileInfo {
	private String field_name; 	 			// <input type="file">의 name속성
	private String origin_name; 				// 원본 파일 이름
	private String file_dir; 				// 파일이 저장되어 있는 서버상의 경로
	private String file_name; 				// 서버상의 파일 이름
	private String content_type; 			// 파일의 형식
	private long file_size; 					// 파일의 용량
	private int img_busstop_index;
	public String getField_name() {
		return field_name;
	}
	public void setField_name(String field_name) {
		this.field_name = field_name;
	}
	public String getOrigin_name() {
		return origin_name;
	}
	public void setOrigin_name(String origin_name) {
		this.origin_name = origin_name;
	}
	public String getFile_dir() {
		return file_dir;
	}
	public void setFile_dir(String file_dir) {
		this.file_dir = file_dir;
	}
	public String getFile_name() {
		return file_name;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public String getContent_type() {
		return content_type;
	}
	public void setContent_type(String content_type) {
		this.content_type = content_type;
	}
	public long getFile_size() {
		return file_size;
	}
	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}
	public int getImg_busstop_index() {
		return img_busstop_index;
	}
	public void setImg_busstop_index(int img_busstop_index) {
		this.img_busstop_index = img_busstop_index;
	}
	@Override
	public String toString() {
		return "FileInfo [field_name=" + field_name + ", origin_name=" + origin_name + ", file_dir=" + file_dir
				+ ", file_name=" + file_name + ", content_type=" + content_type + ", file_size=" + file_size
				+ ", img_busstop_index=" + img_busstop_index + "]";
	}
	
	
	
	

}