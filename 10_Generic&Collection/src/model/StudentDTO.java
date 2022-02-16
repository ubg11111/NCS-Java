package model;

/*
 * [문제] Ex04 클래스처럼 키보드로 학생 수를 입력을 받고
 * 		 입력 받은 학생 수 만큼의 정보를 키보드로 입력을 받아서
 * 		 ArrayList에 정보를 저장 후 화면에 출력해 보세요.
 * 		 (단, 학생의 정보는 학번, 이름, 학과, 연락처, 주소)
 */

public class StudentDTO {
	
	private int huckbun;
	private String name;
	private String major;
	private String phone;
	private String addres;
	
	
	
	public StudentDTO(int huckbun, String name, String major, String phone , String addres){ // 매개변수 생성자
		this.huckbun = huckbun;
		this.name = name;
		this.major = major;
		this.phone = phone;
		this.addres = addres;
	}


	public int getHuckbun() {
		return huckbun;
	}

	public void setHuckbun(int huckbun) {
		this.huckbun = huckbun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

}
