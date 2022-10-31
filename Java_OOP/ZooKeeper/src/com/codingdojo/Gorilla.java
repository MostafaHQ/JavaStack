package com.codingdojo;
public class Gorilla extends Mammal {
	
	
	public void throwSomething() {
		System.out.println("Gorilla has thrown smothing, and its energy level deacres by 5 ");
		super.setEnergyLevel(-5);

	}
	
	public void eatBananas() {
		System.out.println("Gorilla eats banana, and increases energy level by 10");
		super.setEnergyLevel(10);
	}
	
	public void climb() {
		System.out.println("Gorilla has climbed a tree, and decreases the energy level by 10");
		super.setEnergyLevel(-10);
	}
}
