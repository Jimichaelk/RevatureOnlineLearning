package com.revature.datatypes;

public class DataTypes {
	
	public void dataTypes() {
		
		//Representing whole numbers
		int i = 0; //variable initialization: variables name and type are established, and it has an explicit value. 32 bits
		short s; //Short is 16 bits. This is called a variable declaration: name and type are established but no value is assigned.
		long l; //Long is 64 bits.
		
		//Representing (approximating) fractions or real numbers
		float f = 3.9f; //32 bits. f is required, all decimals are assumed to be doubles.
		double d = 3.9; //64 bits.
		
		//Representing letters
		char c = 'c'; //Single quotes. 16 bits.
		
		//Representing True and False
		boolean b = true; //True or false, 1 bit* (more likely to be a byte in java).
		
		//Representing the basic unit
		byte bt; //8 bits. Can specify bits in a bit string
	}
	
	public int add(int a, int b) {
		return a + b;
	}
	
	public void printDogName(Dog d) {
		System.out.println("Your dog's name is " + d.name); //Strings can be combined with +.
	}
}
