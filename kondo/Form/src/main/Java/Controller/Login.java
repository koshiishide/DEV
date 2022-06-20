package main.Java.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import main.Java.LoginLogic;
import main.Java.User;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		RequestDispatcher dispatcher =
//				request.getRequestDispatcher(
//				"/WEB-INF/jsp/loginResult.jsp");
//				dispatcher.forward(request, response);
		
	}
       
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
											throws ServletException, IOException {
	
	//リクエストパラメータの取得
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	
	//Userインスタンスの生成
	User user = new User(id,password);
	
	//ログイン処理
	LoginLogic loginLogic = new LoginLogic();
	boolean isLogin = loginLogic.execute(user);
	{
	
	//ログイン成功時
	if(isLogin) {
		HttpSession session = request.getSession();
		session.setAttribute("loginUser" , user);

	RequestDispatcher dispatcher =
			request.getRequestDispatcher(
			"/WEB-INF/loginResult.jsp");
			dispatcher.forward(request, response);
	}
		
}
}}