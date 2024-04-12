package com.sandeep.monopoly2.model;

public class City {
	private String name;
	private int price;
	private int rent;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	
	@Override
	public String toString() {
		return "City [name=" + name + ", price=" + price + ", rent=" + rent + "]";
	}

}
