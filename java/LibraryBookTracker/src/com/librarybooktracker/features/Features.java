package com.librarybooktracker.features;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.librarybooktracker.entities.Book;

public class Features {
	
	public static List<Book> books =new ArrayList<>();
	private static int bookIdCounter=1;
	public static void main(String[] args) {
		
	Scanner sc = new Scanner(System.in);
	while(true) {
	System.out.println("--- Library Menu ---");
	System.out.println("1.add books");
	System.out.println("2. View Books");
	System.out.println("3. Borrow Book");
	System.out.println("4. Return Book");
	System.out.println("5. Search Book");
	System.out.println("6. View Overdue Books");
	System.out.println("7. Exit");
	System.out.println("Enter choice:");
	
	int choice =sc.nextInt();
	sc.nextLine();
	
	switch (choice) {
	case 1: addBook(sc); break;
	case 2: viewBook(); break;
	case 3: borrowBook(sc); break;
	case 4: returnBook(sc); break;
	case 5: searchBook(sc); break;
	//case 6: viewOverdueBooks(); break;
	case 6: System.out.println("Exiting... Goodbye!"); System.exit(0);
	default: System.out.println("Invalid choice!");
	}
	
	
	}
	
	}
	private static void returnBook(Scanner sc) {
		System.out.println("enter book id");
		int id = sc.nextInt();
		sc.nextLine();
		for(Book b :books) {
			if(b.getId() == id) {
				if(!b.isAvaliable()) {
					b.returnBook();
				}else {
					System.out.println("This book was not borrowed.");
				}
				 return;
			}
			
		}
		System.out.println("Book not found!");
	}
	public static void  addBook( Scanner sc){
		System.out.println("enter title");
		String s1=sc.nextLine();
		System.out.println("enter author");
		String s2=sc.nextLine();
		
		books.add(new Book(bookIdCounter++, s1, s2));
		System.out.println("Book added successfully");
	
	}
	
	public static void viewBook() {
		if(books.isEmpty()) {
			System.out.println("No books in library.");
		}else {
			books.forEach(System.out::println);
		}
	}
	
	public static void borrowBook(Scanner sc) {
		System.out.println("enter book id");
		int id = sc.nextInt();
		for(Book b:books) {
			if(b.getId() == id) {
				b.borrowBook();
				System.out.println("Book borrowed successfully! Due date: " + b.getDueDate());
			}else {
				System.out.println("Book is already borrowed ");
			}
			return;
		}
		System.out.println("book notfound");
		
	}
	
	private static void searchBook(Scanner sc) {
		System.out.println("enter keyword (title/author)");
		String keyword =sc.nextLine().toLowerCase();
		boolean found =false;
		for(Book b : books) {
			if(b.getTitle().toLowerCase().contains(keyword) || b.getAuthor().toLowerCase().contains(keyword)) {
				System.out.println(b);
				found =true;
			}
		}
		
		if(!found) {
			System.out.println("no books found");
		}
	}
}
