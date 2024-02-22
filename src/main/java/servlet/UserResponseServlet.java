package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserResponseLogic;

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
		
		// 通知画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/responseNotice.jsp");
	    dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String action = request.getParameter("action");
		if(action.equals("resAction")) {
	    // セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
	    User loginUser = (User) session.getAttribute("loginUser");
		
	    // セッションスコープからレスポンスユーザーネームを取得
	    String resUser = loginUser.getName();
	 // PostDataインスタンスのIDを取得
	    String reqIdString = request.getParameter("ID");
	    int reqId = Integer.parseInt(reqIdString);
	    
	    UserResponseLogic userResponseLogic = new UserResponseLogic();
//	    boolean isButtonResult = 
	    		userResponseLogic.pushResButton(resUser,reqId);
//	    if(isButtonResult == true) {
//	    	System.out.println("さーぶれっとでとぅるー！");
//	    }
	      
	      RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/umedaArea.jsp");
	      dispatcher.forward(request, response);
		}
		
		
		if(action.equals("Completed")) {
			//ここに「貸与完了ボタン」が押された時の処理
		}
		
		
		
		
			//テスト用
			//		PostsDAO dao = new PostsDAO();
			//		Boolean Result  = dao.isButton(53);
			//		System.out.println(Result);
			//テスト用
	}
}
