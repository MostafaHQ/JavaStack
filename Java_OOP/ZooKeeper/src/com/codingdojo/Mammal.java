package com.codingdojo;

public class Mammal {
	private double energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	//Getter & Setter
	
	public double getEnergyLevel() {
		return this.energyLevel;
	}

	public void setEnergyLevel(double energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public void displayEnergy() {
		System.out.println(energyLevel);
	}
}

