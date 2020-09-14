package kr.mem.model;

public class MemberVO {

	private int num; 
	private String name; //table에 있는 
	private String phone;
	private String addr;
	private double lat;
	private double lng;
	
	public MemberVO() {
		//default 생성자 	
	}

	



	public MemberVO(String name, String phone, String addr) {
		this.name = name;
		this.phone = phone;
		this.addr = addr;
	}





	public MemberVO(int num, String name, String phone, String addr, double lat, double lng) {
		this.num = num;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.lat = lat;
		this.lng = lng;
	}





	@Override //toString 메소드 >> 디버깅? 데이터가 잘들어있는지 안들어 있는지 확인을 해볼때 필요함 유용한 정도?? 
	public String toString() {
		return "MemberVO [num=" + num + ", name=" + name + ", phone=" + phone + ", addr=" + addr + ", lat=" + lat
				+ ", lng=" + lng + "]";
	}













	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
	
	
	
	
	
	
	
}
