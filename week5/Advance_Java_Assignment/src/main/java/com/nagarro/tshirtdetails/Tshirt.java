package com.nagarro.tshirtdetails;

import java.util.Objects;

import com.nagarro.enums.*;

public class Tshirt {

	private String id;
	private String name;
	private Color color;
	private Gender gender;
	private Size size;
	private String avalibilty;

	private double price;
	private double rating;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public String getAvalibilty() {
		return avalibilty;
	}

	public void setAvalibilty(String avalibilty) {
		this.avalibilty = avalibilty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Tshirt))
			return false;
		Tshirt other = (Tshirt) obj;
		return this.id.equalsIgnoreCase(other.id) && this.name.equalsIgnoreCase(other.name)
				&& this.color.toString().equalsIgnoreCase(other.color.toString())
				&& this.gender.toString().equalsIgnoreCase(other.gender.toString())
				&& this.size.toString().equalsIgnoreCase(other.size.toString())
				&& this.avalibilty.equalsIgnoreCase(other.avalibilty) && this.price == other.price
				&& this.rating == other.rating;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, color, gender, size, avalibilty, price, rating);
	}

	@Override
	public String toString() {
		String tshirtString = "Id:\t" + id + "\n" + "Name:\t" + name + "\n" + "Color:\t" + color.toString() + "\n"
				+ "Gender:\t" + gender.toString() + "\n" + "Size:\t" + size.toString() + "\n" + "Price\t" + price + "\n"
				+ "Rating:\t" + rating;

		return tshirtString;
	}

}
