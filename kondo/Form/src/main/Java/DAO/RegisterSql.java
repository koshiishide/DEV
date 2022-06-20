package main.Java.DAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.Java.User;



public class RegisterSql extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
}
	
// データベース接続に試用する情報
private final String JDBC_URL = "jdbc:h2:tcp://localhost/~~/Project1";
private final String DB_USER = "sa";
private final String DB_PASS = "";

User h1 =(User)session.getAttribute("User");


public List<Register> findAll(){


List<Register> regList = new ArrayList<>();

// データベースへ接続
try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){


// SELECT文を準備
String sql = "INSERT INTO USERS(ID, PASSWORD) " +
"VALUES('" + id + "','" + password + ")";

PreparedStatement pStmt = conn.prepareStatement(sql);


// INSERTを実行し、結果票を取得
ResultSet rs = pStmt.executeQuery();

// 結果票に格納されたレコードの内容を
// Employインスタンスに設定し、ArrayListインスタンスに追加
while (rs.next()) {
String id = rs.getString("id");
String pw = rs.getString("pw");
Register register = new Register(id, pw);
regList.add(register);
 }

} catch (SQLException r) {
r.printStackTrace();
return null;
}
return regList;
}

}
