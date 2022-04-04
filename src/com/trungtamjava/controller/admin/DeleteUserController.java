package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.UserDao;
import com.trungtamjava.dao.impl.UserDaoImpl;

@WebServlet(urlPatterns = "/admin/user/delete") // ?uid=1
public class DeleteUserController extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("uid");
		UserDao userDao = new UserDaoImpl();
		userDao.delete(Integer.parseInt(id));
		resp.sendRedirect(req.getContextPath() + "/admin/user/search");
	}

}