package com.codingdojo;

public class Bat extends Mammal {
	
	public Bat() {
		this.setEnergyLevel(300);
	}
	
	public void fly() {
		super.setEnergyLevel(this.getEnergyLevel()-50);
	}
	
	public void eatHumans() {
		super.setEnergyLevel(this.getEnergyLevel()+25);
	}
	
	public void attackTown() {
		super.setEnergyLevel(this.getEnergyLevel()-100);
	}
}
