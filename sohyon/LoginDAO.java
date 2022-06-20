
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import main.index;


public class LoginDAO {
	
	
	// データベース接続に試用する情報
	
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/ /Project1";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public List<Login> findAll(){
		List<Login> logList = new ArrayList<>();

		
	// データベースへ接続
	try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
		
		
	// SELECT文を準備
	String sql = "SELECT ID, PASSWORD FROM USERS";
	PreparedStatement pStmt = conn.prepareStatement(sql);
	
	
	// SELECTを実行し、結果票を取得
	ResultSet rs = pStmt.executeQuery();
	
	// 結果票に格納されたレコードの内容を
	// Loginインスタンスに設定し、ArrayListインスタンスに追加
	while (rs.next()) {
		String id = rs.getString("id");
		String pw = rs.getString("pw");
		Login login = new Login(id, pw);
		logList.add(login); 
		}
	} catch (SQLException r) {
		r.printStackTrace();
		return null:
	}
		return regList;
	}
	

}