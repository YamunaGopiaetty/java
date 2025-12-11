package com.librarybooktracker.entities;

import java.util.List;

public class Library {
	
	public List<Book> books;
	public List<User> users;
	public Library(List<Book> books, List<User> users) {
		super();
		this.books = books;
		this.users = users;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@Override
	public String toString() {
		return "Library [books=" + books + ", users=" + users + "]";
	}
	
	

}
