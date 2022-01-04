package com.revature.CoreJavaAssignment;

public class Q4NFact {
	public int nFactorial(int n) {
		if(n < 0) {
			System.out.println("Factorial number was negative");
			return 0;
		}
		
		int factorial = 1;
		for(; n > 0; n--) {
			factorial = factorial * n;
		}
		return factorial;
	}
}
