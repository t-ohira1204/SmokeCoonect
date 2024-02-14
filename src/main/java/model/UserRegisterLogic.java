package model;

import dao.UsersDAO;

public class UserRegisterLogic {
	  public boolean execute(User user) {
		  if(user.getName().length()<1) {
			  return false;
		  }
		  if(user.getPass().length()<1) {
			  return false;
		  }
		  UsersDAO dao = new UsersDAO();
			return dao.registerUserData(user.getName(), user.getPass());
			
	  }
}
