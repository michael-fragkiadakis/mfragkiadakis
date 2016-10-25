import java.util.*;

public class BookReturn extends Transaction {

	//constructors
	public BookReturn() {
		super();
	}

	public BookReturn(Book book, User user) {
		super(book, user);
	}

	//methods
	@Override
	public String toString() {
		return "BookReturn [RequestDate()=" + getRequestDate() + ", ServerDate()=" + getServerDate()
				+ ", User ID().=" + getUser().getUser_id() + ", Id()=" + getId() + ", Book()=" + getBook().getIsbn() +"]";
	}
	
	public void modifyBookCounters () {
		this.getBook().setAvailable_copies(this.getBook().getAvailable_copies() +1);
	}
	
}
