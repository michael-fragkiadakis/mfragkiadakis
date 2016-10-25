import java.util.*;

public class BookRental extends Transaction {

	//constructors
	public BookRental() {
		super();
	}

	public BookRental(Book book, User user) {
		super(book, user);
	}

	//methods
	@Override
	public String toString() {
		return "BookRental [RequestDate()=" + getRequestDate() + ", ServerDate()=" + getServerDate()
				+ ", User ID().=" + getUser().getUser_id() + ", Id()=" + getId() + ", Book()=" + getBook().getIsbn() +"]";
	}
	
	public void modifyBookCounters () {
		this.getBook().setAvailable_copies(this.getBook().getAvailable_copies() -1);
		this.getBook().setTimes_rented(this.getBook().getTimes_rented() +1);
	}
	
}
