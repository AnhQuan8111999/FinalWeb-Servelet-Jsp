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

@WebServlet(name = "/admin/user/update")
public class UpdateUserController extends HttpServlet {

	UserDao userDao = new UserDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uid = req.getParameter("uid");

		User user = userDao.get(Integer.parseInt(uid));
		req.setAttribute("user", user);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/admin/user/updateUser.jsp");
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String gender = req.getParameter("gender");
		String role = req.getParameter("role");
		String image = req.getParameter("image");

		// System.out.println(name + username+ pass+gender+address+role);
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setAge(Integer.parseInt(age));
		user.setName(name);
		user.setUsername(username);
		user.setPassword(password);
		user.setGender(gender);
		user.setRole(role);
		user.setImage(image);

		userDao.update(user);

		resp.sendRedirect("/finalweb10/admin/user/search");
	}
}
