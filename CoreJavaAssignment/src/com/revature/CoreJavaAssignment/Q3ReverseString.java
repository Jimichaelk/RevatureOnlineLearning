package com.revature.CoreJavaAssignment;

public class Q3ReverseString {
	public String ReverseString(String str) {
		for(int i = str.length()-1; i >= 0; i--) {
			str = str + str.toCharArray()[i];
		}
		
		str = str.substring(str.length()/2, str.length());
		return str;
	}
}
