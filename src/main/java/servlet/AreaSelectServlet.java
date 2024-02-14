package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AreaSelectServlet")
public class AreaSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AreaSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// エリア選択画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/AreaSelect.jsp");
	    dispatcher.forward(request, response);
	}
}