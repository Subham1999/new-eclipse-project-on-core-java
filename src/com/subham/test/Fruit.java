package com.subham.test;

@SuppressWarnings("preview")
public sealed abstract class Fruit permits Mango {
	public String getTaste() {
		return "wow";
	}
}