package com.nagarro.Mini_Assignment_2.dtos;

public class UserResponse {
	private String name;
	private String dob;
	private String gender;
	private int age;
	private String nationality;
	private String verificationStatus;
	
	public UserResponse() {
		
	}

	public UserResponse(String name, String dob, String gender, int age, String nationality,
			String verificationStatus) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender = gender;
		this.age = age;
		this.nationality = nationality;
		this.verificationStatus = verificationStatus;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

}
