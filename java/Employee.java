package com.java;

public class Employee {
      private int id;
      private String name;
      private double salary;
      private String city;
      private String dep;
	  public Employee(int id, String name, double salary, String city, String dep) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.city = city;
		this.dep = dep;
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
	  public double getSalary() {
		  return salary;
	  }
	  public void setSalary(double salary) {
		  this.salary = salary;
	  }
	  public String getCity() {
		  return city;
	  }
	  public void setCity(String city) {
		  this.city = city;
	  }
	  public String getDep() {
		  return dep;
	  }
	  public void setDep(String dep) {
		  this.dep = dep;
	  }
	  @Override
	  public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", city=" + city + ", dep=" + dep + "]";
	  }
      
      
}
