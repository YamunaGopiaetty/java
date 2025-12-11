package com.demo.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {
	
	public int id;
	public String name;
	public String dep;
	public double salary;
	public Employee(int id, String name, String dep, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.dep = dep;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dep=" + dep + ", salary=" + salary + "]";
	}
		 

}

class demo{
	public static void main(String[] args) {
		List<Employee> em =new ArrayList<>();
		em.add(new Employee(1, "yamuna", "it", 50000));
		em.add(new Employee(1, "sai", "admin", 60000));
		em.add(new Employee(1, "teja", "sales", 40000));
		em.add(new Employee(1, "divya", "it", 90000));
		
		
		System.out.println("-------sort List<Employee> by salary---------");
		List<Employee> em1 = em.stream().sorted(Comparator.comparing(Employee :: getSalary)).toList();
		System.out.println(em1);
		
		System.out.println("----------Second height salary---------");
		Employee em2 = em.stream().sorted(Comparator.comparing(Employee :: getSalary).reversed()).skip(1).findFirst().get();
		System.out.println(em2);
		System.out.println("-----------mapping the names--------");
	List<String> em3 = em.stream().map(Employee::getName).toList();
		System.out.println(em3);
		
		System.out.println("-----------------group employees by department--------");
		Map<String, List<Employee>> em4 = em.stream().collect(Collectors.groupingBy(Employee::getDep));
		System.out.println(em4);
		
		System.out.println("-----------------based on salary get employees names--------");
		List<String> name = em.stream().filter(e->e.getSalary()>50000).map(Employee::getName).collect(Collectors.toList());
		System.out.println(name);
		
		Map<String,List<Employee>> em8=em.stream().filter((e->e.getSalary() > 50000).collect(Collectors.groupingBy(Employee::getDep));
		
		System.out.println("-----------------based on salary get employees names--------");
		List<String> em0 = em.stream().filter(e->e.getDep().equalsIgnoreCase("it") && e.getSalary() >= 50000).map(Employee::getName).toList();
		System.out.println(em0);
		
		System.out.println("--------------heighest salary---------");
		Employee em5 = em.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println(em5);
		
		System.out.println("-------top3 salary per dep----------");
	   em7= em.stream().collect(Collectors.grouping(Employee::getDep,sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).collect(Collectors.toList());
		//System.out.println(em7);
	}
}
