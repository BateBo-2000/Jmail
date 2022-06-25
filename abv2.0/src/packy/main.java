package packy;

import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		//***************************************** PROGRAMATA SE PUSKA  OT TUK VINAGI ***********************************************//
		//************************************************** 3 241 REDA KOD **********************************************************//
		//creating the database
		ArrayList<user> users=new ArrayList<user>();
		
		//adding default user with one mail just for test purposes
		users.add(new user("Admin","Joestar","admin","ehqmr567","admin@jmail.com",25));
		//System.out.println(users.get(0).fname+" "+users.get(0).lname+" "+users.get(0).uname+" "+users.get(0).pass+" "+users.get(0).age+" "+users.get(0).id);
		//users.get(0).inbox.add(new mail("admin@jmail.com"," 3 kile banane "," odi da kupi6 zieli ", "69.69.69"));
		//System.out.println(users.get(0).inbox.get(0).sender+ " " + users.get(0).inbox.get(0).title + " " + users.get(0).inbox.get(0).text);
		users.add(new user("1","1","1","5","1",25));
		users.get(1).inbox.add(new mail("idk","sadfsadfsdfsafd"," abcsdafasd@kuramiqnko", "11.11.11"));
		users.get(1).inbox.add(new mail("idk","sadfsadfsdfsafd"," abcsdafasd@kuramiqnko", "11.11.11"));
		
		
		
		//starting the program
		login log=new login(users);
		log.setLocationRelativeTo(null);		//sets the window in the middle
		log.setVisible(true);
		

	}
}