package com.booklibrary.bookConsole;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.booklibrary.DAL.*;
import com.booklibrary.models.*;

public class BookMain {
	public static void addBooks() {
		BookMethods bm=new BookMethods();
		List<Book> listOfBooks=new ArrayList<>();
		listOfBooks.add(new Book("Harry Potter","JK Rowling"));
		listOfBooks.add(new Book("Game of Thrones","George RR Martin"));
		listOfBooks.add(new Book("Gone Girl","Gillian Flynn"));
		listOfBooks.add(new Book("Carrie","Stephen King"));
		listOfBooks.add(new Book("An Amber in the Ashes","Sabaa Tahir"));
		listOfBooks.add(new Book("Harry Potter","Unknown"));
		for(Book b:listOfBooks) {
			bm.addBook(b);
		}
	}
	
	public static void main(String[] args) {
		int operation=0;
		Scanner scanner=new Scanner(System.in);
		while(operation!=5) {
			System.out.println("Choose operation : 1 - add, 2 -edit, 3-remove,4-get all books, 5-quit");
			String input=scanner.nextLine();
			while(!OperationInterface.tryParseInt(input)){
				System.out.println("Enter a valid number");
				input=scanner.nextLine();
			}
			operation=Integer.parseInt(input);
			switch(operation){
				case 1:OperationInterface.operationAdd();
					   break;
				case 2:OperationInterface.operationEdit();break;
				case 3:OperationInterface.operationRemove();
				       break;
				case 4:OperationInterface.operationGetAll();
					   break;
				case 5:System.exit(0);break;
				default:System.out.println("Please, enter valid operation");
			}
		}
	}

}
