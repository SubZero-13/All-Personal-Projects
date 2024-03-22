package com.nagarro.Mini_Assignment_2.dtos;

import lombok.Data;
import java.util.Date;

@Data
public class DateOfBirth {
    private Date date;
    private int age;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

    
}
