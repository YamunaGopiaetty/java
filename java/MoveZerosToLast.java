package com.java;

import java.util.Arrays;
import java.util.List;

import java.util.stream.Collectors;

public class MoveZerosToLast {

	public static void main(String[] args) {
		
		List<Integer> li = Arrays.asList(1,0,2,0,3,0,4);
		List<Integer> nonZeroElements = li.stream().filter(i->i!=0).collect(Collectors.toList());
	
		long zeroElements = li.stream().filter(i->i==0).count();
		
		for(int i=0;i<=zeroElements;i++) {
			nonZeroElements.add(0);
		}
		System.out.println(nonZeroElements);

	}

}
