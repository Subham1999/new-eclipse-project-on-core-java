package com.subham.test;

@SuppressWarnings("preview")
public non-sealed class Mango extends Fruit {
	private String name = "Mango";

	@Override
	public String getTaste() {
		return "sweet";
	}

	@Override
	public String toString() {
		return "Mango [name=" + name + ", getTaste()=" + getTaste() + "]";
	}

}
