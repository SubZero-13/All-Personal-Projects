package com.nagarro.Mini_Assignment_2.dtos;

import lombok.Data;

import java.util.List;

@Data
public class Results {
	private List<UserInfo> results;
	private Info info;

	public List<UserInfo> getResults() {
		return results;
	}

	public void setResults(List<UserInfo> results) {
		this.results = results;
	}

	public Info getInfo() {
		return info;
	}

	public void setInfo(Info info) {
		this.info = info;
	}

	// Getters and setters...
}
