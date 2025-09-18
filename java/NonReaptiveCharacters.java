package com.java;

public class NonReaptiveCharacters {

	public static void main(String[] args) {
		
		String s ="swiss";
		//System.out.println(nonReaptive(s));
		
		Character result = s.chars().mapToObj(c ->(char)c).filter(ch->s.indexOf(ch) == s.lastIndexOf(ch)).findFirst()
		.orElse(null);
		System.out.println(result);

	}
	
	/*public static char nonReaptive(String str) {
		for(int i=0;i<=str.length()-1;i++) {
			char ch = str.charAt(i);
			
			if(str.indexOf(ch)==str.lastIndexOf(ch)) {
				return ch;
			}
			
		}
		return 0;
	}*/

}
