import java.util.*;

public class AuthorList {
	
	//fields
	private ArrayList<Author> authors; // initializes in constructor
	
	public ArrayList<Author> getAuthors() {return authors;}
	public void setAuthors(ArrayList<Author> authors) {this.authors = authors;}
	
	//constructors
	AuthorList() {
		this.authors = new ArrayList<>();
	}
	
	AuthorList(ArrayList<Author> authors) {
		this();
		for (Author author : authors)
			this.addAuthor(author);
	}
	
	//methods
	public void addAuthor(Author author) {
		this.authors.add(author);
	}
	
	public void removeAuthor(Author author) {
		this.authors.remove(author);
	}
	
	public Author findAuthor(String authorName) {
		for (Author author : this.authors){
			if (author.getName().toLowerCase().equals(authorName.toLowerCase()))
				return author;
		}
		System.out.println("Author " +authorName +" not found.");
		return null;
	}
	
	public int numberOfAuthors () {
		System.out.println(this.authors.size());
		return this.authors.size();
	}
	
	public boolean authorExists(String authorName) {
		for (Author author : this.authors){
			if (author.getName().toLowerCase().equals(authorName.toLowerCase())){
				System.out.println("Author exists.");
				return true;
			}
		}
		System.out.println("Author does not exist.");
		return false;
	}

}