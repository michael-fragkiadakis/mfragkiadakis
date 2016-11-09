package Bookcamp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	public BookDAO() {
		// TODO Auto-generated constructor stub
	}

	private Connection con = null;

	
	
	public void open() throws SQLException {
		try {
			// dynamically load the driver's class file into memory
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {

			throw new SQLException("MySQL Driver error: " + e.getMessage());
		}

		try {
			// establish a connection with the database and creates a Connection
			// object (con)
			con = DriverManager.getConnection("jdbc:mysql://localhost/bookcamp", "root", "admin");
		} catch (Exception e) {
			con = null;
			// throw SQLException if a database access error occurs
			throw new SQLException("Could not establish connection with the Database Server: " + e.getMessage());
		}

	} // End of open
	
	
	public void close() throws SQLException {
		try {
			// if connection is open
			if (con != null)
				con.close(); // close the connection to the database to end database session			

		} catch (Exception e3) {
			
			throw new SQLException("Could not close connection with the Database Server: " + e3.getMessage());
		}

	}// end of close
	
	
	public List<Book> getAllBooks() throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "SELECT * FROM book;";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			ResultSet rs = stmt1.executeQuery();

			List<Book> booklist = new ArrayList<>();
						
			while(rs.next()) {
				
				// Retrieve by column name
				int bookId = rs.getInt("book_id");
				String isbn = rs.getString("isbn");
				String imagePath = rs.getString("image");
				String title = rs.getString("title");
				int authorId = rs.getInt("author_id");
				Author author = this.getAuthor(authorId);
				String category = rs.getString("category");
				String publisher = rs.getString("publisher");
				int publicationYear = rs.getInt("publication_year");
				String description = rs.getString("description");

				// Fill booklist with all books in our database
				booklist.add(new Book(bookId, isbn, imagePath, title, author, category, publisher, publicationYear,
						description));
				
			}

			rs.close();
			stmt1.close();
			
			return booklist;

		} catch (Exception e) {
			
			throw new Exception("An error occured while getting books from database: " + e.getMessage());
		}
		
	}//End of getAllBooks
	
	public Book getBookById(int bookId) throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "SELECT * FROM book where book_id = " +bookId +";";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			ResultSet rs = stmt1.executeQuery();
			Book book = new Book();
			
			// Retrieve by column name
			rs.next();
			String isbn = rs.getString("isbn");
			String imagePath = rs.getString("image");
			String title = rs.getString("title");
			int authorId = rs.getInt("author_id");
			Author author = this.getAuthor(authorId);
			String category = rs.getString("category");
			String publisher = rs.getString("publisher");
			int publicationYear = rs.getInt("publication_year");
			String description = rs.getString("description");

			book = new Book(bookId, isbn, imagePath, title, author, category, publisher, publicationYear, description);

			rs.close();
			stmt1.close();
			
			return book;

		} catch (Exception e) {
			
			throw new Exception("An error occured while getting book from database: " + e.getMessage());
		}
		
	}
	
	public List<Book> getAuthorsBooks(int author_Id) throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "SELECT * FROM book where author_id = " +author_Id +";";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			ResultSet rs = stmt1.executeQuery();

			List<Book> authorBooklist = new ArrayList<>();
						
			while(rs.next()) {
				
				// Retrieve by column name
				int bookId = rs.getInt("book_id");
				String isbn = rs.getString("isbn");
				String imagePath = rs.getString("image");
				String title = rs.getString("title");
				int authorId = rs.getInt("author_id");
				Author author = this.getAuthor(authorId);
				String category = rs.getString("category");
				String publisher = rs.getString("publisher");
				int publicationYear = rs.getInt("publication_year");
				String description = rs.getString("description");

				// Fill authorBooklist with books of this author
				authorBooklist.add(new Book(bookId, isbn, imagePath, title, author, category, publisher, publicationYear,
						description));
				
			}

			rs.close();
			stmt1.close();
			
			return authorBooklist;

		} catch (Exception e) {
			
			throw new Exception("An error occured while getting author's books from database: " + e.getMessage());
		}
		
	}
	
	public List<Book> getAuthorsOtherBooks (Book book) {
		List<Book> otherBooks;
		try {
			otherBooks = this.getAuthorsBooks(book.getAuthor().getAuthorId());
		} catch (Exception e) {
			otherBooks = new ArrayList<>();
			e.printStackTrace();
		}
		// Remove current book from list of author's books
		otherBooks.remove(book);
		return otherBooks;
	}
	
	public List<String> getAllCategories() throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "SELECT distinct categories FROM bookcamp.book;";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			ResultSet rs = stmt1.executeQuery();

			List<String> categorylist = new ArrayList<>();
						
			while (rs.next()) {
				// Retrieve by column name
				String category = rs.getString("category");

				// Fill categorylist
				categorylist.add(category);
			}

			rs.close();
			stmt1.close();
			
			return categorylist;

		} catch (Exception e) {
			
			throw new Exception("An error occured while getting categories from database: " + e.getMessage());
		}
		
	}//End of getAllCategories
	
	
	public List<Author> getAllAuthors() throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "SELECT * FROM author;";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			ResultSet rs = stmt1.executeQuery();

			List<Author> authorlist = new ArrayList<>();
						
			while(rs.next()) {
				
				// Retrieve by column name
				int authorId = rs.getInt("author_id");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				String imagePath = rs.getString("image");
				String bio = rs.getString("bio");
				// Fill authorlist with all authors in our database
				authorlist.add(new Author(authorId, name, surname, imagePath, bio));
				
			}

			rs.close();
			stmt1.close();
			
			return authorlist;

		} catch (Exception e) {
			
			throw new Exception("An error occured while getting authors from database: " + e.getMessage());
		}
		
	}//End of getAllAuthors
	
	
	public List<User> getAllUsers() throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "SELECT * FROM user;";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			ResultSet rs = stmt1.executeQuery();

			List<User> userlist = new ArrayList<>();
						
			while(rs.next()) {
				
				// Retrieve by column name
				int userId = rs.getInt("user_id");
				String username = rs.getString("username");
				String password = rs.getString("password");
				String name = rs.getString("name");
				String surname = rs.getString("surname");
				int yearOfBirth = rs.getInt("birth_year");
				String sex = rs.getString("sex");
				// fill userlist with all users in our database
				userlist.add(new User(userId, username, password, name, surname, yearOfBirth, sex));
				
			}

			rs.close();
			stmt1.close();
			
			return userlist;

		} catch (Exception e) {
			
			throw new Exception("An error occured while getting users from database: " + e.getMessage());
		}
		
	}//End of getAllUsers
	
	
	public List<Rating> getAllRatings() throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "SELECT * FROM rating;";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			ResultSet rs = stmt1.executeQuery();

			List<Rating> ratinglist = new ArrayList<>();
						
			while(rs.next()) {
				
				// Retrieve by column name
				int userId = rs.getInt("user_id");
				int bookId = rs.getInt("book_id");
				int rating = rs.getInt("rating");
				String review = rs.getString("review");
				// fill ratingslist with all ratings in our database
				ratinglist.add(new Rating(userId, bookId, rating, review));
				
			}

			rs.close();
			stmt1.close();
			
			return ratinglist;

		} catch (Exception e) {
			
			throw new Exception("An error occured while getting ratings from database: " + e.getMessage());
		}
		
	}//End of getAllRatings
	
	public int totalBookRatings(int bookId) {
		int count = 0;
		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "select count(*) as cnt from rating where book_id = " +bookId +";";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			ResultSet rs = stmt1.executeQuery();

			rs.next();
				
				count = rs.getInt("cnt");

			rs.close();
			stmt1.close();

		} catch (Exception e) {
			
			try {
				throw new Exception("An error occured while getting number of book ratings from database: " + e.getMessage());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return count;
	}
	
		
	public double averageBookRating(int bookId) throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "SELECT avg(rating) as average FROM rating WHERE book_id = " +bookId +";";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			ResultSet rs = stmt1.executeQuery();

			rs.next();
				
				double avg = rs.getDouble("average");

			rs.close();
			stmt1.close();
			
			return avg;

		} catch (Exception e) {
			
			throw new Exception("An error occured while getting average book rating from database: " + e.getMessage());
		}
		
	}
	
	public List<Integer> getUsersWishlist(int userId) throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "SELECT book_id FROM wishlist WHERE user_id = " +userId +";";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			ResultSet rs = stmt1.executeQuery();

			List<Integer> userWishlist = new ArrayList<>();
						
			while(rs.next()) {
				
				int bookId = rs.getInt("book_id");
				// Fill userWishlist with all books in wishlist table that have this user's id
				userWishlist.add(bookId);
				
			}

			rs.close();
			stmt1.close();
			
			return userWishlist;

		} catch (Exception e) {
			
			throw new Exception("An error occured while getting wishlist entries from database: " + e.getMessage());
		}
		
	}
	
	public List<Integer> getBookRatings(int bookId) throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "SELECT user_id FROM rating WHERE book_id = " +bookId +";";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			ResultSet rs = stmt1.executeQuery();

			List<Integer> usersWhoRatedIt = new ArrayList<>();
						
			while(rs.next()) {
				
				int userId = rs.getInt("user_id");
				// Fill usersWhoRatedIt list with the ids of users who have rated this book
				usersWhoRatedIt.add(userId);
				
			}

			rs.close();
			stmt1.close();
			
			return usersWhoRatedIt;

		} catch (Exception e) {
			
			throw new Exception("An error occured while getting userIds from ratings from database: " + e.getMessage());
		}
		
	}
	
	public void printAllBooks() {
		try {
			for (Book book : this.getAllBooks()) {
				System.out.println(book);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printAllRatings() {
		try {
			for (Rating rating : this.getAllRatings()) {
				System.out.println(rating.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Book getBook(int bookId) {
		try {
			for (Book book : this.getAllBooks()){
				if (book.getBookId() == bookId){
					return book;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Author getAuthor(int authorId) {
		try {
			for (Author author : this.getAllAuthors()){
				if (author.getAuthorId() == authorId){
					return author;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public User getUser(int userId) {
		try {
			for (User user : this.getAllUsers()){
				if (user.getUserId() == userId){
					return user;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void addRating(int userId, int bookId, int rating, String review) throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "INSERT INTO rating (user_id, book_id, rating, review)" + "VALUES (?, ?, ?, ?)";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			
			// insert values to above query
			stmt1.setInt(1, userId);
			stmt1.setInt(2, bookId);
			stmt1.setInt(3, rating);
			stmt1.setString(4, review);
			
			stmt1.executeUpdate();

			stmt1.close();

		} catch (Exception e) {
			
			throw new Exception("An error occured while inserting rating into database: " + e.getMessage());
		}		
	}
	
	public void updateRating(int userId, int bookId, int rating, String review) throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "UPDATE rating SET rating=" +rating +" , review='" +review +"' WHERE user_id=" +userId +" AND book_id=" +bookId +";";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			
			stmt1.executeUpdate();

			stmt1.close();

		} catch (Exception e) {
			
			throw new Exception("An error occured while updating rating: " + e.getMessage());
		}		
	}
	
	public void addtoWishlist(int userId, int bookId) throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "INSERT INTO wishlist (user_id, book_id)" + "VALUES (?, ?)";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			// insert values to above query
			stmt1.setInt(1, userId);
			stmt1.setInt(2, bookId);
			
			stmt1.executeUpdate();

			stmt1.close();

		} catch (Exception e) {
			
			throw new Exception("An error occured while inserting wishlist entry to database: " + e.getMessage());
		}		
	}
	
	public void removeFromWishlist(int userId, int bookId) throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "DELETE FROM wishlist WHERE book_id =" +bookId +" AND user_id =" +userId +";";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			
			stmt1.executeUpdate();

			stmt1.close();

		} catch (Exception e) {
			
			throw new Exception("An error occured while removing wishlist entry: " + e.getMessage());
		}		
	}
	
	public void deleteRating(int userId, int bookId) throws Exception {

		try {

			if(con == null) {
				throw new Exception("You must open a connection first");
			}
			
			String sqlquery= "DELETE FROM rating WHERE book_id =" +bookId +" AND user_id =" +userId +";";
			
			PreparedStatement stmt1 = con.prepareStatement(sqlquery);
			
			stmt1.executeUpdate();

			stmt1.close();

		} catch (Exception e) {
			
			throw new Exception("An error occured while deleteing review: " + e.getMessage());
		}		
	}
	
	public String getParagraphs (String text) { // make paragraphs visible in html
		return text.replace("\n", "<br>").replaceAll("\r", "<br>");
	}
	
}
