package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Project1.RegisterUserLogic;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// フォワード先
		String forwardPath = null;
		
		
		// サーブレットクラスの動作を決定する「action」の値を
		// リクエストパラメータから取得
		String action = request.getParameter("action");
		
		// 「ログイン」をリクエストされたときの処理
		if (action == null) {
			// フォワード先を設定
			forwardPath = "/WEB-INF/jsp/dfjdslkfs;jfdkfjs.jsp";
		}
		
		// ログイン確認画面から「ログイン」をリクエストされた時の処理
		else if (action.equals("done")) {
			// セッションスコープに保存された登録ユーザーを取得
			HttpSession session = request.getSession();
			User registerUser = (User) session.getAttribute("registerUser");
			
			
			
		// 登録処理の呼び出し
		RegisterUserLogic logic = new RegisterUserLogic();
		logic.execute(registerUser);
		 
		// 不要となったセッションスコープ内のインスタンスを削除
		session.removeAttribute("registerUser");
		
		// 登録後のフォワードを設定
		forwardPath = "";
		}
		
		// 設定されたフォワード先にフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// User_register と Monster_update 
		
		// リクエストパラメータの取得
		
		request.setCharacterEncoding("UTF-8");
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		
		// 登録するユーザーの情報を設定
		User registerUser = new User();
		
		// セッションスコープに登録ユーザーを保存
		HttpSession session = request.getSession();
		session.setAttribute("registUser", registerUser);
		
		// フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Stiringpath.jsp");
		dispatcher.forward(request, response);
		
		
		// error msg
		String errorMsg = "";
		if (user_id == null || user_id.length() == 0) {
			errorMsg += "idが入力されていません<br>";
		}
		if (user_pw == null || user_pw.length() == 0) {
			errorMsg += "passwordが入力されていません<br>";
		}
		
		
		// 表示するメッセージを設定
		String msg = user_id + "さん、ログインされました。";
		if (errorMsg.length() != 0) {
			msg = errorMsg;
		}
		
		
	
		// HTMLを出力 
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset=\"UTF-8\">");
		out.print("<title>ユーザーログイン</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<p>"+msg+"</p>");
		out.print("</body>");
		out.print("</html>");
		
	}

}
