import java.util.*;

public class Library {

	private Book[] books = new Book[20];
	// private ArrayList<Author> authors = new ArrayList<Author>();

	public Book[] getBook(){return this.books;}
	public void setBooks (Book[] books){this.books = books;}
	
	public Library(Book[] books) {
		this.books = books;
	}
	
	/* Methods delegated to Booklist

	public void printAvailableBooks () {
			for (Book book : books){
				if (book.isAvailable())
					System.out.println(book.toString());
			}
	}

	public void printBookDetails (String title) {
		for (Book book : books){
			if (book.getTitle().equals(title))
				System.out.println(book.toString());
		}
		System.out.println(title +" does not exist.");
	}

	public void printBookFromAuthor (String name){
		for (Book book : books){
			if (book.getAuthor().equals(name))
				System.out.println(book.toString());
		}
	}
	*/
}