import java.util.ArrayList;

public class Group {

	protected String name;
	private String description;
	private ArrayList<User> members = new ArrayList<User>();
	protected ArrayList<Post> posts = new ArrayList<Post>();
	protected Post lastPost;
	
	public Group(String aName, String aDescription){
		name = aName;
		description = aDescription;
	
	}

	public String getName(){
		return name;
	}

	public ArrayList<User> getMembers(){
		return members;
	}
	
	
	public  ArrayList<Post> setPost(ArrayList<Post> aPosts){
		return posts;
	}
	
	
	
	public boolean isMember(User user){
		if (members.contains(user)){
			return true;
		}else return false;
	}
	
	public void addMember(User user){
		if (!isMember(user)){
			members.add(user);
			user.addGroup(this);
		}
	}

	public void print(){
		System.out.println("************************");
		System.out.println("Members of group " + name);
		System.out.println("************************");
		int i=1;
		for (User user: members){
			System.out.println(i+": " +user.getName());
			i++;
		}
		System.out.println("--------------------------------------");
	}
	
	public void addPost(Post aPost){
		if (members.contains(aPost.getUser())){
			posts.add(aPost);	
			lastPost = aPost;
			
			}
		else System.out.println("User " + aPost.getUser().getName() + " cannot post on Private Group " + name);
	}
	
	public void addReplyToPost(Post p1, Post p1reply){
		if (members.contains(p1reply.getUser())){
			p1.setReply(p1reply);
		}else System.out.println("User " + p1reply.getUser().getName() + " cannot post on Private Group " + name);
	}

	public void printWall(){
		System.out.println("Group " + name + " wall");
		for (Post post: posts){
			post.printPost();
		}
	}


	public void getLatestPost(){
		lastPost.printPost();
	}


	
}
