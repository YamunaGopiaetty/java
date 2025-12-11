package com.librarybooktracker.entities;

import java.util.List;

public class User {
	
	public int id;
	public String name;
	public List<Book> borrowedBooks;
	public User(int id, String name, List<Book> borrowedBooks) {
		super();
		this.id = id;
		this.name = name;
		this.borrowedBooks = borrowedBooks;
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
	public List<Book> getBorrowedBooks() {
		return borrowedBooks;
	}
	public void setBorrowedBooks(List<Book> borrowedBooks) {
		this.borrowedBooks = borrowedBooks;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", borrowedBooks=" + borrowedBooks + "]";
	}
	
	

}
