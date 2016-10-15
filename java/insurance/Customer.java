import java.util.*;

public class Customer {

	private static int counter = 0;
	private static ArrayList<Customer> customers = new ArrayList<Customer>();

	private int id;
	private String name;
	private int yob;
	private String sex;

	public static int getCounter() {return counter;}
	public void setId (int id){this.id = id;}
	public int getId(){return this.id;}
	public void setName (String name){this.name = name;}
	public String getName(){return this.name;}
	public void setYob(int yob){this.yob = yob;}
	public int getYob(){return this.yob;}
	public void setSex (String sex){this.sex = sex;}
	public String getSex(){return this.sex;}

	Customer (String name, int yob, String sex) {
		this.name = name;
		this.yob = yob;
		this.sex = sex;
		counter ++;
		id = counter;
		customers.add(this);
	}

	public String toString(){
			String customer_details = "\nId: " +this.id +"\nName: " +this.name
			+"\nYear of Birth: " + this.yob +"\nSex: " +this.sex;
			return customer_details;
	}

	public int getAge() {
		return (2016 - this.yob);
	}

	public static Customer getCustomer (int id) {
		for (Customer customer : customers) {
			if (customer.getId() == id)
				return customer;
		}
		return null;
	}

}