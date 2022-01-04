package com.revature.datatypes;

public class FlowControl {
	
	public void flowControl() {
		boolean myBoolean = true;
		int i = 5;
		
		if(myBoolean) {
			//This code runs if myBoolean is true.
		} else if (i>5) {
			//This code runs if the previous block did not, ie myBoolean is false.
		} else {
			//This code runs
		}
		
		while(myBoolean) {
			//This code will run indefinitely, since myBoolean is true.
			//Unless...
			myBoolean = !myBoolean;
			//or
			break;
		}
		
		do {
			myBoolean = false;
		}while(myBoolean);
		
		String[] names = { "Jacob", "Daniel", "Allison"};
		String[] otherNames = new String[10];
		
		for(int iteration = 0; iteration < names.length; iteration++) {
			System.out.println(names[iteration]);
		}
		
		//Enhanced for loop, runs for each element in the array, collection, etc
		for(String s : names) {
			System.out.println(s);
		}
		
		
	}
}
