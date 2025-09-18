package com.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeesBySalaryDescendinOrder {
	public static void main(String[] args) {
		
	
	List<Employee> emp = new ArrayList<>();
	emp.add(new Employee(1, "yamuna", 52471, "bangalore", "it"));
	emp.add(new Employee(2, "=sai", 7894, "hyderbad", "admin"));
	emp.add(new Employee(3, "teja", 5241, "bangalore", "non-it"));
	emp.add(new Employee(4, "divya", 3254, "chennai", "software"));
	
	System.out.println("=================Max&Min Salary =========================");
	
	Employee maxsal = emp.stream().max(Comparator.comparing(Employee::getSalary)).orElse(null);
	Employee minSal = emp.stream().min(Comparator.comparing(Employee::getSalary)).orElse(null);
	System.out.println("maxsalary : "+maxsal);
	System.out.println("minsalary :"+minSal);
	
	
	System.out.println("==============Group employees by department===========");
	Map<String, List<Employee>> empdep = emp.stream().collect(Collectors.groupingBy(Employee ::getDep));
	System.out.println(empdep);
	
	System.out.println("===============highest salary==========");
	Employee highestSal = emp.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
	System.out.println(highestSal);
	System.out.println("===============SecondHighestSalary==========");
	Employee secondhighest = emp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).skip(1).findFirst().orElse(null);
	System.out.println(secondhighest);
	System.out.println("=================salary&dep========");
	List<Employee> sal = emp.stream().filter(n->n.getSalary()>=5000 && n.getDep().equalsIgnoreCase("it")).collect(Collectors.toList());
	System.out.println(sal);
	System.out.println("=================flatMap============");
	List<Integer> a1= Arrays.asList(1,2,3,4);
	List<Integer> a2= Arrays.asList(5,6,7,8);
	List<Integer> h = Stream.of(a1,a2).flatMap(List::stream).collect(Collectors.toList());
	System.out.println(h);
	List<Integer> h1 = Stream.of(a1,a2).flatMap(n->n.stream()).collect(Collectors.toList());
	System.out.println(h1);
	
	List<List<String>> skills = Arrays.asList(
			Arrays.asList("java","python","c"),
			Arrays.asList("c++","javascript","sql"));
	List<String> f1 = skills.stream().flatMap(n->n.stream()).collect(Collectors.toList());
	System.out.println(f1);
	
	
	
	
	
	
	
	
	/*List<Employee> e = emp.stream().filter(n->n.getDep().equalsIgnoreCase("it") && n.getSalary() >= 3000).collect(Collectors.toList());
	System.out.println(e);
	
	Object sd = emp.stream().sorted(Comparator.comparingDouble(Employee::getSalary)).toList();
	System.out.println(sd);
	
	 Object sd1 = emp.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
	 
	System.out.println("max salary"+sd1);
	Object emp1 =emp.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed().thenComparing(Employee::getName)).toList();
	System.out.println("descending order salary"+emp1);
	
	Object emp2 = emp.stream().filter(b->b.getSalary()>50000).filter(v->v.getDep().equalsIgnoreCase("it")).toList();
	System.out.println("salarygreater than 50000 and withdep"+emp2);
	
	List<Integer> a1= Arrays.asList(1,2,3,4);
	List<Integer> a2= Arrays.asList(5,6,7,8);
    Stream.of(a1,a2).flatMap(List::stream).forEach(System.out::print);*/
	
	
	
	}
}
