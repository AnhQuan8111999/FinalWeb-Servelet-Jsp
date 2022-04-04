package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.impl.UserDaoImpl;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/admin/user/add")
public class AddUserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/user/addUser.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String role = req.getParameter("role");
		String image = req.getParameter("image");

		// System.out.println(name + username+ pass+gender+address+role);
		User user = new User();
		user.setAge(Integer.parseInt(age));
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setRole(role);
		user.setImage(image);

		// goi lop service de luu xuong database
		UserDao userDao = new UserDaoImpl();
		userDao.add(user);
		// chuyen trang
		resp.sendRedirect("/finalweb10/admin/user/search");

	}
}