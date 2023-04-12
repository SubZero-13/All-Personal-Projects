package com.nagarro.tshirtdetails;

import com.nagarro.enums.*;

public class TshirtInput {
	private Color color;
	private Size size;
	private Gender gender;
	private OutputPreference outputPreference;

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public OutputPreference getOutputPreference() {
		return outputPreference;
	}

	public void setOutputPreference(OutputPreference outputPreference) {
		this.outputPreference = outputPreference;
	}

}
