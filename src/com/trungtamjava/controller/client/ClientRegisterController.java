package com.trungtamjava.controller.client;

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

@WebServlet(urlPatterns = "/client/register")
public class ClientRegisterController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/register.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc du lieu tu form gui len
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String gender = req.getParameter("gen");
		String age = req.getParameter("age");
		String username = req.getParameter("username");
		String image = req.getParameter("image");

		User user = new User();
		user.setUsername(username);
		user.setAge(Integer.parseInt(age));
		user.setPassword(password);
		user.setName(name);
		user.setGender(gender);
		user.setImage(image);
		user.setRole("ROLE_MEMBER");//fix cung mac dinh role member

		UserDao userDao = new UserDaoImpl();
		userDao.add(user);
		/// chuyen huongS
		// server tra ve 1 duong dan url
		// client se goi sang duong dan moi
		resp.sendRedirect("/finalweb10/login-member");
	}

}
