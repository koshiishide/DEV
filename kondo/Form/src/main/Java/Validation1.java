package main.Java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Validation1")
public class Validation1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {

//リクエストパラメータの取得
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String password = request.getParameter("password");

//Userインスタンスの生成
User user = new User(id,password);

{
	// idのString空欄チェック
	if(id.isEmpty()) {
	
	RequestDispatcher dispatcher =
			request.getRequestDispatcher(
			"index.jsp");
			dispatcher.forward(request, response);		
	}
	int idLen = id.length();
	int passLen =  password.length();
	
	if(idLen > 5 || passLen >5) {
	RequestDispatcher dispatcher =
			request.getRequestDispatcher(
			"index.jsp");
			dispatcher.forward(request, response);		
	
}else{		
	HttpSession session = request.getSession();
	session.setAttribute("loginUser" , user);
	
	RequestDispatcher dispatcher =
			request.getRequestDispatcher(
			"/WEB-INF/Hello.jsp");
			dispatcher.forward(request, response);	
	
//	RequestDispatcher dispatcher =
//			request.getRequestDispatcher(
//			"DAO");
//			dispatcher.forward(request, response);
	}
}}}
