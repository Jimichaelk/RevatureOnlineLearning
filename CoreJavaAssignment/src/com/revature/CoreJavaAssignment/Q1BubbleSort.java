package com.revature.CoreJavaAssignment;

public class Q1BubbleSort {
	public int[] bubbleSort(int[] sorted) {
		int errors, temp;
		do {
			errors = 0;
			for (int i = 0; i < sorted.length-1; i++) {
				if(sorted[i] > sorted[i+1]) {
					temp = sorted[i+1];
					sorted[i+1] = sorted[i];
					sorted[i] = temp;
					errors++;
				}
			}
		
		} while(errors != 0);
		return sorted;
	}
}
