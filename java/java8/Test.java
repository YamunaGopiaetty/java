package com.demo.java8;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) {
		
		String s="yamuna";
		String s1="silent";
		String s2="listen";
		System.out.println("-----------count occurane of each charcters----------");
		Map<Object, Long> st = s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
		System.out.println(st);
		System.out.println("---------reverse string-------");
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
		
		
		System.out.println("--------------the strings are anangram------------");
		char[] st9 = s1.toCharArray();
		char[] st8 = s2.toCharArray();
		
	   Arrays.sort(st9);
		Arrays.sort(st8);
		
		if(Arrays.equals(st9, st8)) {
			System.out.println("the strings are anangram");
		}else{
			System.out.println("the strings are not anangram");
		}
		
		System.out.println("-----------move zeros in last ----------");
		List<Integer> a= Arrays.asList(1,0,2,0,3,0);
		
		List<Integer> nonzero = a.stream().filter(n->n!=0).collect(Collectors.toList());
		long zeroElements = a.stream().filter(n->n==0).count();
		
		for(int i=1;i<=zeroElements;i++) {
			nonzero.add(0);
		}
		System.out.println(nonzero);
		System.out.println("-----------first non repeative char ---");
		char st1 = nonRepeat(s);
		System.out.println(st1);
		System.out.println("-----------duplicateCh-----------");
		char st2 = duplicateCh(s);
		System.out.println(st2);
		
	}
	
	public static char nonRepeat(String str) {
		
		for(int i=0;i<=str.length()-1;i++) {
			char ch=str.charAt(i);
			
			if(str.indexOf(ch) ==str.lastIndexOf(ch)) {
				return ch;
			}
			
		}
		return 0;
		
	}
	
	public static boolean isPrime(int num) {
		if(num <=1) {
			return false;
		}
		for(int i=2;i<=num;i++) {
			if(num%i==0) {
				return false;
			}
			
		}
		return true;
	}
	public static char duplicateCh(String str2) {
		Set<Character> seen = new HashSet<Character>();
		Set<Character> duplicates = new HashSet<Character>();
		
		for(char ch :str2.toCharArray()) {
			if(!seen.add(ch)) {
				duplicates.add(ch);
			}
			
		}
		System.out.println(duplicates);
		return 0;
		
	}

}
