
public class Main {

	public static void main(String[] args) {
		
		User u1 = new User("Teo", "chaikalis@uom.gr");
		User u2 = new User("Makis", "makis@uom.gr");
		User u3 = new User("Petros", "petros@uom.gr");
		User u4 = new User("Stefania", "stefania@uom.gr");
		User u5 = new User("Nikoleta", "nikoleta@uom.gr");
		User u6 = new User("Marina", "marina@uom.gr");
		
		Group g1 = new Group("Efarmosmeni","Ena group gia tous kammenous pliroforikous");
		Group g2 = new Group("Oikonomikwn Epistimon","Oloi oi giapides se ena meros!");
		
		
		u1.addFriend(u2);
		u2.addFriend(u3);
		u1.addFriend(u3);
		u1.addFriend(u4);
		u1.addFriend(u5);
		u4.addFriend(u2);
		u4.addFriend(u5);
		u6.addFriend(u1);
		u5.addFriend(u2);
	
		u1.addGroup(g1);
		u1.addGroup(g2);
		u2.addGroup(g1);
		u5.addGroup(g1);
		u6.addGroup(g1);
		
		
		u1.printCommon(u3);
		u3.printCommon(u1);
		
		u1.printFriends();
		u2.printFriends();
		
		u1.printGroups();

		g1.print();
		
	}

}
