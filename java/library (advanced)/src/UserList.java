import java.util.*;

public class UserList {

	//fields
	private LinkedList<User> userList;
	
	//getters & setters
	public LinkedList<User> getUserList() {return userList;}
	public void setUserList(LinkedList<User> userList) {this.userList = userList;}
	
	// constructors
	public UserList() {
		this.userList = new LinkedList<User>();
	}
	public UserList(User[] userlist) {
		this();
		for (User user : userlist)
			this.addUser(user);
	}
	
	//methods
	public void addUser(User user){
		this.userList.add(user);
	}
	
	public void removeUser(User user){
		if (this.userList.remove(user)) {
			System.out.println(user.toString() +" removed.\n");
		}
		else {
			System.out.println(user.toString() +" not found.\n");
		}
	}
	
	public void printUserList (){
		System.out.println(this.userList);
	}
	
	public User returnUser (int user_id) {
		for (User user : userList) {
			if (user.getUser_id() == user_id) {
				return user;				
			}
		}
		System.out.println("User_id " +user_id +" does not exist.");
		return null;
	}
	
}
