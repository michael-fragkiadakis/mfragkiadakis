import java.util.*;

public class Librarian {

	private Booklist booklist;
	private TransactionQueue transactionQueue;
	private TransactionHistory transactionHistory;
	private UserList userList;

	public Booklist getBooklist() {
		return booklist;
	}
	public void setBooklist(Booklist booklist) {
		this.booklist = booklist;
	}
	public TransactionQueue getTransactionQueue() {
		return transactionQueue;
	}
	public void setTransactionQueue(TransactionQueue transactionQueue) {
		this.transactionQueue = transactionQueue;
	}
	public TransactionHistory getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(TransactionHistory transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	public UserList getUserList() {
		return userList;
	}
	public void setUserList(UserList userList) {
		this.userList = userList;
	}
	
	// constructors
	Librarian(Booklist booklist, TransactionQueue transactionQueue, TransactionHistory transactionHistory, UserList userList) {
		this.booklist = booklist;
		this.transactionQueue = transactionQueue;
		this.transactionHistory = transactionHistory;
		this.userList = userList;
	}
	
	//booklist methods
	public void findMeBooksFromAuthor(String auhtorName) {
		this.booklist.printBookFromAuthor(auhtorName);
	}

	public void findMeAvailableBooks () {
		this.booklist.printAvailableBooks ();
	}

	public void findMeBook (String title) {
		this.booklist.printBookDetails (title);
	}
	
	public Book findBook (String title) {
		Book book = this.booklist.returnBook(title);
		if (book != null) {
			return book;
		}
		return null;
	}
	
	// userlist methods
	public User createAccount() { // for user use
		Scanner scanner = new Scanner (System.in);
		System.out.print("Do you have an account here? (Y or N) ");
		String registered = scanner.next().toLowerCase();
		if (registered.equals("y")) {
			System.out.print("Enter your user ID: ");
			int user_id = scanner.nextInt();
			if (user_id > 0 && user_id <= User.getCounter()) {
				return this.userList.returnUser(user_id);
			}
		}
		else if (registered.equals("n")) {
			System.out.print("Would you like to create one? (Y or N) ");
			String register = scanner.next().toLowerCase();
			if (register.equals("y")) {
				System.out.print("Enter name: ");
				String name = scanner.next().toLowerCase();
				System.out.print("Enter surname: ");
				String surname = scanner.next().toLowerCase();
				this.userList.addUser(new User(name, surname));
				System.out.println("New " +this.userList.getUserList().getLast() +". Thank you for registering!\n");
				return this.userList.getUserList().getLast();
			}
			System.out.println("Service anavailable. Try again.\n");
		}
		return null;
	}
	
	public void createAccount(User user) {
		this.userList.addUser(user);
	}
	
	public void deleteAccount(User user) {
		this.userList.removeUser(user);
	}
	
	public void deleteLastAccount() { //for user use
		this.userList.getUserList().removeLast();
		System.out.println("Your account has been closed.");
	}
	
	public User findUser(int user_id) {
		User user = userList.returnUser(user_id);
		return user;
	}
	
	//transactionQueue methods rent,return,review
	public void rentBook(BookRental bookRental){
		this.transactionQueue.addTransaction(bookRental);
	}
	
	public void returnBook(BookReturn bookReturn){
		this.transactionQueue.addTransaction(bookReturn);
	}
	
	public void reviewUserTransactions(int user_id) {
		System.out.println("*** Your transaction history ***");
		this.transactionQueue.findUserTransactions(user_id);
		this.transactionHistory.findUserTransactions(user_id);
	}
	
	// librarian methods
	public void executePendingTransactions() {
		System.out.println("*** Executing pending transactions ***\n");
		// execute
		while (!this.transactionQueue.getQueue().isEmpty()) {
			this.transactionQueue.removeTransaction();
			this.transactionHistory.getHistory().add(TransactionQueue.getTemp());
			// this.transactionQueue.removeTransaction(); or this with queue length in for instead of same list
		}
	}
	
	public void printAllTransactions() {
		this.transactionHistory.printHistory();
		this.transactionQueue.printQueue();
		System.out.println();
	}
	
}