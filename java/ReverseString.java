package com.java;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="yamuna";
		
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
		
		StringBuilder sb = new StringBuilder("sai");
		System.out.println(sb.reverse());

	}

}
