import java.util.ArrayList;

public class User {

	private String name;
	private String email;
	private ArrayList<Group> groups = new ArrayList<Group>();
	private ArrayList<User> friends = new ArrayList<User>();

	
	public User(String aName, String anEmail){
		name = aName;
		email = anEmail;
	}
	
	public boolean isFriend(User other){
		if (friends.contains(other)){
			return true;
		}else return false;
	}
	
	public void addFriend(User aFriend){
		if (aFriend != this){
			if (!isFriend(aFriend)){
				friends.add(aFriend);
				aFriend.friends.add(this);
				System.out.println(name + " and " + aFriend.name + " are now friends!");
			}
			else System.out.println("Already friends");
		}else System.out.println("It's the same person");
		
	}
	
	public void addGroup(Group aGroup){
		if (!groups.contains(aGroup)){
			groups.add(aGroup);
		}
	}
	
	private ArrayList<User> cfriends = new ArrayList<User>();
	public ArrayList<User> findCommon(User aFriend){

			for (User user : aFriend.friends){
				if (!cfriends.contains(user)){
					if (friends.contains(user) && aFriend.friends.contains(user))
					cfriends.add(user);
				}
			}
		
		return cfriends;	
	}
	
	public void printCommonFriends(User aUser){
		System.out.println("**************************************");
		System.out.println("Common friends of " + name + " and " + aUser.name);
		System.out.println("**************************************");
		int i=1;
		for (User user :findCommon(aUser)){
			System.out.println(i+": " +user.name);
			i++;
		}
		System.out.println("**************************************");
		
	}

	
	private ArrayList<User> sfriends = new ArrayList<User>();
	public ArrayList<User> findSuggested(){
		
		for (User user : friends){
			for (User other : user.friends){
				if (other != this  && !friends.contains(other)){
				sfriends.add(other);
				}	
			}
		}
		return sfriends;
	}
	
	
	public void printSuggestedFriends(){
		System.out.println("--------------------------------------");
		System.out.println("Suggested friends for " + name + " :");
		for (User user :findSuggested()){
			System.out.println(user.name);
		}
		System.out.println("--------------------------------------");
		
	}
	
	
	public void printFriends(){
		System.out.println("************************");
		System.out.println("Friends of " + name);
		System.out.println("************************");
		int i=1;
		for (User user: friends){
			System.out.println(i+": " +user.name);
			i++;
		}
		System.out.println("--------------------------------------");
	}
	
	public void printGroups(){
		System.out.println("**************************************");
		System.out.println("Groups that " + name + " has enrolled");
		System.out.println("**************************************");
		int i=1;
		for (Group group: groups){
			System.out.println(i+": " +group.getName());
			i++;
		}
		System.out.println("--------------------------------------");
	}
	
	public String getName(){
		return name;
	}
	
	
	public Post createPost(String aText){
		Post p1 = new Post(aText, this);	
		return p1;		
	}
	
	public ArrayList<User> getFriends() {
		return friends;
	}

}
