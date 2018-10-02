import java.util.ArrayList;

public class Group {

	private String name; 
	private String description;
	private ArrayList<User> members = new ArrayList<User>();
	
	public Group(String aName, String aDescription){
		name = aName;
		description = aDescription;
	
	}

	public String getName(){
		return name;
	}

	public boolean isMember(User user){
		if (members.contains(user)){
			return true;
		}else return false;
	}
	
	public void add(User user){
		if (!isMember(user)){
			members.add(user);
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
	
}
