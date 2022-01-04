package com.revature.datatypes;

public class Driver {
	
	public static void main(String[] args) {
		
		//Here I am instantiating a new DataTypes object. (instantiate = to make an instance of)
		DataTypes dt = new DataTypes();
		
		System.out.println(dt.add(1, 2));
		
		int answer = dt.add(3, 4);
		System.out.println(answer);
		
		Dog felix = new Dog(), henry = new Dog(), patty = new Dog();
		
		felix.name = "Felix";
		felix.age = 2;
		felix.weight = 106.5;
		felix.breed = "German Shepard";
		
		dt.printDogName(felix);
	}
}
