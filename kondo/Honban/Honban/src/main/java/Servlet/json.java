package Servlet;

import java.io.BufferedReader;
//サーブレットで必要
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet("/json")
public class json extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  
  

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
	  
	         
	  URL url=new URL("https://18.176.81.208/api.rsc/game_public_users/");
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

	  String js = sb.substring(87,125);
	  
	  response.setContentType("text/html; charset=UTF-8");
	  PrintWriter out = response.getWriter();

	  ObjectMapper mapper3 = new ObjectMapper();

	  JsonUser user3 = mapper3.readValue(js, JsonUser.class);
	  

	  br.close();
	  is.close();
	  secureConn.disconnect();
	  
	  System.out.println(sb.substring(87,125));
	  }
	  
  }



