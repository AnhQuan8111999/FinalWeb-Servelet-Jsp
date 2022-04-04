package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.CategoryDao;
import com.trungtamjava.dao.impl.CategoryDaoImpl;
import com.trungtamjava.model.Category;

@WebServlet(urlPatterns = "/admin/category/search-no-paging")
public class SearchCategoryNoPagingController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doc len keyword
		String keyword = req.getParameter("keyword");
		
		//truong hop keyword = null (vi du lan dau vao trang search)
		if (keyword == null) {
			keyword = "";
		}
		
		//code phan trang
		CategoryDao categoryDao = new CategoryDaoImpl();

		List<Category> categoryList = categoryDao.search(keyword);//thay cac bien vao day
		req.setAttribute("categoryList", categoryList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/category/searchCategoryNoPaging.jsp");
		dispatcher.forward(req, resp);
	}

	// CO THE GOI nguoc ve doGet de su dung lai code phan trang cho de
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
