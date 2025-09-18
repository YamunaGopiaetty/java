package com.java;

import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 String input = "programming";

	        Character duplicates = input.chars()
	                .mapToObj(c -> (char) c)
	                .filter(ch -> input.indexOf(ch) != input.lastIndexOf(ch)).findFirst().get(); // occurs more than once
	               // .collect(Collectors.toSet());

	        System.out.println("Duplicate characters: " + duplicates);

	}

}
