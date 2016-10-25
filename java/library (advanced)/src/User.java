import java.util.*;

public class User {

	//fields
	private String name;
	private String surname;
	private final int user_id;
	private static int counter = 0;
	
	//getters & setters	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getSurname() {return surname;}
	public void setSurname(String surname) {this.surname = surname;}
	public static int getCounter() {return counter;}
	public static void setCounter(int counter) {User.counter = counter;}
	public int getUser_id() {return user_id;}

	//constructors
	public User() {
		counter++;
		user_id = counter;
	}
	public User(String name, String surname) {
		this();
		this.name = name;
		this.surname = surname;
	}
	
	//methods
	@Override
	public String toString() {
		return "User [name=" + name + ", surname=" + surname + ", user_id=" + user_id + "]";
	}
	
}
