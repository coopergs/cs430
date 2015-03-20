package database;

/**
 * @author Cooper Scott
 * CS430 - Homework Assignment 2
 * database.Manager.java
 */

import java.util.Scanner;

public class Manager {
	
	private Scanner kb;
	private JDBCConnection connection;
	
	private void addStudent(){
		System.out.print("	Enter student id: ");
		int id = 0;
		String idString = "";
		boolean bad = true;
		while(bad){
			try{
				idString = kb.nextLine();
				if(idString.equalsIgnoreCase("exit")){
					System.out.println("	Returning to main menu.");
					return;
				}
				id = Integer.parseInt(idString);
				bad = false;
			}catch(Exception e){
				System.out.printf("	Input \"%s\" is not a number. \n", idString);
				System.out.print("	Enter student id or \"exit\" to return to main menu: ");
			}
		}
		System.out.print("	Enter student first name: ");
		String first = kb.nextLine();
		System.out.print("	Enter student last name: ");
		String last = kb.nextLine();
		System.out.print("	Enter student degree: ");
		String degree = kb.nextLine();
		connection.addStudent(id, first, last, degree);
		System.out.printf("Adding %s %s to database.\n", first, last);
	}
	
	private void addBook(){
		System.out.print("	Enter book ISBN: ");
		long isbn = 0;
		String isbnString = "";
		boolean bad = true;
		while(bad){
			try{
				isbnString = kb.nextLine();
				if(isbnString.equalsIgnoreCase("exit")){
					System.out.println("	Returning to main menu.");
					return;
				}
				isbn = Long.parseLong(isbnString);
				bad = false;
			}catch(Exception e){
				System.out.printf("	Input \"%s\" is not a number. \n", isbnString);
				System.out.print("	Enter book ISBN or \"exit\" to return to main menu: ");
			}
		}
		System.out.print("	Enter title of book: ");
		String title = kb.nextLine();
		System.out.print("	Enter book publication year: ");
		int year = 0;
		String yearString = "";
		bad = true;
		while(bad){
			try{
				yearString = kb.nextLine();
				if(yearString.equalsIgnoreCase("exit")){
					System.out.println("	Returning to main menu.");
					return;
				}
				year = Integer.parseInt(yearString);
				bad = false;
			}catch(Exception e){
				System.out.printf("	Input \"%s\" is not a number. \n", yearString);
				System.out.print("	Enter book publication year or \"exit\" to return to main menu: ");
			}
		}
		System.out.print("	Enter number of copies: ");
		int copies = 0;
		String copiesString = "";
		bad = true;
		while(bad){
			try{
				copiesString = kb.nextLine();
				if(copiesString.equalsIgnoreCase("exit")){
					System.out.println("	Returning to main menu.");
					return;
				}
				copies = Integer.parseInt(copiesString);
				bad = false;
			}catch(Exception e){
				System.out.printf("	Input \"%s\" is not a number. \n", copiesString);
				System.out.print("	Enter number of copies or \"exit\" to return to main menu: ");
			}
		}
		connection.addBook(isbn, title, year, copies);
		System.out.printf("Adding %s to the database.\n", title);
	} 
	
	private void deleteStudent(){
		System.out.print("	Enter id of student to delete: ");
		int id = 0;
		String idString = "";
		boolean bad = true;
		while(bad){
			try{
				idString = kb.nextLine();
				if(idString.equalsIgnoreCase("exit")){
					System.out.println("	Returning to main menu.");
					return;
				}
				id = Integer.parseInt(idString);
				bad = false;
			}catch(Exception e){
				System.out.printf("	Input \"%s\" is not a number. \n", idString);
				System.out.print("	Enter student id or \"exit\" to return to main menu: ");
			}
		}
		connection.deleteStudent(id);
		System.out.printf("	Removing %d from database and returning all books.\n", id);
	}
	
