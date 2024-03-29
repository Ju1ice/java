package com.skillstorm.review;

/**
 * Reusing state and behavior in subclasses
 * 
 * DRY : Do not repeat yourself
 * WET : Write everything twice
 * 
 * YAGNI: you ain't gonna need it
 * MVP: minimum viable product
 * 
 * @author PWalsh
 *
 */
public class Inheritance {

}

class Person {
	int energy = 100;
	public void nap() {
		System.out.println("ZzzZz");
	}
}

class Programmer extends Person {
	public void code() {
		// code
		energy--;
		nap();
	}
}




