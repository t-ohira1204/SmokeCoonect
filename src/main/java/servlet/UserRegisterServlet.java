package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserRegisterLogic;

@WebServlet("/UserRegisterServlet")
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UserRegisterServlet() {
        super();
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    // リクエストパラメータの取得
	    request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("name");
	    String pass = request.getParameter("pass");

	    // Userインスタンス（ユーザー情報）の生成
	    User user = new User(name, pass);
	    
	    // 登録処理
	    UserRegisterLogic userRegisterLogic = new UserRegisterLogic();
	    boolean isRegister = userRegisterLogic.execute(user);
	    
	    //登録成功時の処理
	    if(isRegister) {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerSuccess.jsp");
	        dispatcher.forward(request, response);
	    }else{
	    	RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registerMiss.jsp");
	    	dispatcher.forward(request, response);
	    }
	}
}
