package it.polito.tdp.food.model;

public class FoodCalories {

	private Food f;
	private int n;
	
	public FoodCalories(Food f, int n) {
		super();
		this.f = f;
		this.n = n;
	}

	public Food getF() {
		return f;
	}

	public int getN() {
		return n;
	}
}
