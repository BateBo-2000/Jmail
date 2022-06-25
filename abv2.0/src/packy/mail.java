package packy;

public class mail {
	// same as the user just a lot simpler
	//string for the sender title and text data
	String sender;
	String title;
	String text;
	String date;
	boolean read=false;
	//again mail id is just for easier code (for now)

	
	//again constructor for simpler code
	public mail(String sender, String title, String text,String date) {
		super();
		this.sender = sender;
		this.title = title;
		this.text = text;
		this.date = date;
		
	}
}
