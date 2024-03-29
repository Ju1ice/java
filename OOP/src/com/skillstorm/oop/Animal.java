package com.skillstorm.oop;

/**
 * Encapsulation: wrapping related state/behavior into a class
 * 
 * Protect those variables/methods from undesirable access
 * 
 * 
 * @author PWalsh
 *
 */
public abstract class Animal extends java.lang.Object {
	public static int count = 0;
	
	public Animal() {
		count++;
	}
	
	public static void talk() {
		System.out.println("TALK");
	}
	
	// access modifier: private- only in 
	// the same class
	private int age;
	protected int legs;

	// forces subclass to implement
	public void speak() {
		System.out.println("Yo");
	}
	
	// anywhere within the application
	public void eat(String food) {
		this.digest(food);
	}
	
	// default (anywhere within the SAME package)
	void go() {}
	
	// within the same package AND any subclasses
	protected void fetch() {}
	
	private void digest(String food) {}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age < 0) return;
		this.age = age;
	}
	
	
	
}
