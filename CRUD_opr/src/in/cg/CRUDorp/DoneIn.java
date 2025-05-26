package in.cg.CRUDorp;

public class DoneIn {

	public static void main(String[] args) {
		UserDao data=new UserDao();
		 
	
//		data.insertUser(4, "Radha", (long) 875606, "ECE");
//		data.updateUser("Ram" , "EEE", 2);  
		data.deleteUser(2);
		data.fetchAllUsers();
		
		
	}

}
