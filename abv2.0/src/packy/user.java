package packy;

import java.util.ArrayList;

public class user {
	//here is created all the data that a profile contains
	
	String fname;		// first name
	String lname;		// last name
	String uname;		// username
	String pass;		// password
	String address;		//email address
	int age;			//age
				
	
	ArrayList<mail> inbox=new ArrayList<mail>();	// the emails in the inbox are stored in arraylist of objects called inbox
	// thats a constructor for simpler code
	public user(String fname, String lname, String uname, String pass,String address, int age) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.pass = pass;
		this.address=address;
		this.age = age;
		
	}
}
