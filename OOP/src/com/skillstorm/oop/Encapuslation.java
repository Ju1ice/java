package com.skillstorm.oop;

public class Encapuslation {

	public static void main(String[] args) {
		Animal a = new Animal();
		// do not directly access a property
		// a.age = -1;
		a.setAge(34);
		a.setAge(-1);
		System.out.println(a.getAge());
		
		a.eat("");
		a.go();
	}
	
}
