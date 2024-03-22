package com.nagarro.Mini_Assignment_2.dtos;

import lombok.Data;
@Data
public class Coordinates {
    private String latitude;
    private String longitude;

    public String getLatitude() {
    	return this.latitude;
    }

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
    
}
