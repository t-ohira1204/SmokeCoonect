package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {
  // データベース接続に使用する情報
  private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/SmokeConnect";
  private final String DB_USER = "sa";
  private final String DB_PASS = "";

  public String findLoginData(String userName) {
	  String pass=null;
	  // JDBCドライバを読み込む
	  try {
		  Class.forName("org.h2.Driver");
		  } catch (ClassNotFoundException e) {
			  throw new IllegalStateException("JDBCドライバを読み込めませんでした");
			  }
	  // データベースへ接続
	  try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

		  // SELECT文を準備
		  String sql = "SELECT * FROM USERS WHERE NAME = ?";
		  PreparedStatement pStmt = conn.prepareStatement(sql);
		  pStmt.setString(1, userName);
      
		  // SELECTを実行し、結果表を取得
		  ResultSet rs = pStmt.executeQuery();

		  // 取得した結果を変数passにいれる
		  while (rs.next()) {
			  pass = rs.getString("PASS");
			  }
		  } catch (SQLException e) {
			  e.printStackTrace();
			  return null;
			  }
	  return pass;
	  }
  
  public boolean registerUserData(String userName,String pass) {
	  // JDBCドライバを読み込む
	  try {
		  Class.forName("org.h2.Driver");
		  } catch (ClassNotFoundException e) {
			  throw new IllegalStateException("JDBCドライバを読み込めませんでした");
			  }
	  // データベースへ接続
	  try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

		  // SELECT文を準備
		  String sql = "INSERT INTO USERS(NAME,PASS)VALUES(?,?)";
		  PreparedStatement pStmt = conn.prepareStatement(sql);
		  pStmt.setString(1,userName);
		  pStmt.setString(2,pass);
	      
	      
		  // INSERTを実行し、登録ユーザー
		  int r = pStmt.executeUpdate();
		  if(r != 1) {
			  return false;
			  }
		  return true;
		  } catch (SQLException e) {
			  e.printStackTrace();
			  return false;
			  }
	  }
}