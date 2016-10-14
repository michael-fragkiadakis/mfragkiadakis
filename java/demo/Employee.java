import java.util.*;

public class Employee {

	private String name;
	private String surname;
	private int year;

	public void setName (String name){this.name = name;}
	public String getName(){return this.name;}
	public void setSurname (String surname){this.surname = surname;}
	public String getSurname(){return this.surname;}
	public void setYear (int year){this.year = year;}
	public int getYear(){return this.year;}

	public int getAge() {
		return (2016 - this.year);
	}

	public String toString(){
		String details = "Name: " +this.name +"\nSurname: " +this.surname +"\nAge: " + this.getAge();
			return details;
	}

}