	private void deleteBook(){
		System.out.print("	Enter ISBN of book to delete: ");
		int isbn = 0;
		String isbnString = "";
		boolean bad = true;
		while(bad){
			try{
				isbnString = kb.nextLine();
				if(isbnString.equalsIgnoreCase("exit")){
					System.out.println("	Returning to main menu.");
					return;
				}
				isbn = Integer.parseInt(isbnString);
				bad = false;
			}catch(Exception e){
				System.out.printf("	Input \"%s\" is not a number. \n", isbnString);
				System.out.print("	Enter book ISBN or \"exit\" to return to main menu: ");
			}
		}
		connection.deleteBook(isbn);
		System.out.printf("	Removing %d from database.\n", isbn);
	}
	
	private void issue(){
		System.out.print("	Enter id of student to issue to: ");
		int id = 0;
		String idString = "";
		boolean bad = true;
		while(bad){
			try{
				idString = kb.nextLine();
				if(idString.equalsIgnoreCase("exit")){
					System.out.println("	Returning to main menu.");
					return;
				}
				id = Integer.parseInt(idString);
				bad = false;
			}catch(Exception e){
				System.out.printf("	Input \"%s\" is not a number. \n", idString);
				System.out.print("	Enter student id or \"exit\" to return to main menu: ");
			}
		}
		System.out.print("	Enter ISBN of book to issue: ");
		int isbn = 0;
		String isbnString = "";
		bad = true;
		while(bad){
			try{
				isbnString = kb.nextLine();
				if(isbnString.equalsIgnoreCase("exit")){
					System.out.println("	Returning to main menu.");
					return;
				}
				isbn = Integer.parseInt(isbnString);
				bad = false;
			}catch(Exception e){
				System.out.printf("	Input \"%s\" is not a number. \n", isbnString);
				System.out.print("	Enter book ISBN or \"exit\" to return to main menu: ");
			}
		}
		connection.issue(id, isbn);
		System.out.printf("	Issuing %d to %d.\n", isbn, id);	
	}
	
	private void returnBook(){
		System.out.print("	Enter id of student who is returning: ");
		int id = 0;
		String idString = "";
		boolean bad = true;
		while(bad){
			try{
				idString = kb.nextLine();
				if(idString.equalsIgnoreCase("exit")){
					System.out.println("	Returning to main menu.");
					return;
				}
				id = Integer.parseInt(idString);
				bad = false;
			}catch(Exception e){
				System.out.printf("	Input \"%s\" is not a number. \n", idString);
				System.out.print("	Enter student id or \"exit\" to return to main menu: ");
			}
		}
		System.out.print("	Enter ISBN of book being returned: ");
		int isbn = 0;
		String isbnString = "";
		bad = true;
		while(bad){
			try{
				isbnString = kb.nextLine();
				if(isbnString.equalsIgnoreCase("exit")){
					System.out.println("	Returning to main menu.");
					return;
				}
				isbn = Integer.parseInt(isbnString);
				bad = false;
			}catch(Exception e){
				System.out.printf("	Input \"%s\" is not a number. \n", isbnString);
				System.out.print("	Enter book ISBN or \"exit\" to return to main menu: ");
			}
		}
		connection.returnBook(id, isbn);
		System.out.printf("	Returning %d from %d.\n", isbn, id);
	}

	public static void main(String[] args) {
		
		Manager m = new Manager();
		m.kb = new Scanner(System.in);
		m.connection = new JDBCConnection("coopergs", "829763292");
		System.out.println("Welcome to the library database manager.");
		
		
		//command loop
		String input = "";
		while(true){
			System.out.print(">");
			input = m.kb.nextLine();
			if(input.equalsIgnoreCase("add student")){
				m.addStudent();
			}else if(input.equalsIgnoreCase("add book")){
				m.addBook();
			}else if(input.equalsIgnoreCase("delete student")){
				m.deleteStudent();
			}else if(input.equalsIgnoreCase("delete book")){
				m.deleteBook();
			}else if(input.equalsIgnoreCase("issue")){
				m.issue();
			}else if(input.equalsIgnoreCase("return")){
				m.returnBook();
			}else if(input.equalsIgnoreCase("exit")){
				break;
			}else{
				System.out.printf("Command \"%s\" not recognized.\n", input);
			}
		}
		System.out.println("Thank you for using the library database manager.");
		
	}

}
