package model;

import java.util.List;

import dao.PostsDAO;

public class UserRequestLogic {
	public boolean setPostData(PostData postData) {
		if(postData.getUserName().length()<1) {
			return false;
			}
		if(postData.getPlace().length()<1) {
			return false;
			}
		if(postData.getTime().length()<1) {
			return false;
			}
		PostsDAO dao = new PostsDAO();
		return dao.registerPostData(postData.getUserName(), postData.getPlace(),postData.getTime());
		
	  }
	
	public List<PostData> getPostData() {
		PostsDAO dao = new PostsDAO();
		return dao.displayPostData();
	}
}