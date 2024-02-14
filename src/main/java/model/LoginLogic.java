package model;

import dao.UsersDAO;

public class LoginLogic {
  public boolean execute(User user) {
	UsersDAO dao = new UsersDAO();
	String pass = dao.findLoginData(user.getName());
    if (user.getPass().equals(pass)) { return true; }
    return false;
  }
}