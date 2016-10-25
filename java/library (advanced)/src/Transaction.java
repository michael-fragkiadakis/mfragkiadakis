import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public abstract class Transaction {
	
	// fields
	private Book book;
	private Date requestDate;
	private Date serverDate;
	private User user;
	private static int counter = 0;
	private final int id;
	
	//getters & setters
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public Date getServerDate() {
		return serverDate;
	}
	public void setServerDate(Date servingDate) {
		this.serverDate = servingDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Transaction.counter = counter;
	}
	public int getId() {
		return id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	//constructors
	Transaction() {
		counter ++;
		this.id = counter;
		this.requestDate = new Date();
	}
	
	Transaction(Book book, User user) {
		this();
		this.book = book;
		this.user = user;
	}
	
	//methods
	@Override
	public String toString() {
		return "Transaction [book=" + book.getIsbn() + ", requestDate=" + requestDate + ", serverDate=" + serverDate
				+ ", user_id=" + user.getUser_id() + ", id=" + id + "]";
	}	
	
	public abstract void modifyBookCounters (); // used in transaqtionQueue's addTransaction method
	
}
