package model;

import dao.PostsDAO;

public class UserResponseLogic {
	
	public void pushResButton(String resUser,int reqId) {
		PostsDAO dao = new PostsDAO();
		dao.responseAction(resUser,reqId);
	}
	
	public void requestCompleted(int reqId) {
		PostsDAO dao = new PostsDAO();
		dao.isButton(50);
	}

}
