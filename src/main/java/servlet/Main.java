package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostData;
import model.Posting;
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
    // つぶやきリストをアプリケーションスコープから取得
    ServletContext application = this.getServletContext();
    List<Posting> postingList = (List<Posting>) application.getAttribute("postingList");
    // 取得できなかった場合は、つぶやきリストを新規作成して
    // アプリケーションスコープに保存
    if (postingList == null) {
      postingList = new ArrayList<>();
      application.setAttribute("postingList", postingList);
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
    // リクエストパラメータの取得
    request.setCharacterEncoding("UTF-8");
    String place = request.getParameter("place");
    String time = request.getParameter("time");
    
    //PostDataインスタンス（投稿内容情報）の生成
    PostData postData = new PostData(place,time,formatNowTime);

    // 入力値チェック
    if (place != null && time != null) {
      // アプリケーションスコープに保存されたつぶやきリストを取得
      ServletContext application = this.getServletContext();
      List<Posting> postingList = (List<Posting>) application.getAttribute("postingList");

      // セッションスコープに保存されたユーザー情報を取得
      HttpSession session = request.getSession();
      User loginUser = (User) session.getAttribute("loginUser");

      // つぶやきをつぶやきリストに追加
      Posting posting = new Posting(loginUser.getName(), place,time,formatNowTime);
      PostingLogic postingLogic = new PostingLogic();
      postingLogic.execute(posting, postingList);

      // アプリケーションスコープにつぶやきリストを保存
      application.setAttribute("postingList", postingList);
    } else {
      //エラーメッセージをリクエストスコープに保存
      request.setAttribute("errorMsg", "喫煙所もしくは滞在時間を選択してください。");
    }

    // メイン画面にフォワード
    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/umedaArea.jsp");
    dispatcher.forward(request, response);
  }
}