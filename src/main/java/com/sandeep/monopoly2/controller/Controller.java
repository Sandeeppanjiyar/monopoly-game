package com.sandeep.monopoly2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sandeep.monopoly2.model.City;
import com.sandeep.monopoly2.model.Player;

@RestController
public class Controller {

	Player a = null;
	Player b = null;

	@PostMapping("/create-game")
	public String createGame() {
		a = new Player();
		a.setName("A");
		a.setBalance(1000);
		a.setPosition(0);
		a.setCityList(new ArrayList<City>());

		b = new Player();
		b.setName("B");
		b.setBalance(1000);
		b.setPosition(0);
		b.setCityList(new ArrayList<City>());

		return "Game Created: " 
				+ "[ Player A: " + a.toString() + "]" 
				+ "  <<>>  " 
				+ "[ Player B: " + b.toString() + "]";
	}

	@PostMapping("/roll-die/p1")
	private String rollDiceA() {
		int rollDice = (int) (2 + (Math.random() * 11));
		City c = getCityBasedOnDiceRoll(rollDice);
		Player a = this.a;
		Player b = this.b;
		List<City> existingCityListForA = a.getCityList();
		List<City> existingCityListForB = b.getCityList();
		
		ListIterator<City> itrOFACityList = existingCityListForA.listIterator();
		ListIterator<City> itrOFBCityList = existingCityListForB.listIterator();
		
		if (existingCityListForA.size() > 0) {
			while (itrOFACityList.hasNext()) {
				if (!c.getName().equals(itrOFACityList.next().getName())) {
					while (itrOFBCityList.hasNext()) {
						if (!c.getName().equals(itrOFBCityList.next().getName())) {
							a.setBalance(a.getBalance() - c.getPrice());
							a.getCityList().add(c);
							a.setPosition(a.getPosition() + rollDice);
							if(a.getPosition() > 10) {
								a.setBalance(a.getBalance() + 200);
							}
							return a.toString() 
									+ "  <<>>  " 
									+ b.toString() 
									+ "  <<>>  "
									+ "City: " + c
									+ "  <<>>  "
									+"Dice-Roll: " + rollDice;
						} else {
							a.setBalance(a.getBalance() - c.getRent());
							a.setPosition(a.getPosition() + rollDice);
							if(a.getPosition() > 10) {
								a.setBalance(a.getBalance() + 200);
							}
							return a.toString() 
									+ "  <<>>  " 
									+ b.toString() 
									+ "  <<>>  "
									+ "City: " + c
									+ "  <<>>  "
									+"Dice-Roll: " + rollDice;
						}
					}
				} 
			}

		} else {
			a.setBalance(a.getBalance() - c.getPrice());
			a.getCityList().add(c);
			a.setPosition(a.getPosition() + rollDice);
		}
		
		return a.toString() 
				+ "  <<>>  " 
				+ b.toString() 
				+ "  <<>>  "
				+ "City: " + c
				+ "  <<>>  "
				+"Dice-Roll: " + rollDice;
	}

	@PostMapping("/roll-die/p2")
	private String rollDiceB() {

		int rollDice = (int) (2 + (Math.random() * 11));

		City c = getCityBasedOnDiceRoll(rollDice);
		Player a = this.a;
		Player b = this.b;
		List<City> existingCityListForA = a.getCityList();
		List<City> existingCityListForB = b.getCityList();

		ListIterator<City> itrOFACityList = existingCityListForA.listIterator();
		ListIterator<City> itrOFBCityList = existingCityListForB.listIterator();
		
		if (existingCityListForB.size() > 0) {
			while (itrOFBCityList.hasNext()) {
				if (!c.getName().equals(itrOFBCityList.next().getName())) {
					while (itrOFACityList.hasNext()) {
						if (!c.getName().equals(itrOFACityList.next().getName())) {
							b.setBalance(b.getBalance() - c.getPrice());
							b.getCityList().add(c);
							b.setPosition(b.getPosition() + rollDice);
							if(b.getPosition() > 10) {
								b.setBalance(b.getBalance() + 200);
							}
							return a.toString() 
									+ "  <<>>  " 
									+ b.toString() 
									+ "  <<>>  "
									+ "City: " + c
									+ "  <<>>  "
									+"Dice-Roll: " + rollDice;
						} else {
							b.setBalance(b.getBalance() - c.getRent());
							b.setPosition(b.getPosition() + rollDice);
							if(b.getPosition() > 10) {
								b.setBalance(a.getBalance() + 200);
							}
							return a.toString() 
									+ "  <<>>  " 
									+ b.toString() 
									+ "  <<>>  "
									+ "City: " + c
									+ "  <<>>  "
									+"Dice-Roll: " + rollDice;
						}
					}
				} 
			}

		} else {
			b.setBalance(a.getBalance() - c.getPrice());
			b.getCityList().add(c);
			b.setPosition(b.getPosition() + rollDice);
		}
		
		return a.toString() 
				+ "  <<>>  " 
				+ b.toString() 
				+ "  <<>>  "
				+ "City: " + c
				+ "  <<>>  "
				+"Dice-Roll: " + rollDice;
	}

	private City getCityBasedOnDiceRoll(int x) {
		City city = null;
		switch (x) {
		case 2:
			City oldKentRoad = new City();
			oldKentRoad.setName("Old Kent Road");
			oldKentRoad.setPrice(60);
			oldKentRoad.setRent(30);
			city = oldKentRoad;
			break;
		case 3:
			City eustonRoad = new City();
			eustonRoad.setName("Euston Road");
			eustonRoad.setPrice(100);
			eustonRoad.setRent(20);
			city = eustonRoad;
			break;
		case 4:
			City kingsCrossstation = new City();
			kingsCrossstation.setName("King's Cross station");
			kingsCrossstation.setPrice(200);
			kingsCrossstation.setRent(100);
			city = kingsCrossstation;
			break;
		case 5:
			City pallMall = new City();
			pallMall.setName("Pall Mall");
			pallMall.setPrice(140);
			pallMall.setRent(70);
			city = pallMall;
			break;
		case 7:
			City pentonvilleRoad = new City();
			pentonvilleRoad.setName("Pentonville Road");
			pentonvilleRoad.setPrice(150);
			pentonvilleRoad.setRent(40);
			city = pentonvilleRoad;
			break;
		default:
			City theAngelIslington = new City();
			theAngelIslington.setName("The AngelIs Lington");
			theAngelIslington.setPrice(120);
			theAngelIslington.setRent(50);
			city = theAngelIslington;
		}
		return city;
	}

}
