package database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.sql.*;

//import org.postgresql.*;

public class JDBCConnection {
	
	private final String url = "jdbc:postgresql://faure.cs.colostate.edu:5432/coopergs/";
	private Connection conn;

	
	public JDBCConnection(String user, String pass){
		Properties props = new Properties();
		props.setProperty("user", user);
		props.setProperty("password", pass);
		try {
			conn = DriverManager.getConnection(url, props);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error connecting to database!");
			System.exit(1);
		}
	}
	
	public void addStudent(int id, String first, String last, String degree){
		try {
			Statement st = conn.createStatement();
			st.executeQuery("INSERT INTO students values(‘" + id + "’, ‘" + first + "’, ‘" + last + "’, ‘" + degree + "’);");
		} catch (SQLException e) {
			System.out.println("Error connecting to database!");
			System.exit(1);
		}
		
	}
	
	public void addBook(long isbn, String name, int year, int copies){
		try {
			Statement st = conn.createStatement();
			st.executeQuery("INSERT INTO books values(‘" + isbn + "’, ‘" + name + "’, ‘" + year + "’, ‘" + copies + "’);");
		} catch (SQLException e) {
			System.out.println("Error connecting to database!");
			System.exit(1);
		}
		
	}
	
	public void deleteStudent(int id){
		try {
			Statement st = conn.createStatement();
			st.executeQuery("DELETE FROM students WHERE id='" + id + "';");
		} catch (SQLException e) {
			System.out.println("Error connecting to database!");
			System.exit(1);
		}
		
	}
	
	public void deleteBook(int isbn){
		try {
			Statement st = conn.createStatement();
			st.executeQuery("DELETE FROM books WHERE isbn='" + isbn + "';");
		} catch (SQLException e) {
			System.out.println("Error connecting to database!");
			System.exit(1);
		}
		
	}
	
	public void issue(int id, int isbn){
		try {
			Statement st = conn.createStatement();
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(new Date());
			String date = dateFormat.format(c.getTime());
			c.add(Calendar.DATE, 30);
			String due = dateFormat.format(c.getTime());
			st.executeQuery("INSERT INTO books2students values(‘" + id + "’, ‘" + isbn + "’, ‘" + date + "’, ‘" + due + "’);");
		} catch (SQLException e) {
			System.out.println("Error connecting to database!");
			System.exit(1);
		}
	}
	
	public void returnBook(int id, int isbn){
		try {
			Statement st = conn.createStatement();
			st.executeQuery("DELETE FROM books2students WHERE id='" + id + "' AND isbn='" + isbn + "';");
		} catch (SQLException e) {
			System.out.println("Error connecting to database!");
			System.exit(1);
		}
	}
}
