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

@WebServlet(urlPatterns = "/admin/category/update")
// ?id=1
public class UpdateCategoryController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");

		CategoryDao categoryDao = new CategoryDaoImpl();
		Category category = categoryDao.getId(Integer.parseInt(id));

		req.setAttribute("category", category);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/category/updateCategory.jsp");
		dispatcher.forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// doc du lieu tu form gui len
		String id = req.getParameter("id");
		String name = req.getParameter("name");

		// System.out.println(Integer.parseInt(age));

		Category category = new Category();
		category.setId(Integer.parseInt(id));
		category.setName(name);

		CategoryDao categorydao = new CategoryDaoImpl();
		categorydao.update(category);

		// / chuyen huong
		// server tra ve 1 duong dan url
		// client se goi sang duong dan moi
		resp.sendRedirect(req.getContextPath() + "/admin/category/search");
	}
}
