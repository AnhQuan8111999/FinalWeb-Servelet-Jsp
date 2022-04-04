package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.impl.UserDaoImpl;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/admin/user/search")
public class SearchUserController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// mac dinh vao tim tat ca user de show ra
		UserDao userDao = new UserDaoImpl();
		List<User> userList = userDao.search("");
		req.setAttribute("users", userList);
		RequestDispatcher dispathcer = req.getRequestDispatcher("/views/admin/user/searchUser.jsp");
		dispathcer.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		UserDao userDao = new UserDaoImpl();
		List<User> userList = userDao.search(keyword);
		req.setAttribute("users", userList);

		// tra ve trang nhu doget
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/user/searchUser.jsp");
		dispatcher.forward(req, resp);
	}
}
