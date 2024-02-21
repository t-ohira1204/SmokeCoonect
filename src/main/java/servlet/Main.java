package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PostsDAO;
import model.PostData;
import model.PostingLogic;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
  private static final long serialVersionUID = 1L;
//現在日時を取得
Date nowTime = new Date(); //Sun Dec 20 13:56:23 JST 2020
//表示形式を指定
SimpleDateFormat sdf2
= new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
String formatNowTime = sdf2.format(nowTime); // 2020年12月20日 13時56分23秒

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  PostsDAO dao = new PostsDAO();
    List<PostData> postingList = (List<PostData>)dao.displayPostData();
    // 取得できなかった場合は、つぶやきリストを新規作成して
    // アプリケーションスコープに保存
    if (postingList == null) {
      postingList = new ArrayList<>();
    }
    
    // ログインしているか確認するため
    // セッションスコープからユーザー情報を取得
    HttpSession session = request.getSession();
    User loginUser = (User) session.getAttribute("loginUser");
    if (loginUser == null) { // ログインしていない場合
      // リダイレクト
      response.sendRedirect("index.jsp");
    } else { // ログイン済みの場合
      // フォワード
      RequestDispatcher dispatcher =
          request.getRequestDispatcher("WEB-INF/jsp/umedaArea.jsp");
      dispatcher.forward(request, response);
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    request.setCharacterEncoding("UTF-8");

	    // PostsDAOインスタンスを生成し、PostDataの情報を取得
	    PostsDAO dao = new PostsDAO();

	    // PostData型のリストpostingListにdisplayPostDataの情報を格納
	    List<PostData> postingList = dao.displayPostData();

	    // 新しい投稿データを取得
	    String userName = request.getParameter("userName");
	    String place = request.getParameter("place");
	    String time = request.getParameter("time");

	    // ここで新しい投稿データのIDを取得する方法が必要です。
	    // 以下は、単純に現在の時刻を使用する例です。
	    // 実際にはデータベースの自動生成IDや他の一意な方法を使用するべきです。
	    // 例: long id = System.currentTimeMillis();

	    // 取得した情報から新しいPostDataインスタンスを作成
	    PostData postData = new PostData(userName, place, time, 0); // 0 は仮のID

	    // IDを取得する（実際のデータベースによるIDの取得方法に置き換える）
//	    int id = dao.generateUniqueId(); // これは例で、実際のデータベースによるID生成メソッドを使用するべきです。
//	    postData.setId(id);

	    // PostingLogicのexecuteメソッドでpostingListに投稿内容をリストに追加
	    PostingLogic postingLogic = new PostingLogic();
	    postingLogic.execute(postData, postingList);

	    // メイン画面にフォワード
	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/umedaArea.jsp");
	    dispatcher.forward(request, response);
	}

}