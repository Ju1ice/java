package main;

import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		new Configuration().configure().buildSessionFactory();
	}
	
}
