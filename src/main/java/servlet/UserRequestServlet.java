package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostData;
import model.User;
import model.UserRequestLogic;

@WebServlet("/UserRequestServlet")
public class UserRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserRequestServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エリア選択画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/userRequestPost.jsp");
	    dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String place = request.getParameter("place");
		String time = request.getParameter("time");
		
		// セッションスコープからユーザー情報を取得
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		// PostDataインスタンスを生成
		PostData postData = new PostData(loginUser.getName(),place,time);
		
		// 登録処理
	    UserRequestLogic userRequestLogic = new UserRequestLogic();
	    boolean isRegister = userRequestLogic.setPostData(postData);
	    
	    //登録成功時の処理
	    if(isRegister) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/umedaArea.jsp");
	        dispatcher.forward(request, response);
	    }
	}	


}
