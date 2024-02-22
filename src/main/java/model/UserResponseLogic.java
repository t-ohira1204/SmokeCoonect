package model;

import dao.PostsDAO;

public class UserResponseLogic {
	
	public void pushResButton(String resUser,int reqId) {
		PostsDAO dao = new PostsDAO();
		dao.responseAction(resUser,reqId);
//		boolean Result = dao.isButton(reqId);
//		if(Result==true) {
//			System.out.println("ろじっくでとぅるー！");
//			return true;
//		}else {
//			System.out.println("ろじっくでふぉるす！");
//			return false;
//		}
	}
	
//	public void requestCompleted(int reqId) {
//		PostsDAO dao = new PostsDAO();
//		dao.isButton(reqId);
//	}
	public String getResUserName(String reqName) {
		PostsDAO dao = new PostsDAO();
		return dao.getResUserName(reqName);
	}
	

}
