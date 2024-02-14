package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

}
