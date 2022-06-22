package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")

	public class Logout extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    public Logout() {
	        super();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        HttpSession session = request.getSession();
	        
	        //User h =(User)session1.getAttribute("userID");
	        //System.out.println("スコープだす" + h);
	        //User h1 =(User)session.getAttribute("userID");
	        //System.out.println("スコープだす" + h1);
	        //Sessionの破棄
	        request.logout();
	        session.invalidate();   
	        
	       
	       
	        
	        //1
	        request.getRequestDispatcher("Logout.jsp").forward(request,response);       //2
	    }

	}


