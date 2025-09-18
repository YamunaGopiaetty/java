package com.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;


public class PrintSumOfPositiveNumbersAndSumOfNegetiveNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("========================FirstNonRepeativeCharacters==========================");
		 String s="swiss";
		 String y="wisss";
		 
		 System.out.println(firstNonRepeativeCharacter(s));
		
		Character fi = s.chars().mapToObj(c->(char)c).filter(ch->s.indexOf(ch) == s.lastIndexOf(ch)).findFirst().orElse(null);
		System.out.println("using java8 stream :   "+fi);
		
		System.out.println("===============Reverse String ===========");
		
		
		
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
		
		StringBuilder sb =new StringBuilder("sai");
		System.out.print(sb.reverse());
		System.out.println("======================DuplicatesElements=======================");
		
		printDuplicateElements(s);
		 Set<Character> st = s.chars().mapToObj(c->(char)c).filter(ch->s.indexOf(ch) != s.lastIndexOf(ch)).collect(Collectors.toSet());
		System.out.println("using java8 stream : "+st);
		
		System.out.println("================Count OccurenceOfEachCharacters============");
		Map<Character, Long> st3 = s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(st3);
		
		System.out.println("======================Anangram============");
		
		Map<Character, Long> st4 = s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		Map<Character, Long> st5 = y.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		boolean anangram = st4.equals(st5);
		if(anangram) {
			System.out.println("Strings are anangram using java8");
		}else {
			System.out.println("Strings are  not anangram using java8");
		}
		
		char[] ch = s.toCharArray();
		char[] ch1 = y.toCharArray();
		
		
		Arrays.sort(ch);
		Arrays.sort(ch1);
		
		boolean an = Arrays.equals(ch, ch1);
		
		if(an) {
			System.out.println("Strings are anangram");
		}else {
			System.out.println("Strings are  not anangram");
		}
		
		System.out.println("=========================PrintSumOfPositiveNumbersAndSumOfNegetiveNumbers=======================");
		List<Integer> li = Arrays.asList(1,2,3,0,0,0,4,5,6);
		Integer l1 = li.stream().filter(n->n%2==0).reduce(Integer :: sum).get();
		System.out.println("sum of positiive numbers"+l1);
		Integer l2 = li.stream().filter(n->n%2!=0).reduce(Integer :: sum).get();
		System.out.println("sum of negative numbers:"+l2);
		
		Integer l3 = li.stream().reduce(Integer :: sum).get();
		System.out.println("sum of  numbers:"+l3);
		
		
		System.out.println("=========================ZerosShiftedToRightSide=======================");
	List<Integer> nonZeroElements = li.stream().filter(n->n!=0).collect(Collectors.toList());
	 long ZeroElements = li.stream().filter(n->n==0).count();
	 
	 for(int i=1;i<=ZeroElements;i++) {
		 nonZeroElements.add(0);
	 }
	 System.out.println(nonZeroElements);

	
	System.out.println("=========================primeNumber=======================");
	int num =28;
	Boolean isPrime =true;
    
	if(num<=1) {
		isPrime= false;
	}else {
		//for(int i=2;i<num;i++) {
			if(num%2==0) {
				isPrime=false;
			}
		//}
		
		if(isPrime) {
			System.out.println("num is prime number");
		}else {
			System.out.println("num is not a prime number");
		}
	}
}
	
	public static Character firstNonRepeativeCharacter(String str) {
		for(int i=0;i<str.length()-1;i++) {
			char ch = str.charAt(i);
			if(str.indexOf(ch) == str.lastIndexOf(ch)) {
				return ch;
			}
		}
		return 0;
	}
	
	public static Character printDuplicateElements(String str) {
		Set<Character> seen = new HashSet<>();
		Set<Character> duplicates = new HashSet<>();
		
		for(char c:str.toCharArray()) {
			if(!seen.add(c)) {
				duplicates.add(c);
			}
			
		}
		System.out.println(duplicates);
		return null;
	}

}
