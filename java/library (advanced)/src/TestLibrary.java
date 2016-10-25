import java.util.*;

public class TestLibrary {

	public static void main(String[] args) {

		// Create Random authors
		Author ruth = new Author("Ruth");
		Author diane = new Author("Diane");
		Author jacqueline = new Author("Jacqueline");
		Author rachel = new Author("Rachel");
		Author joan = new Author("Joan");
		Author theresa = new Author("Theresa");
		Author angela = new Author("Angela");
		Author helen = new Author("Helen");
		Author lisa = new Author("Lisa");

		// Create Random books from the above authors
		Book book1 = new Book("Book1",ruth,"368777540-2",10,2,20);
		Book book2 = new Book("Book2",diane,"963099898-2",10,1,22);
		Book book3 = new Book("Book3",jacqueline,"005382097-2",10,0,23);
		Book book4 = new Book("Book4",rachel,"538310208-2",10,3,24);
		Book book5 = new Book("Book5",joan,"562448132-2",10,4,26);
		Book book6 = new Book("Book6",theresa,"670364563-2",10,2,21);
		Book book7 = new Book("Book7",angela,"466916869-2",10,5,17);
		Book book8 = new Book("Book8",helen,"764674973-2",10,0,15);
		Book book9 = new Book("Book9",lisa,"052469721-2",10,6,17);
		Book book10 = new Book("Book10",ruth,"609291817-2",10,3,13);
		Book book11 = new Book("Book11",diane,"451378028-2",10,8,12);
		Book book12 = new Book("Book12",jacqueline,"142352773-2",10,6,20);
		Book book13 = new Book("Book13",rachel,"115135166-2",10,0,20);
		Book book14 = new Book("Book14",joan,"631942468-2",10,3,20);
		Book book15 = new Book("Book15",theresa,"323662444-2",10,0,23);
		Book book16 = new Book("Book16",angela,"121360492-2",10,0,12);
		Book book17 = new Book("Book17",helen,"391199302-2",10,0,20);
		Book book18 = new Book("Book18",ruth,"549307784-2",10,1,20);
		Book book19 = new Book("Book19",ruth,"368777230-2",10,23,20);
		Book book20 = new Book("Book20",ruth,"793027213-2",10,0,20);
		
		// Add the books to a Book array
		Book[] books = {book1,book2,book3,book4,book5,book6,book7,
		book8,book9,book10,book11,book12,book13,book14,book15,
		book16,book17,book18,book19,book20};
		
		// Assign book collection to Booklist
		Booklist booklist = new Booklist(books);

		// Assign the book collection to the library
		Library library = new Library(books);

		
		// Create users
		User user1 = new User("babis", "sougias");
		User user2 = new User("john", "doe");
		User user3 = new User("michael", "jordan");
		User user4 = new User("eleni", "louka");

		// Add users to a User array
		User[] users = {user1, user2, user3};
		
		// Create UserList
		UserList userList = new UserList(users);
		
		// Create Transactions
		Transaction trans1 = new BookRental(book2, user2);
		Transaction trans2 = new BookRental(book19, user3);
		Transaction trans3 = new BookRental(book16, user1);
		Transaction trans4 = new BookRental(book12, user2);
		Transaction trans5 = new BookReturn(book12, user2);
		
		Transaction trans11 = new BookRental(book4, user1);
		Transaction trans12 = new BookRental(book6, user2);
		Transaction trans13 = new BookRental(book11, user4);
		Transaction trans14 = new BookReturn(book2, user2);
		Transaction trans15 = new BookReturn(book16, user1);
		
		// Add transactions to array
		ArrayList<Transaction> history = new ArrayList <> (Arrays.asList(trans1, trans2, trans3, trans4, trans5));
		ArrayList<Transaction> queue = new ArrayList <> (Arrays.asList(trans11, trans12, trans13, trans14, trans15));
		
		// Create TransactionQueue
		TransactionQueue transactionQueue = new TransactionQueue(queue);
		
		// Create TransactionHistory
		TransactionHistory transactionHistory = new TransactionHistory(history);
		
		// Create Librarian
		Librarian the_guy = new Librarian(booklist, transactionQueue, transactionHistory, userList);


		/*booklist.removeBook(book3);
		booklist.printBooklist();*/
		

		//cmd user interface
		Scanner scanner = new Scanner (System.in);
		System.out.println("*** Welcome to the BooKcamp! ***");
		System.out.println();
		User currentUser = null;
		String adminPassword = "admin";
		
		do {
			System.out.println("1. Show all available books");
			System.out.println("2. Search for a book (by book title)");
			System.out.println("3. Display books from a specific author");
			System.out.println("4. Rent book");
			System.out.println("5. Return book");
			System.out.println("6. Review your transactions");
			System.out.println("7. Register");
			System.out.println("8. Delete account");
			System.out.println("0. Quit\n");
			System.out.println("How do you wish to proceed?");
			
			String input = scanner.next();					

			if (input.equals("1"))
				the_guy.findMeAvailableBooks();
			else if (input.equals("2")) {
				System.out.print("\nEnter book title: ");
				String title = scanner.next();
				the_guy.findMeBook(title);
			}
			else if (input.equals("3")) {
				System.out.print("\nEnter author name: ");
				String author = scanner.next();
				the_guy.findMeBooksFromAuthor(author);
			}
			else if (input.equals("4")) {
				if (currentUser == null) {
					currentUser = the_guy.createAccount();
				}
				if (currentUser != null) {
					System.out.print("\nEnter book title: ");
					String title = scanner.next();
					if (the_guy.findBook(title) != null)
						if (the_guy.findBook(title).isAvailable()) {
							BookRental bookRental = new BookRental(the_guy.findBook(title), currentUser);
							the_guy.getTransactionQueue().addTransaction(bookRental);
							System.out.println("Rent request received. Thank you.\n");
						}
						else {
							System.out.println(title +" is anavailable.\n");
						}
					else {
						System.out.println(title +" is anavailable.\n");
					}
				}
				
			}
			else if (input.equals("5")) {
				if (currentUser == null) {
					currentUser = the_guy.createAccount();
				}
				if (currentUser != null) {
					System.out.print("\nEnter book title: ");
					String title = scanner.next();
					BookReturn bookReturn = new BookReturn(the_guy.findBook(title), currentUser);
					the_guy.getTransactionQueue().addTransaction(bookReturn);
					System.out.println("Return request received. Thank you.\n");
				}
			}
			else if (input.equals("6")) {
				if (currentUser == null) {
					currentUser = the_guy.createAccount();
				}
				if (currentUser != null) {
					the_guy.reviewUserTransactions(currentUser.getUser_id()); // counter equals last user's id
				}
			}
			else if (input.equals("7")) {
				currentUser = the_guy.createAccount(); //or sign in
			}
			else if (input.equals("8")) {
				if (currentUser == null) {
					currentUser = the_guy.createAccount();
				}
				if (currentUser != null) {
					the_guy.deleteLastAccount();
				}
			}
			
			// admin only hidden options
			else if (input.equals("9")) { // execute queued transactions
				System.out.print("\nEnter admin password: ");
				String pass = scanner.next();
				if (pass.equals(adminPassword)) {
					the_guy.executePendingTransactions();
				}
				else {
					System.out.println("You don't have execution privileges.\n");
				}
			}
			else if (input.equals("10")) { //see all transactions (history % queue)
				the_guy.printAllTransactions();
			}
			
			else if (input.equals("0")) {
				System.out.println("Thank you for browsing BooKcamp. Goodbye!\n");
				break;
			}
			else
				System.out.println("No such option. Try again.\n");
		} while (true);
	}
}