import java.util.ArrayList;

public class OpenGroup extends Group {

	
	
	public OpenGroup(String aName, String aDescription) {
		super(aName, aDescription);
		
	}
	

	public void addPost(Post aPost){
		int t = 0;
		for (User friend : aPost.getUser().getFriends()){
			if (getMembers().contains(friend)){
				t++;
			}
		}
		if (t>0){
			posts.add(aPost);
			lastPost = aPost;
		}	else System.out.println("User " + aPost.getUser().getName() + " cannot post on Open Group " + name);
	}
	
	public void addReplyToPost(Post p1, Post p1reply){
		
		int t = 0;
		for (User friend : p1reply.getUser().getFriends()){
			if (getMembers().contains(friend)){
				t++;
			}
		}
		if (t>0){
		p1.setReply(p1reply);}else System.out.println("User " + p1reply.getUser().getName() + " cannot post on Open Group " + name);
	}
}
	

	


