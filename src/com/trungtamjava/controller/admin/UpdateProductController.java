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
import com.trungtamjava.dao.ProductDao;
import com.trungtamjava.dao.impl.CategoryDaoImpl;
import com.trungtamjava.dao.impl.ProductDaoImpl;
import com.trungtamjava.model.Category;
import com.trungtamjava.model.Product;

@WebServlet(urlPatterns = "/admin/product/update") // ?id=1
public class UpdateProductController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");

		ProductDao pDao = new ProductDaoImpl();
		Product p = pDao.getId(Integer.parseInt(id));
		req.setAttribute("product", p);

		CategoryDao categoryDao = new CategoryDaoImpl();
		List<Category> categoryList = categoryDao.search("");
		req.setAttribute("categoryList", categoryList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/product/updateProduct.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HELLO POST");
		// doc du lieu tu form gui len
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String description = req.getParameter("description");
		String categoryId = req.getParameter("categoryId");

		Product product = new Product();
		product.setId(Integer.parseInt(id));
		product.setName(name);
		product.setPrice(Integer.parseInt(price));
		product.setDescription(description);
		product.setImage(req.getParameter("image"));

		Category category = new Category();
		category.setId(Integer.parseInt(categoryId));

		product.setCategory(category);

		ProductDao pdao = new ProductDaoImpl();
		pdao.update(product);

		/// chuyen huong
		// server tra ve 1 duong dan url
		// client se goi sang duong dan moi
		resp.sendRedirect(req.getContextPath() + "/admin/product/search");
	}
}
