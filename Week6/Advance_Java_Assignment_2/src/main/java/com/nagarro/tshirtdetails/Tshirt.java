package com.nagarro.tshirtdetails;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.nagarro.enums.*;

@Entity
@Table(name = "tshirt")
public class Tshirt {

	@Id
	private String id;

	private String name;

	@Enumerated(EnumType.STRING)
	private Color color;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Enumerated(EnumType.STRING)
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
	public int hashCode() {
		return Objects.hash(id, name, color, gender, size, avalibilty, price, rating);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Tshirt tshirt = (Tshirt) obj;
		return Objects.equals(id, tshirt.id) && Objects.equals(name, tshirt.name) && color == tshirt.color
				&& gender == tshirt.gender && size == tshirt.size && Objects.equals(avalibilty, tshirt.avalibilty)
				&& Double.compare(tshirt.price, price) == 0 && Double.compare(tshirt.rating, rating) == 0;
	}

	@Override
	public String toString() {
		String tshirtString = "Id:\t" + id + "\n" + "Name:\t" + name + "\n" + "Color:\t" + color.toString() + "\n"
				+ "Gender:\t" + gender.toString() + "\n" + "Size:\t" + size.toString() + "\n" + "Price\t" + price + "\n"
				+ "Rating:\t" + rating;

		return tshirtString;
	}

}
