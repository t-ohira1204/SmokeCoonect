package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

/**
 * Servlet implementation class UserResponseServlet
 */
@WebServlet("/UserResponseServlet")
public class UserResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserResponseServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エリア選択画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/responseNotice.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	    // セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
	    User loginUser = (User) session.getAttribute("loginUser");
		
	    // セッションスコープからレスポンスユーザーネームを取得
	    String resUser = loginUser.getName();
	    
	    //インスタンスを生成
	    ServletContext application = this.getServletContext();
		// レスポンスユーザーネームをアプリケーションスコープに保存
	      application.setAttribute("resUser", resUser);
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/responseNotice.jsp");
	      dispatcher.forward(request, response);
	}
}
