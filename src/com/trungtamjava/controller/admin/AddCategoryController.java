package com.trungtamjava.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.impl.CategoryDaoImpl;
import com.trungtamjava.model.Category;

@WebServlet(urlPatterns = "/admin/category/add")
public class AddCategoryController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/views/admin/category/addCategory.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// doc du lieu tu form gui len
		String name = req.getParameter("name");

		Category category = new Category();
		category.setName(name);

		CategoryDao cdao = new CategoryDaoImpl();
		cdao.add(category);
		resp.sendRedirect(req.getContextPath() +"/admin/category/search");
	}

}
