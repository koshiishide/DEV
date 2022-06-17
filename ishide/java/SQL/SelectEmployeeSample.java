package SQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SelectEmployeeSample
 */
@WebServlet("/SelectEmployeeSample")
public class SelectEmployeeSample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectEmployeeSample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("0try終わり");
		try {
			Class.forName("org.h2.Driver");
			} catch(ClassNotFoundException e1){
			e1.printStackTrace();
			}
		System.out.println("1try終わり");
		 try (Connection conn = DriverManager.getConnection(
			        "jdbc:h2:tcp://localhost/~/test", "sa", "")) {

			      // SELECT文を準備
			      String sql = "SELECT ID,NAME,AGE FROM TEST";
			      PreparedStatement pStmt = conn.prepareStatement(sql);

			      // SELECTを実行し、結果表（ResultSet）を取得
			      ResultSet rs = pStmt.executeQuery();

			      // 結果表に格納されたレコードの内容を表示
			      while (rs.next()) {
			        String id = rs.getString("ID");
			        String name = rs.getString("NAME");
			        int age = rs.getInt("AGE");

			        // 取得したデータを出力
			        System.out.println("ID:" + id);
			        System.out.println("名前:" + name);
			        System.out.println("年齢:" + age + "\n");
			      }
			    } catch (SQLException e) {
			      e.printStackTrace();
			    }
			  }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
