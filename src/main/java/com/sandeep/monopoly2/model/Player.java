package com.sandeep.monopoly2.model;

import java.util.List;

public class Player {

	private String name;
	private int balance;
	private int position;
	private List<City> cityList;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public List<City> getCityList() {
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
	
	@Override
	public String toString() {
		return "Player [name=" + name + ", balance=" + balance + ", position=" + position + ", cityList=" + cityList
				+ "]";
	}
	
}
