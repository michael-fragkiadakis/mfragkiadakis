<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, java.io.*" %>
<%@ page import="Bookcamp.Author" %>
<%@ page import="Bookcamp.Book" %>
<%@ page import="Bookcamp.User" %>
<%@ page import="Bookcamp.Rating" %>
<%@ page import="Bookcamp.BookDAO" %>

<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<%
	// Setting default user and book values for homrpage. You can change these as you wish (withing the iimits of existing database entries).
	int userId = 10;
	int bookId = 1;

	// bookId for all other pages
	String bookIdString = (String) request.getParameter("bookId");
	if (bookIdString != null) {
		bookId = Integer.parseInt(bookIdString);
	}

	// create BookDAO and open a connection
	BookDAO bdao = new BookDAO();
	bdao.open();
	Book currentBook = bdao.getBookById(bookId); //set current book
	
	// variables need for review edit
	boolean editON; //edit review mode OFF
	int currentRating = 0;
	String currentReview = null;	
	
	// From the home page (or any other) you can browse the other books from its author through the carousel
	// You can browse any book (bookId 1 to 46) by typing the appropriate bookId as a field in the url (ie. ?bookId=4).
%>

<!-- PAge icon & page -->
<link rel="icon" href="favicon.png">
<title>BooKcamp: <%= currentBook.getTitle() %></title>

<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
  
 
<link rel="stylesheet" href="box.css"> <!-- my page css -->
<link rel="stylesheet" href="star.css"> <!-- my stars css -->

</head>


