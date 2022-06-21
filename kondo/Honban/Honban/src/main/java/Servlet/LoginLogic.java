package Servlet;


public class LoginLogic{
	public boolean execute(User user,User user2) {
		UserDAO dao = new UserDAO();
		boolean result = dao.findByLogin(user, user2);
		System.out.println("############LoginLogic##########");
		System.out.println(user.getPassword());
		System.out.println(user2.getPassword());
		
		return result;
	}
}

