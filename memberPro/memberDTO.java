package dto;

public class memberDTO {
	//캡슐: 외부 클래스에서 접근을 막는다 = private
	private int num;
	private String username;
	private String tel;
	private String email;
	private String birth;
	private String gender;
	private String writedate;
	
	public memberDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
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



	public String getBirth() {
		return birth;
	}



	public void setBirth(String birth) {
		this.birth = birth;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getWritedate() {
		return writedate;
	}



	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}

}
