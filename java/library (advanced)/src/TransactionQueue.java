import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TransactionQueue {

	//fields
	private ArrayList<Transaction> queue; // ONLY QUEUE METHODS!
	private static Transaction temp;

	//getters & setters
	public ArrayList<Transaction> getQueue() {return queue;}
	public void setQueue(ArrayList<Transaction> queue) {this.queue = queue;}
	
	public static Transaction getTemp() {return temp;}
	public static void setTemp(Transaction temp) {TransactionQueue.temp = temp;}
	
	//constructors
	public TransactionQueue() {
		this.queue = new ArrayList<>();
	}
	public TransactionQueue(ArrayList<Transaction> queue) {
		this();
		for (Transaction transaction : queue) {
			this.queue.add(transaction);
		}
	}
	
	//methods
	@Override
	public String toString() {
		return "TransactionQueue [queue=" + queue + "]";
	}
	
	public void addTransaction(Transaction transaction) {
		transaction.modifyBookCounters();;
		this.queue.add(transaction);
	}
	
	public void removeTransaction() { // fifo
		this.queue.get(0).setServerDate(new Date());
		temp = this.queue.get(0);
		this.queue.remove(0);
	}
	
	public int numberOfTransactions () {
		System.out.println(this.queue.size());
		return this.queue.size();
	}
	
	public void findUserTransactions(int user_id) {
		System.out.println();
		System.out.println("Pending transactions: ");
		for (Transaction transaction : this.queue){
			if (transaction.getUser().getUser_id() == user_id)
				System.out.println(transaction.toString());
		}
		System.out.println();
	}
	
	public void findBookTransactions(String isbn) {
		for (Transaction transaction : this.queue){
			if (transaction.getBook().getIsbn().equals(isbn))
				System.out.println(transaction.toString());
		}
	}
	
	public void printQueue () {
		System.out.println("*** Pending transactions ***");
		for (Transaction transaction : this.queue){
			System.out.println(transaction.toString());
		}
	}
	
}
