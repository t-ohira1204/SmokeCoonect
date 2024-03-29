package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PostData;
public class PostsDAO {
	// データベース接続に使用する情報
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/SmokeConnect";
	private final String DB_USER = "sa";
	private final String DB_PASS = "";
	
	public boolean registerPostData(String userName, String place, String time) {
		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
			}
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SQL文の準備（RETURN_GENERATED_KEYS フラグを指定）
			String sql = "INSERT INTO POSTS(NAME, PLACE, TIME) VALUES (?, ?, ?)";
			try (PreparedStatement pStmt = conn.prepareStatement(sql, new int[] { 1 })) {
				pStmt.setString(1, userName);
				pStmt.setString(2, place);
				pStmt.setString(3, time);
				
				// INSERTを実行し、投稿内容をINSERT
				int affectedRows = pStmt.executeUpdate();
				if (affectedRows == 0) {
					return false;
					}
				
				// 自動生成されたキー（ID）を取得
				try (ResultSet generatedKeys = pStmt.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						int id = generatedKeys.getInt(1);
						System.out.println("Generated ID: " + id);
						// ここで id を適切な場所にセットするか表示する処理を行ってください
						PostData postData = new PostData();
						postData.setId(id);
						} else {
							throw new SQLException("IDの取得に失敗しました。");
							}
					}
				return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
				}
	}
	
	public List<PostData> displayPostData() {
	List<PostData> postingList = new ArrayList<>();
	// JDBCドライバを読み込む
	try {
		Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
			}
	
	// データベースへ接続
	try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
		String sql = "SELECT * FROM POSTS";
		try (PreparedStatement pStmt = conn.prepareStatement(sql)) {
			try (ResultSet rs = pStmt.executeQuery()) {
				while (rs.next()) {
					String userName = rs.getString("NAME");
					String place = rs.getString("PLACE");
					String time = rs.getString("TIME");
					int id = rs.getInt("ID");
					
					PostData postData = new PostData(userName, place, time, id);
					postingList.add(postData);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
	
	return postingList;
	}
	
	public boolean responseAction(String resUser,int reqId) {
		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("JDBCドライバを読み込めませんでした");
				}
	    
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE POSTS SET IS_BUTTON = TRUE, RES_USER = ? WHERE ID = ?";
			
			try (PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setString(1, resUser);
				pStmt.setInt(2, reqId);
				
				// UPDATEを実行し、投稿内容をUPDATE
				int affectedRows = pStmt.executeUpdate();

				return affectedRows > 0; // 更新が成功したかどうかを返す
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
					}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
				}
	}
	
	public boolean isButton(String reqName) {
		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new IllegalStateException("JDBCドライバを読み込めませんでした");
				}
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT IS_BUTTON FROM POSTS WHERE NAME = ?";
			try (PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setString(1, reqName);
				
				try (ResultSet rs = pStmt.executeQuery()) {
					if (rs.next()) {
						// IS_BUTTON 列の値が "TRUE" または "FALSE" であるかを判定
						String isButtonValue = rs.getString("IS_BUTTON");
						return "TRUE".equalsIgnoreCase(isButtonValue);
						} else {
							// 対象の投稿が見つからない場合など
							return false;
							}
					}
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
					}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
		}
	}
	public String getResUserName(String reqName) {
		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new IllegalStateException("JDBCドライバを読み込めませんでした");
				}
		
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT RES_USER FROM POSTS WHERE NAME = ? AND IS_BUTTON = TRUE";
			try (PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setString(1, reqName);
				
				try (ResultSet rs = pStmt.executeQuery()) {
					if (rs.next()) {
						return rs.getString("RES_USER");
						}
					return rs.getString("RES_USER");
					}catch (SQLException e) {
						e.printStackTrace();
						return null;
						}	
				}catch (SQLException e) {
					e.printStackTrace();
					return null;
					}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return null;
	}
	public boolean reqCompleted(String reqName) {
		// JDBCドライバを読み込む
				try {
					Class.forName("org.h2.Driver");
					} catch (ClassNotFoundException e) {
						throw new IllegalStateException("JDBCドライバを読み込めませんでした");
						}
			    
				// データベースへ接続
				try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
					String sql = "DELETE FROM POSTS WHERE NAME = ? AND IS_BUTTON = TRUE";
					
					try (PreparedStatement pStmt = conn.prepareStatement(sql)) {
						pStmt.setString(1, reqName);
						
						// DELETE文を実行し、投稿内容をDELETE
						int affectedRows = pStmt.executeUpdate();

						return affectedRows > 0; // 更新が成功したかどうかを返す
						} catch (SQLException e) {
							e.printStackTrace();
							return false;
							}
					} catch (SQLException e) {
						e.printStackTrace();
						return false;
						}
	}
	
	public int getNowPoint(String resUser) {
		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new IllegalStateException("JDBCドライバを読み込めませんでした");
		}
				
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT POINT FROM USERS WHERE NAME = ?";
			try (PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setString(1, resUser);
				
				try (ResultSet rs = pStmt.executeQuery()) {
					if (rs.next()) {
						return rs.getInt("POINT");
					}
					return rs.getInt("POINT");
				}catch (SQLException e) {
						e.printStackTrace();
						return 0;
				}	
			}catch (SQLException e) {
					e.printStackTrace();
					return 0;
					}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public boolean giftPoint(int nowPoint,String resUser) {
		int newPoint = nowPoint+1;
		
		// JDBCドライバを読み込む
		try {
			Class.forName("org.h2.Driver");
			} catch (ClassNotFoundException e) {
				throw new IllegalStateException("JDBCドライバを読み込めませんでした");
				}
	    
		// データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "UPDATE USERS SET POINT = ? WHERE NAME = ?";
			
			try (PreparedStatement pStmt = conn.prepareStatement(sql)) {
				pStmt.setInt(1, newPoint);
				pStmt.setString(2, resUser);
				
				// DELETE文を実行し、投稿内容をDELETE
				int affectedRows = pStmt.executeUpdate();

				return affectedRows > 0; // 更新が成功したかどうかを返す
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
					}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
				}
	}
}