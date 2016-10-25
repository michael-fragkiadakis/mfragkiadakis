import java.util.*;

public class TransactionHistory {

	// fields
	private ArrayList<Transaction> history;
	
	// constructors
	TransactionHistory() {
		this.history = new ArrayList<>();
	}

	TransactionHistory(ArrayList<Transaction> history) {
		this();
		for (Transaction transaction : history)
			this.history.add(transaction);
	}

	// getters & setters
	public ArrayList<Transaction> getHistory() {
		return history;
	}

	public void setHistory(ArrayList<Transaction> history) {
		this.history = history;
	}
	
	// methods
	public void findUserTransactions(int user_id) {
		System.out.println();
		System.out.println("Executed transactions: ");
		for (Transaction transaction : this.history){
			if (transaction.getUser().getUser_id() == user_id)
				System.out.println(transaction.toString());
		}
		System.out.println();
	}

	public void printHistory () {
		System.out.println("*** Transaction History ***");
		for (Transaction transaction : this.history){
			System.out.println(transaction.toString());
		}
	}
	
}
