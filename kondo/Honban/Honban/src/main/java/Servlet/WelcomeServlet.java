package Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(
				"index.jsp");
				dispatcher.forward(request, response);		
		
	}

	
	//Try開始
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("id");
		String pass = request.getParameter("password");
		String hidden = request.getParameter("hidden");
		int flag = 0;
		
		//
		User user_login = new User();
		
		
	try {	
		
		
		//Validation
		
		if(userId.isEmpty()) {
		
		//入力が面へフォワード
	    RequestDispatcher dispatcher1 = request.getRequestDispatcher("kuuran.jsp");
		dispatcher1.forward(request, response);;
		
		if(userId.isEmpty()) {
			
		RequestDispatcher dispatcher2 = request.getRequestDispatcher("kuuran.jsp");
		dispatcher2.forward(request, response);;
		}
			
		}
		
		
		//}
	
	
		int passLen =  pass.length();
		int idLen = userId.length();
			
		if(idLen > 6  || passLen > 6) {
			//入力が面へフォワード
		 RequestDispatcher dispatcher = request.getRequestDispatcher("Mozisuu.jsp");
	     dispatcher.forward(request, response);;
			
		}
		

		
		String literal ="https://18.176.81.208/api.rsc/game_public_users(\"" + userId + "\")";
		
		//kokodake
		  URL url=new URL(literal);
		  HttpsURLConnection secureConn = (HttpsURLConnection) url.openConnection();
		  secureConn.setRequestProperty("x-cdata-authtoken", "2s9K2p9o6P9j3s7A5k8m");

		  // 証明書の検証をしない
		  // sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
		  SSLContext sslContext = null;
		  try {
			  sslContext = SSLContext.getInstance("SSL");
		  } catch (NoSuchAlgorithmException e1) {
			  // TODO 自動生成された catch ブロック
			  e1.printStackTrace();
		  }

		  try {
			  sslContext.init(null,
					  new X509TrustManager[] { new LooseTrustManager() },
					  new SecureRandom());
		  } catch (KeyManagementException e1) {
			  // TODO 自動生成された catch ブロック
			  e1.printStackTrace();
		  }

		  secureConn.setSSLSocketFactory(sslContext.getSocketFactory());
		  
		  // ホスト名の検証をしない
		  // java.security.cert.CertificateException: No name matching [ホスト名] found
		  // HttpsURLConnection.setDefaultHostnameVerifier(new LooseHostnameVerifier());
		  secureConn.setHostnameVerifier(new LooseHostnameVerifier());
		  secureConn.connect();

		  InputStream is = secureConn.getInputStream();
		  BufferedReader br = new BufferedReader(new InputStreamReader(is));
		  StringBuilder sb = new StringBuilder();
		  String line;
		  

		  while ((line = br.readLine()) != null) {
			  sb.append(line);
		  }
		  
		  
		  
		  
		  
	 	  
	      //String js = sb.toString();//sb.substring(87,125);
	      String js = sb.substring(87,sb.length());
	      js = "{"+js;
		  System.out.println(js);
	
		 	  
		  
		  response.setContentType("text/html; charset=UTF-8");
		  PrintWriter out = response.getWriter();

		  ObjectMapper mapper3 = new ObjectMapper();
		  
		 
		  JsonUser user3 = mapper3.readValue(js, JsonUser.class);
		  System.out.println(user3);

		  br.close();
		  is.close();
		  secureConn.disconnect();
		  
		  System.out.println(user3.id);
		  System.out.println(user3.password);
		  user_login= new User(user3.id, user3.password);
		  
		  /*
		  HttpSession session1 = request.getSession();
			session1.setAttribute("userjs",userjson );	
		  */
		  
		 // System.out.println(sb.substring(87,125));
		  
		  
	  }catch(NullPointerException e) {
		flag++;
		System.out.println(flag);
		
	  }catch(StringIndexOutOfBoundsException e) {
		  RequestDispatcher dispatcher = request.getRequestDispatcher("TadasiiNinsho.jsp");
		     dispatcher.forward(request, response);;
		  
	  }
	
		if(flag == 0) {
		System.out.println(flag);
    	//login or register
		//クエリパラメータ取得して
		/*
		 * 
		 * 
		 * 
		 * 
		
	
		ここでログイン処理か、アカウント作成するか分岐する
		*///register
		if(hidden.equals("register")) {
		System.out.println("############登録#############");
		User user = new User(userId,pass);
		UserDAO uD = new UserDAO();
		//jspからjsに値受け渡す
		
		User user_result = uD.RegisterAccount(user,user_login);
		
		
			if(user_result !=null) {
				HttpSession session = request.getSession();
				session.setAttribute("userID", userId);	
				RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("shinki.jsp");
				dispatcher.forward(request, response);
			}
		
		}
		else {
		System.out.println("############ログイン#############");
		/*
		*/
		//login処理
		User user = new User(userId,pass);
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(user,user_login);
		System.out.println("result");
		System.out.println(result);
		if(result) {//ログイン成功したら
			HttpSession session = request.getSession();
			session.setAttribute("userID", userId);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("Home.jsp");
			dispatcher.forward(request, response);
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		
		}
	}
	}		
}
