package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PostsDAO;

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
	
		
//	    // セッションスコープからユーザー情報を取得
//		HttpSession session = request.getSession();
//	    User loginUser = (User) session.getAttribute("loginUser");
//	    
//	    PostData postData = new PostData();
//		
//	    // セッションスコープからレスポンスユーザーネームを取得
//	    String resUser = loginUser.getName();
//	 // PostDataインスタンスのIDを取得
//	    String reqIdString = request.getParameter("ID");
//	    int reqId = Integer.parseInt(reqIdString);
//	    
//	    UserResponseLogic userResponseLogic = new UserResponseLogic();
//	    userResponseLogic.pushResButton(resUser,reqId);
//	      
//	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/responseNotice.jsp");
//	      dispatcher.forward(request, response);
		PostsDAO dao = new PostsDAO();
		boolean result = dao.isButton(50);
		System.out.println(result);
	}
}
