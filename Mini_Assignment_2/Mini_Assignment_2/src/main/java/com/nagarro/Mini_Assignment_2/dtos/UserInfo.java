package com.nagarro.Mini_Assignment_2.dtos;

import lombok.Data;

@Data
public class UserInfo {
	private String gender;
	private Name name;
	private Location location;
	private String email;
	private Login login;
	private DateOfBirth dob;
	private RegisteredInfo registered;
	private String phone;
	private String cell;
	private Identification id;
	private UserPicture picture;
	private String nat;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public DateOfBirth getDob() {
		return dob;
	}

	public void setDob(DateOfBirth dob) {
		this.dob = dob;
	}

	public RegisteredInfo getRegistered() {
		return registered;
	}

	public void setRegistered(RegisteredInfo registered) {
		this.registered = registered;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public Identification getId() {
		return id;
	}

	public void setId(Identification id) {
		this.id = id;
	}

	public UserPicture getPicture() {
		return picture;
	}

	public void setPicture(UserPicture picture) {
		this.picture = picture;
	}

	public String getNat() {
		return nat;
	}

	public void setNat(String nat) {
		this.nat = nat;
	}

	@Override
	public String toString() {
		return "UserInfo [gender=" + gender + ", name=" + name + ", location=" + location + ", email=" + email
				+ ", login=" + login + ", dob=" + dob + ", registered=" + registered + ", phone=" + phone + ", cell="
				+ cell + ", id=" + id + ", picture=" + picture + ", nat=" + nat + ", getGender()=" + getGender()
				+ ", getName()=" + getName() + ", getLocation()=" + getLocation() + ", getEmail()=" + getEmail()
				+ ", getLogin()=" + getLogin() + ", getDob()=" + getDob() + ", getRegistered()=" + getRegistered()
				+ ", getPhone()=" + getPhone() + ", getCell()=" + getCell() + ", getId()=" + getId() + ", getPicture()="
				+ getPicture() + ", getNat()=" + getNat() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
