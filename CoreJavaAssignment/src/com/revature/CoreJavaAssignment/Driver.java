package com.revature.CoreJavaAssignment;

public class Driver {

	public static void main(String[] args) {
		
		//Testing Q1
		Q1BubbleSort Q1 = new Q1BubbleSort();
		
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		array = Q1.bubbleSort(array);
		
		for(int i: array) {
			System.out.printf("%d, ", i);
		}
		System.out.printf("%n");
		
		//Testing Q2
		Q2FibSeq Q2 = new Q2FibSeq();
		
		Q2.fibSeq(25);
		System.out.printf("%n");
		
		//Testing Q3
		Q3ReverseString Q3 = new Q3ReverseString();
		String q3TestString = "Hello World!";
		
		System.out.println(Q3.ReverseString(q3TestString));
		
		//Testing Q4
		Q4NFact Q4 = new Q4NFact();
		
		int factTarget = 10;
		int factorial = Q4.nFactorial(factTarget);
		
		System.out.println(factorial);
		
		//Testing Q5
		Q5SubString Q5 = new Q5SubString();
		String q5TestString = "Hello World!";
		int q5Index = 5;
		
		String q5Result = Q5.subString(q5TestString, q5Index);
		
		System.out.println(q5Result);
		
		
	}
}
