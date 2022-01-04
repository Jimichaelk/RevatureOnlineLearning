package com.revature.CoreJavaAssignment;

public class Q2FibSeq {
	public void fibSeq(int n) {
		int odd = 0, even = 1;
		
		for(int i = 0; i < n; i++) {
			System.out.printf("%d, ", odd);
			i++;
			if(i < n)
				System.out.printf("%d, ", even);
			odd = odd+even;
			even = odd+even;
		}
	}
}
