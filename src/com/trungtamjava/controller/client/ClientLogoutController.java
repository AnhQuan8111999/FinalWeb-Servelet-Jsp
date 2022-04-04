package com.trungtamjava.controller.client;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.impl.UserDaoImpl;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/client/logout")
public class ClientLogoutController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		Object obj = session.getAttribute("loginUser");
		if (obj != null) {
			System.out.println("destroy");
			User user = (User) obj;
			UserDao userDao = new UserDaoImpl();
			userDao.updateLoginCounter(user.getId(), user.getLoginCounter() - 1);//giam so luong login xuong
		}
		
		// cach 1 : Xoa doi tuong session
		session.invalidate();// xoa session
		// cach 2 : Xoa key trong doi tuong session
		// session.removeAttribute("loginUsername");
		resp.sendRedirect(req.getContextPath() + "/client/product/search");

	}
}