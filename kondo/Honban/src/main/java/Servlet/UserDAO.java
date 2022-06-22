package Servlet;

public class UserDAO  { 
	public boolean findByLogin(User user ,User user2) {
		//JAVAAPICALL
		/*
		 検証
		 user2を検証する
		 
		 */
		//try excep	
		//System.out.print("##################findByLogin#####################");
		String id = user.getId();
		String password = user.getPassword();
		//System.out.print(password+":password\n");
		String password2 = user2.getPassword();
		//System.out.print(password2+":password2\n");
		
		if (password.equals(password2)) {
			System.out.print("Succed");
			return true;
		}else {
			System.out.print("Fail");
			return false;
		}
	}
//		if(id.isEmpty()) {
//			return null;
//			}
//			int idLen = id.length();
//			int passLen =  password.length();
//			
//			if(idLen > 5 || passLen >5) {
//			return null;
//			
//		}else{	
//			return user;
//	}}
	public boolean RegisterAccount(User user) {
	return true;
	}
}