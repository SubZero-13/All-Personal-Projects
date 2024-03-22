package com.nagarro.Mini_Assignment_2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	private String name;
	private int age;
	private String gender;
	private String dob;
	private String nationality;
	private String verificationStatus;
	private String dateCreated;
	private String dateModified;

	public User() {
	}

	public User(Long userId, String name, int age, String gender, String dob, String nationality,
			String verificationStatus, String dateCreated, String dateModified) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
		this.nationality = nationality;
		this.verificationStatus = verificationStatus;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getDateModified() {
		return dateModified;
	}

	public void setDateModified(String dateModified) {
		this.dateModified = dateModified;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", age=" + age + ", gender=" + gender + ", dob=" + dob
				+ ", nationality=" + nationality + ", verificationStatus=" + verificationStatus + ", dateCreated="
				+ dateCreated + ", dateModified=" + dateModified + ", getUserId()=" + getUserId() + ", getName()="
				+ getName() + ", getAge()=" + getAge() + ", getGender()=" + getGender() + ", getNationality()="
				+ getNationality() + ", getVerificationStatus()=" + getVerificationStatus() + ", getDob()=" + getDob()
				+ ", getDateCreated()=" + getDateCreated() + ", getDateModified()=" + getDateModified()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	

}
