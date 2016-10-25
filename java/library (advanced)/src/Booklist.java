import java.util.*; 

public class Booklist {
	
	// fields
	private Book first_element;
	
	// getters & setters
	public Book getFirst_element() {return first_element;}
	public void setFirst_element(Book first_element) {this.first_element = first_element;}
	
	// constructors
	Booklist() {}
	
	Booklist(Book[] bookarray) {
		for (Book book : bookarray)
			this.addBook(book);
	}
	
	// methods
	public void addBook(Book book) {
		if (this.first_element == null) {
			this.first_element = book;
		}
		else {
			Book current_book = this.first_element;
			while (current_book.getNext() != null) {
				current_book = current_book.getNext();
			}
			current_book.setNext(book);
		}
	}
	
	public void removeBook(Book book) {
		Book temp = null;
		Book current_book = this.first_element;
		if (this.first_element == null)
			System.out.println("There is no book titled " +book.getTitle() +" in this booklist.");
		/*else if (current_book.getNext() == null){
			this.first_element = null;
			System.out.println (book +" deleted. Bookklist is now empty.");
		}*/
		else {
			while (current_book != book) {
				temp = current_book;
				current_book = current_book.getNext();
			}
			if (this.first_element == current_book){
				this.first_element = current_book.getNext();
			}
			else {
				temp.setNext(current_book.getNext());
				System.out.println (book.getTitle() +" deleted.");
			}
		}
	}
	
	public void printBooklist() {
		if (this.first_element == null)
			System.out.println("No books to show, booklist is empty.");
		else {
			System.out.println(this.first_element.toString());
			Book current_book = this.first_element;
			while (current_book.getNext() != null) {
				current_book = current_book.getNext();
				System.out.println(current_book.toString());
			}
		}
	}
	
	// Methods delegated from Library
	public void printAvailableBooks () {
		if (this.first_element == null)
			System.out.println("No books to show, booklist is empty.");
		else {
			Book current_book = this.first_element;
			do {
				if (current_book.isAvailable()){
					System.out.println(current_book.toString());
				}
				current_book = current_book.getNext();
			} while (current_book.getNext() != null);
		}
	}
	
	public Book returnBook(String title) {
		Book current_book = this.first_element;
		do {
			if (current_book.getTitle().equalsIgnoreCase(title)){
				return current_book;
			}
			current_book = current_book.getNext();
		} while (current_book != null);
		return null;
	}
	
	public void printBookDetails (String title) {
		boolean found = false;
		Book current_book = this.first_element;
		do {
			if (current_book.getTitle().equalsIgnoreCase(title)){
				System.out.println(current_book.toString());
				found = true;
			}
			current_book = current_book.getNext();
		} while (current_book.getNext() != null);
		if (!found) {
			System.out.println("There is no book titled <" +title +"> in our list.\n");
		}
	}
	
	public void printBookFromAuthor (String authorName){
		boolean found = false;
		Book current_book = this.first_element;
		do {
			if (current_book.getAuthor().getName().equalsIgnoreCase(authorName)){
				System.out.println(current_book.toString());
				found = true;
			}
			current_book = current_book.getNext();
		} while (current_book.getNext() != null);
		if (!found) {
			System.out.println("There is no book written by <" +authorName +"> in our list.\n");
		}
	}
}