package com.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s ="swiss";
		List<Integer> li= Arrays.asList(1,0,2,0,3,0);
		List<Integer> nonZeroElements = li.stream().filter(c->c!=0).collect(Collectors.toList());
		long ZeroElements = li.stream().filter(c->c==0).count();
		
		for(int i=1;i<=ZeroElements;i++) {
			nonZeroElements.add(0);
		}
		System.out.println(nonZeroElements);
		
	
		
		System.out.println(firstNonRepeative(s));
		
		Character st = s.chars().mapToObj(c->(char)c).filter(ch->s.indexOf(ch) == s.lastIndexOf(ch)).findFirst().orElse(null);
		System.out.println("using java8 " +st);
		findDuplicates(s);
		
		 Set<Character> st1 = s.chars().mapToObj(c->(char)c).filter(ch->s.indexOf(ch) != s.lastIndexOf(ch)).collect(Collectors.toSet());
		 
		
		System.out.println("duplicates elements using java 8  :"+st1);
		
		Map<Character, Long> st2 = s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println("Count Occurence of each char"+st2);
		
		
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
		StringBuilder sb= new StringBuilder("yamuna");
		System.out.println(sb.reverse());
		

	}
	
	public static char firstNonRepeative(String str) {
		for(int i=0;i<=str.length()-1;i++) {
			char ch = str.charAt(i);
			
			if(str.indexOf(ch) == str.lastIndexOf(ch)) {
				return ch;
			}
		}
		return 0;
	}
	
	public static Character findDuplicates(String s) {
		Set<Character> seen = new HashSet<>();
		Set<Character> duplicates = new HashSet<>();
		
		for(char ch:s.toCharArray()) {
			if(!seen.add(ch)) {
				duplicates.add(ch);
			}
		}
		System.out.println("Duplicate elements :" +duplicates);
		return 0;
		}
	

}
