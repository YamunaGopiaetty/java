package com.librarybooktracker.entities;

import java.time.LocalDate;


public class Book {
	
	public int id;
	public String title;
	public String author;
	public boolean avaliable;
	public LocalDate dueDate;
	public Book(int id, String title, String author) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.avaliable = true;
		this.dueDate = null;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public boolean isAvaliable() {
		return avaliable;
	}
	public void setAvaliable(boolean avaliable) {
		this.avaliable = avaliable;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", avaliable=" + avaliable + ", dueDate="
				+ dueDate + "]";
	}

	public void borrowBook() {
		// TODO Auto-generated method stub
		this.avaliable = false;
		this.dueDate=LocalDate.now().plusDays(7);
	}

	public void returnBook() {
		// TODO Auto-generated method stub
		this.avaliable = true;
		this.dueDate = null;
		
	}
	
	

}