<body>
	<% /* The first thing I have in the body is the form submition codes, so that the appropriate content is shown
	in the browser, depending on what forms have already been submitted - after submit refresh. Such as, the review
	being submitted, instantly shown in the reviews section above, or the interchange of wishlist buttons (add & remove).*/
	
		// Review form submit code
		if (!bdao.getBookRatings(bookId).contains(userId)) {
			
			if (request.getParameter("submit") != null) {
				int yourRating = 0;
				String yourReview = new String();

				if (request.getParameter("rating") != null) {
					yourRating = Integer.parseInt(request.getParameter("rating"));
				}
				if (request.getParameter("review") != null) {
					yourReview = request.getParameter("review");
				}
				
				bdao.addRating(userId, bookId, yourRating, yourReview); // insert rating into database
			}
		} else {
			
			if (request.getParameter("submit") != null) {
				int yourRating = currentRating;
				String yourReview = currentReview;

				if (request.getParameter("rating") != null) {
					yourRating = Integer.parseInt(request.getParameter("rating"));
				}
				if (request.getParameter("review") != null) {
					yourReview = request.getParameter("review");
				}
				
				bdao.updateRating(userId, bookId, yourRating, yourReview); // update rating
				editON = false; //edit review mode OFF
			}
		}
		
		if (request.getParameter("editON") != null) {
			editON = true; //edit review mode ON
		} else { editON = false; }
				
		if (editON) {
			if (request.getParameter("delete") != null) {
				bdao.deleteRating(userId, bookId); // delete review from database
			}
		}
		// edit
	
		// wishlist form submit code
		if (!bdao.getUsersWishlist(userId).contains(bookId)) {
			if (request.getParameter("wishlist") != null) {
				bdao.addtoWishlist(userId, bookId); // insert book to user's wishlist
			}	
		}
		
		if (bdao.getUsersWishlist(userId).contains(bookId)) {
			if (request.getParameter("remove") != null) {
				bdao.removeFromWishlist(userId, bookId); // remove book from user's wishlist
			}	
		}
	%>

	<!-- Default project navigation bar with no functionality at the moment. -->
	<nav class="navbar navbar-default navbar-fixed-top navbar-inner">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<img alt="Brand" src="images/logo.png" width=190 height=100% style="padding-right: 20px; margin-top: 8px;">
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">Home <span class="sr-only">(current)</span></a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Categories <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="#">Comedy</a></li>
							<li><a href="#">Drama</a></li>
							<li><a href="#">Fiction</a></li>
							<li><a href="#">Children's</a></li>
							<li><a href="#">Fantasy</a></li>
							<li><a href="#">Historical Fiction</a></li>
							<li><a href="#">Play</a></li>
							<li><a href="#">Science Fiction</a></li>
							<li><a href="#">Young adult</a></li>
						</ul></li>
				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search"
							size=70%>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">Log Out (<%= bdao.getUser(userId).getUsername() %>)</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<br>
	<br>
	<br>
	<div class="row">

		<div class="col-lg-3"> <!-- left hand panel -->
			<div class="panel panel-default" align="center">
				<img src="<%= currentBook.getImagePath() %>">
			</div>
			
			<p align=center>
			<% 
			if (!bdao.getUsersWishlist(userId).contains(bookId)) { // if book is not in user's wishlist, show <add to wishlist> button...
			%>
				<form name="wishlistForm" action="index.jsp" method="POST">
					<button name="wishlist" class="btn btn-info wishlist"><h3>Add to wishlist</h3></button>
					<input type="hidden" name="bookId" value="<%= bookId %>">
				</form>
			
			<% } else { // else, show <remove from wishlist> button... %>
				<form name="removeForm" action="index.jsp" method="POST">
					<button name="remove" class="btn btn-warning wishlist"><h3>Remove from wishlist</h3></button>
					<input type="hidden" name="bookId" value="<%= bookId %>">
				</form>
			<% } %>
			</p>
			
			<% int pix = (int) (bdao.averageBookRating(bookId) * 60); %> <!-- average rating translation from int to stars... -->
				<div id="container">
					<img src="images/0.png" class="wid"/> <!-- ...with image on image (check star.css for more info) -->
					<img src="images/5.png" class="wid" id="img2" style="clip: rect(0px,<%= pix %>px,1000px,0px);"/>
				</div>
			
			<div class="panel">
				<br>
				<h4 align=center> <!-- book info -->
					Average Rating: <span class="blue"> <%= bdao.averageBookRating(bookId) %> </span><br>
					Total ratings: <span class="blue"> <%= bdao.totalBookRatings(bookId) %> </span><br>
					Genre: <span class="blue"> <%= currentBook.getCategory() %> </span><br>
					Publisher: <span class="blue"> <%= currentBook.getPublisher() %> </span><br>
					Publication	Year: <span class="blue"> <%= currentBook.getPublicationYear() %></span><br>
					ISBN: <span class="blue"> <%= currentBook.getIsbn() %> </span>
				</h4>
				<br>
			</div>
			<div class="panel panel-default" align="center"> <!-- memes -->
				<% if ((bookId % 2) == 0) { %>
				<img src="images/dory.jpg" width=100%>
				<% } else { %>
				<img src="images/bequiet.jpg" width=100%>
				<% } %>
			</div>
		</div>




		<div class="col-lg-6"> <!-- central panel -->
			<div class="panel panel-default">
				<div class="panel-heading transparent">
					<h2>
						<%= currentBook.getTitle() %> <i>
						(by <%= currentBook.getAuthor().getName() + currentBook.getAuthor().getSurname() %>)</i>
					</h2>
				</div>
				<div class="panel-body">
					<% // show description with split paragraphs
					String descriptionWithParagraphs = bdao.getParagraphs(currentBook.getDescription());
					out.println(descriptionWithParagraphs);
					%>
				</div>
			</div>
			<div style="background: color url('images/pap2.png')"
				class="panel panel-default">
				<div class="panel-heading">
					<table width=100%>
						<tr>
							<td width=65%><h2 align=center>Reviews</h2></td>
							<!-- Unused button: <td align=right><button class="btn btn-info" style="width: 200px"><h3>Review this book</h3></button></td> -->
						</tr>
					</table>
				</div>
				<% 
				for (Rating rating : bdao.getAllRatings()) {
					if (rating.getBookId() == bookId) {
						int uId = rating.getUserId();
				%>
				<div class="panel-body"> <!-- List of user rating/reviews -->
					<table width="100%">
						<tr>
							<td>
							<% pix = rating.getRating() * 20; %>
							<div id="container">
								<img src="images/0.png" class="swid"/>
								<img src="images/5.png" class="swid" id="img2" style="clip: rect(0px,<%= pix %>px,1000px,0px);"/>
							</div>
							<% if (uId == userId) { %> <!--  "Highlight" review output if its the cureent user's -->
							<td align=right><h3>Your review!</h3>
							<td><form name="deleteReviewForm" action="index.jsp#revForm" method="POST">
									<button name="delete" class="btn btn-warning delete">DELETE</button>
									<input type="hidden" name="bookId" value="<%= bookId %>">
								</form>
								<form name="editReviewForm" action="index.jsp#revForm" method="POST">
									<button name="editON" class="btn btn-warning delete">EDIT</button>
									<input type="hidden" name="bookId" value="<%= bookId %>">
								</form>
						</tr>
					</table>
						<span class="blue"><b>
								<% if (rating.getReview() != null) { 
									currentRating = rating.getRating();
									currentReview = rating.getReview();
									out.println(currentReview); 
									} %> </b></span> <% 
								} else { %>

							<td align=right>Review by user: <span class="blue"><b> <%= bdao.getUser(uId).getUsername() %> </b></span>
						</tr>
					</table>
								<% if (rating.getReview() != null) { out.println(rating.getReview()); } 
									} %>
				</div>
				<% } } %>
			</div>
			
			<a name="revForm"></a> <!-- anchor to review form -->
			<% //if review of this book from this user already exists...
			if (bdao.getBookRatings(bookId).contains(userId)) { 
			%>
			<div class="panel panel-default" align="center"><h3>You have already rated this book.</h3></div>
			<% //...print this message instead of form
				if (editON == true) { // ...
			%>
					<form name="reviewForm" action="index.jsp#revForm" method="POST"
						class="form-horizontal blackbg">
						<div>
							<fieldset class="rating"> <!-- Star Rating (more info in star.css) -->
								<input type="radio" id="star5" name="rating" value="5" <% if (currentRating == 5) { %> checked="checked" <% } %> />
								<label class="full" for="star5" title="Brilliant - 5 stars"></label>
								<input type="radio" id="star4" name="rating" value="4" <% if (currentRating == 4) { %> checked="checked" <% } %> />
								<label class="full" for="star4" title="Great - 4 stars"></label>
								<input type="radio" id="star3" name="rating" value="3" <% if (currentRating == 3) { %> checked="checked" <% } %> />
								<label class="full" for="star3" title="Good - 3 stars"></label>
								<input type="radio" id="star2" name="rating" value="2" <% if (currentRating == 2) { %> checked="checked" <% } %> />
								<label class="full" for="star2" title="Ok - 2 stars"></label>
								<input type="radio" id="star1" name="rating" value="1" <% if (currentRating == 1) { %> checked="checked" <% } %> />
								<label class="full" for="star1" title="Bad - 1 star"></label>
							</fieldset>
						</div>
						<div class="form-group" style="margin-left: 25px;">
							<label for="comment">You can edit your previous rating/review here</label>
							<textarea name="review" class="form-control" rows="5" id="comment"><%= currentReview %></textarea>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="hidden" name="bookId" value="<%=bookId%>"> <!-- hidden field to POST current bookId -->
								<input type="submit" value="Submit" name="submit" class="btn-info" style="float: right" />
								<input type="reset" value="Reset (to your previous review)" name="reset" class="btn-info" style="float: right" />
							</div>
						</div>
					</form>
			<%
			}} else { // else show default review form
			%>
			<form name="reviewForm" action="index.jsp#revForm" method="POST"
				class="form-horizontal blackbg">
				<div>
					<fieldset class="rating"> <!-- Star Rating (more info in star.css) -->
						<input type="radio" id="star5" name="rating" value="5" />
						<label class="full" for="star5" title="Brilliant - 5 stars"></label>
						<input type="radio" id="star4" name="rating" value="4" />
						<label class="full" for="star4" title="Great - 4 stars"></label>
						<input type="radio" id="star3" name="rating" value="3" />
						<label class="full" for="star3" title="Good - 3 stars"></label>
						<input type="radio" id="star2" name="rating" value="2" />
						<label class="full" for="star2" title="Ok - 2 stars"></label>
						<input type="radio" id="star1" name="rating" value="1" />
						<label class="full" for="star1" title="Bad - 1 star"></label>
					</fieldset>
				</div>
				<div class="form-group" style="margin-left: 25px;">
					<label for="comment">Write your review here</label>
					<textarea name="review" class="form-control" rows="5" id="comment"></textarea>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="hidden" name="bookId" value="<%=bookId%>"> <!-- hidden field to POST current bookId -->
						<input type="submit" value="Submit" name="submit" class="btn-info" style="float: right" />
						<input type="reset" value="Clear" name="clear" class="btn-info" style="float: right" />
					</div>
				</div>
			</form>
			<% } %>
		</div>


		<div class="col-lg-3"> <!-- central panel -->
			<div class="panel panel-default" align="center">
				<div class="panel-heading">
					<h3>About the Author</h3>
				</div>
				<br> <img src="<%= currentBook.getAuthor().getImagePath() %>">
				<div class="panel-body"><%= currentBook.getAuthor().getBio() %></div>
			</div>

			<div class="panel panel-default carPanel">
				<div class="panel-heading" align="center">
					<h3>Other books by <%= currentBook.getAuthor().getName() %></h3>
				</div>
				<br>
				<%
				List <Book> authorsBooklist = bdao.getAuthorsOtherBooks(currentBook);
				if (authorsBooklist.size() == 0) {
					out.println("There are no other books by this author in our database");
				}
				else {
				%>
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<% 
						for (int i = 1; i < authorsBooklist.size(); i++) { // 1 instead of 0, because of active slide above
						%>
						<li data-target="#myCarousel" data-slide-to="<%= i %>"></li>
						<% } %>
					</ol>
					<div class="carousel-inner" role="listbox">
						<%
						boolean active = true;
						for (Book book : authorsBooklist) {
						%>
						<div class="item <% if (active) { out.println("active"); active = false; } // setting first slide as active} %>" align=center>
							<img class="slide" src="<%= book.getImagePath() %>" alt="slide">
							<div class="container">
								<div class="carousel-caption">
									<p>
										<a class="btn btn-lg btn-primary" href="?bookId=<%= book.getBookId() %>" role="button">More</a>
									</p>
								</div>
							</div>
						</div>
					<% } %>

					</div>
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
				<% } %>
				<!-- /.carousel -->

			</div>
		</div>


		<!-- Default project footer with no functionality at the moment. -->
		<footer>
			<div class="row">
				<div class="col-lg-12 text-center blackbg">
					<table align=center width=60%>
						<tr>
							<td align=center><a href="#">Policy</a>
							<td align=center><a href="#">Contact</a>
							<td align=center><a href="#">Top 25</a>
					</table>
				</div>
			</div>
		</footer>


		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script
			src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
			integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
			crossorigin="anonymous"></script>
			
		<% bdao.close(); // close connection %> 
</body>
</html>
