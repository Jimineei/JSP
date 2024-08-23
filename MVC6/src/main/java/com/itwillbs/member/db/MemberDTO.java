package com.itwillbs.member.db;

/*MemberDTO : 회원정보를 저장하는 객체
 *DTO(Data Transfer Object)
 * xxxxxAction 객체 <-> DB사이에서 정보를 이동시키는 객체
 * ->회원정보 테이블 정보를 모두 저장가능한 객체
 * ->테이블의 컬럼명과 객체의 변수명이 같음
 * */
public class MemberDTO {
	
	
	private String id;
	private String pw;
	private String name;
	private String gender;
	private int age;
	private String email;
	private java.sql.Timestamp regdate;
	
	
	//alt + shift + s + s
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public java.sql.Timestamp getRegdate() {
		return regdate;
	}


	public void setRegdate(java.sql.Timestamp regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "MemerDTO [id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", email=" + email + "]";
	}
	
	
}
