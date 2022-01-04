package com.revature.CoreJavaAssignment;

public class Q5SubString {
	public String subString(String str, int idx) {
		if(str.length() < idx)
			return str;
		
		String substring = "";
		
		//This is how to look at the specific characters of a string.
		char[] charStr = str.toCharArray();
		
		for(int i = 0; i < idx; i++)
			substring = substring + charStr[i];
			
		return substring;
	}
}
