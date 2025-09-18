package com.java;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FindAllDuplicateCharInGivenString {

	public static void main(String[] args) {
		String s="yamunaymu";
		FindAllDuplicates(s);
		
      Set<Character> u = s.chars().mapToObj(c->(char)c).filter(n->s.indexOf(n) != s.lastIndexOf(n)).collect(Collectors.toSet());
      System.out.println(u);
		
	}
	
	public static Character FindAllDuplicates(String str) {
		
		Set<Character> seen = new HashSet<>();

		Set<Character> duplicates = new HashSet<>();
		
		for(char st:str.toCharArray()) {
			if(!seen.add(st)) {
				duplicates.add(st);
			}
			
		}
		System.out.println("duplicate char"+duplicates);
		System.out.println("without duplicate char"+seen);
		
		
		
		for(char st:str.toCharArray()) {
			  if(!duplicates.contains(st)) {
				  System.out.println("unique char"+st);
			  }
		  }
		
	return 0;
	
	  

		
	}
	
	

}
