package it.polito.tdp.food.model;

import java.util.Objects;

public class Coppia {

	private Food f1;
	private Food f2;
	private double n;
	
	public Coppia(Food f1, Food f2, double n) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		this.n = n;
	}

	public Food getF1() {
		return f1;
	}

	public Food getF2() {
		return f2;
	}

	public double getN() {
		return n;
	}

	@Override
	public int hashCode() {
		return Objects.hash(f1, f2, n);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coppia other = (Coppia) obj;
		return Objects.equals(f1, other.f1) && Objects.equals(f2, other.f2) && n == other.n;
	}

	@Override
	public String toString() {
		return "Coppia [f1=" + f1 + ", f2=" + f2 + ", n=" + n + "]";
	}
	
	
}
