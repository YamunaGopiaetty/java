package com.java;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Anangram {

	public static void main(String[] args) {
		// TODO A"uto-generated method stub
		String s="silent";
		String s2="listen";
		
		Map<Character, Long> d1 = s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		Map<Character, Long> d2 = s2.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		System.out.println(d2);
		boolean d3 = d1.equals(d2);
		
		if(d3) {
			System.out.println("Strings are anangram");
		}else {
			System.out.println("Strings are not  anangram");
		}
			
		}
		/*char[] ch1 = s.toCharArray();
		char[] ch2=s2.toCharArray();
		
		Arrays.sort(ch1);
		Arrays.sort(ch2);
		
		if(Arrays.equals(ch1, ch2)) {
			System.out.println("Strings are anangram");
		}else {
			System.out.println("Strings are not  anangram");
		}
	}*/

}
