package Servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;

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

//import org.h2.util.json.JSONObject;
import org.json.JSONObject;

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
		System.out.println(userId);
		String pass = request.getParameter("password");
		String hidden = request.getParameter("hidden");
		//int flag = 0;
		User user_login = new User();
		
		System.out.println("hiddenだよ" + hidden);
		
		
		//
		
		
		  String users_id = "sample_ishide405";
		   String users_password = "sample_ishide405";
		   
		   // monster0変数
	//	   String monster0_userid ="sample3";
	//	   String monster0_monsterparam = "sample3";
	//	   int    monster0_monstertype = 0;
		   
		   // mosnterparm変数
	//	   String monsterparm_monsterparam = "sample3";
	//	   int    monsterparam_exp = 100;
	//	   int    monsterparam_hp  = 100;
	//	   int    monsterparam_mp = 100;
		
		
	try {	
		//Validation
			//ID or PASS は空欄？
		
		if(userId.isEmpty() || pass.isEmpty() ) {
			if(hidden.equals("login")) {
				 RequestDispatcher dispatcher1 = request.getRequestDispatcher("kuuranRelogin.jsp");
					dispatcher1.forward(request, response);;
			}else{
			   	 RequestDispatcher dispatcher1 = request.getRequestDispatcher("kuuranReregister.jsp");
					dispatcher1.forward(request, response);;
		}
		}
		
			//ID and PASS の文字数チェック
	
		int passLen =  pass.length();
		int idLen = userId.length();
			
		if(idLen > 6  || passLen > 6) {
			if(hidden.equals("login")) {
				 RequestDispatcher dispatcher1 = request.getRequestDispatcher("moziLenLogin.jsp");
					dispatcher1.forward(request, response);;
			}else{
			   	 RequestDispatcher dispatcher1 = request.getRequestDispatcher("moziLenRegister.jsp");
					dispatcher1.forward(request, response);;
		}
		}
		
		//Validatation 終わり
		
		
		//SQLアクセス
		String literal ="https://18.176.81.208/api.rsc/game_public_users(\"" + userId + "\")";
		
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
		  
		  
	 // }catch(NullPointerException e) {
		//  
	//	flag++;
	//	System.out.println(flag);
      
	  }catch(StringIndexOutOfBoundsException e) {
		  if(hidden.equals("login")) {
			  RequestDispatcher dispatcher = request.getRequestDispatcher("TadasiiNinsho.jsp");
			  dispatcher.forward(request, response);
			  System.out.print("outboundserro");
		  }else {
			 
		  }
		  
	  }
	
	
    	//login or register
		//クエリパラメータ取得して
	
		//ここでログイン処理か、アカウント作成するか分岐する
		///register
		if(hidden.equals("register")) {
		System.out.println("############登録#############");
		User user = new User(userId,pass);
		UserDAO uD = new UserDAO();
		//jspからjsに値受け渡す
		
		//なんもしてない バリデーションひつようならここで
		boolean user_result = uD.RegisterAccount(user);
		
		
		
		
		//API　POST呼び出し
		// users変数
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////
		

		URL url_users=new URL("https://18.176.81.208/api.rsc/game_public_users/");

		HttpsURLConnection secureConn_users = (HttpsURLConnection) url_users.openConnection();
		secureConn_users.setRequestProperty("x-cdata-authtoken", "2s9K2p9o6P9j3s7A5k8m");
		//接続タイムアウトを設定する。
		secureConn_users.setConnectTimeout(100000);
		//レスポンスデータ読み取りタイムアウトを設定する。
		secureConn_users.setReadTimeout(100000);
		//ヘッダーにContent-Typeを設定する
		secureConn_users.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
		//HTTPのメソッドをPOSTに設定する。
		secureConn_users.setRequestMethod("POST");
		//リクエストのボディ送信を許可する
		secureConn_users.setDoOutput(true);
		//レスポンスのボディ受信を許可する
		secureConn_users.setDoInput(true);



		// 証明書の検証をしない
		// sun.security.validator.ValidatorException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
		SSLContext sslContext_users = null;
		try {
		sslContext_users = SSLContext.getInstance("SSL");
		} catch (NoSuchAlgorithmException e1) {
		// TODO 自動生成された catch ブロック
		e1.printStackTrace();
		}



		try {
		sslContext_users.init(null,
		new X509TrustManager[] { new LooseTrustManager() },
		new SecureRandom());
		} catch (KeyManagementException e1) {
		// TODO 自動生成された catch ブロック
		e1.printStackTrace();
		}



		secureConn_users.setSSLSocketFactory(sslContext_users.getSocketFactory());

		// ホスト名の検証をしない
		// java.security.cert.CertificateException: No name matching [ホスト名] found
		// HttpsURLConnection.setDefaultHostnameVerifier(new LooseHostnameVerifier());
		secureConn_users.setHostnameVerifier(new LooseHostnameVerifier());
		secureConn_users.connect();

		//ステップ5:リクエストボディの書き出しを行う。
		OutputStream outputStream_users = secureConn_users.getOutputStream();
		HashMap<String, Object> jsonMap_users = new HashMap<>();


		// users
		jsonMap_users.put("id" ,users_id);
		jsonMap_users.put("password" , users_password);



		//JSON形式の文字列に変換する。
		JSONObject responseJsonObject_users = new JSONObject(jsonMap_users);
		String jsonText_users = responseJsonObject_users.toString();
		PrintStream ps_users = new PrintStream(secureConn_users.getOutputStream());
		ps_users.print(jsonText_users);
		ps_users.close();
		outputStream_users.close();



		String responseData_users = "";
		InputStream stream_users = secureConn_users.getInputStream();
		StringBuffer sb_users = new StringBuffer();
		String line_users = "";
		BufferedReader br_users = new BufferedReader(new InputStreamReader(stream_users, "UTF-8"));
		while ((line_users = br_users.readLine()) != null) {
		sb_users.append(line_users);
		}
		try {
		stream_users.close();
		} catch (Exception e_users) {
		e_users.printStackTrace();
		}
		responseData_users = sb_users.toString();
		System.out.print(responseData_users);


		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
			

			if(user_result !=false) {
				HttpSession session = request.getSession();
				session.setAttribute("userID", userId);	
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Home.jsp");
				dispatcher.forward(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("shinki.jsp");
				dispatcher.forward(request, response);
			}
		
		}
		else {
		System.out.println("############ログイン#############");
		
		
		
		//Register 終わり
		
		
		
		
		
		/*
		*/
		//login処理
		//System.out.println("セッションだす" + userId);
		User user = new User(userId,pass);
		//String bb = user.getId();
		//System.out.println("????????????????????" + bb);
		
		LoginLogic bo = new LoginLogic();
		boolean result = bo.execute(user,user_login);
		System.out.println("result");
		System.out.println(result);
		if(result) {//ログイン成功したら
			HttpSession session = request.getSession();
			session.setAttribute("userID", user);
			
			//User bb = (User) session.getAttribute("userID");
			//String bbb = bb.getId();
			//System.out.println("????????????????????" + bbb);
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Home.jsp");
			dispatcher.forward(request, response);
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		
		//Login 終わり
		
		}
	}
}		


