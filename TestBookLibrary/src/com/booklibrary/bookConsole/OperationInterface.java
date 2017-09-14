package com.booklibrary.bookConsole;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.booklibrary.DAL.BookMethods;
import com.booklibrary.models.Book;

public class OperationInterface {
	static private Scanner scanner=new Scanner(System.in);
	static private BookMethods bm=new BookMethods();
	
	public static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	
	public static void operationAdd() {
		System.out.println("Please enter name of the new book");
		String name=scanner.nextLine();
		System.out.println("Please enter author of the new book");
		String author=scanner.nextLine();
		bm.addBook(new Book(name,author));
		System.out.println("Book was added successfully");
	}
	
	public static void operationEdit() {
		System.out.println("Enter name of the book to edit");
		String name=scanner.nextLine();
		List<Book> lb=bm.getBooksByName(name);
		if(lb.size()==0) {
			System.out.println("Book not found");
		}
		else if(lb.size()==1) {
			System.out.println("Enter new name of the book");
			String nameEditedBook=scanner.nextLine();
			Book book=lb.get(0);
			book.setName(nameEditedBook);
			bm.updateBook(book);
			System.out.println("Book was successfully edited");
		}
		else {
			List<Integer> listOfIds=printList(lb);
			System.out.println("Choose number of book to edit");
			int number=getCorrectNumber(listOfIds);
			Book b=bm.getBookById(number);
			System.out.println("Enter new name of the book");
			String nameEditedBook=scanner.nextLine();
			b.setName(nameEditedBook);
			bm.updateBook(b);
			System.out.println("Book was successfully edited");
		}
	}
	
	public static void operationRemove() {
		System.out.println("Enter name of the book");
		String name=scanner.nextLine();
		List<Book> lb=bm.getBooksByName(name);
		if(lb.size()==0) {
			System.out.println("Book not found");
		}
		else if(lb.size()==1) {
			bm.deleteBook(lb.get(0).getBookId());
			System.out.println("Book was removed successfully");
		}
		else {
			List<Integer> listOfIds=new ArrayList<>();
			listOfIds=printList(lb);
			System.out.println("Choose number of book to delete");
			int number=getCorrectNumber(listOfIds);
			bm.deleteBook(number);
			System.out.println("Book was removed successfully");
		}
	}
	
	public static  void operationGetAll() {
		List<Book> l=bm.getAllBooks();
		for(Book b:l) {
		   System.out.println(b);
		}
	}
	private static List<Integer> printList(List<Book> lb) {
		List<Integer> listOfIds=new ArrayList<>();
		for(Book b:lb) {
			System.out.println(b.getBookId()+" - " +b.toString());
			listOfIds.add(b.getBookId());
		}
		return listOfIds;
	}
	private static int getCorrectNumber(List<Integer> listOfIds) {
		String input=scanner.nextLine();
		while(!OperationInterface.tryParseInt(input)||!listOfIds.contains(Integer.parseInt(input))){
			System.out.println("Enter number in the list of books");
			input=scanner.nextLine();
		}
		int number=Integer.parseInt(input);
		return number;		
	}
}
