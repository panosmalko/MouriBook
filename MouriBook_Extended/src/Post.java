import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Post {

	private Date timestamp;
	private String text;
	private User user;
	private Post reply;
	
	private ArrayList<Post> replies = new ArrayList<Post>();
	
	public Post(String aText, User aUser){
		text = aText;
		Date date = new Date();
		SimpleDateFormat dateformat2 = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");
		try {
			 timestamp = dateformat2.parse(dateformat2.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		reply = null;
		user = aUser;
	}

	public void printPost(){
		
		System.out.println("| " + timestamp + " | " + user.getName() + " : "  +  text);
		
		
		
			for (int i=0; i<replies.size(); i++){
				System.out.println("  -> | " + replies.get(i).timestamp + " | " + replies.get(i).user.getName() + " : "  +  replies.get(i).text);


				while (replies.get(i).replies.size() != 0){
					System.out.println("  -> | " + replies.get(i).replies.get(i).timestamp + " | " + replies.get(i).replies.get(i).user.getName() + " : "  +  replies.get(i).replies.get(i).text);

					replies.get(i).replies = replies.get(i).replies.get(i).replies;
				}	
		}
		
	
		}
	
	public void setReply(Post aReply) {		
			replies.add(aReply);
	}
	
	
	public User getUser(){
		return user;
		}
	
	public Post getReply(){
		return reply;
		}
	
	public String getText(){
		return text;
		}
	
	}



