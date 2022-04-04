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

@WebServlet(urlPatterns = "/admin/category/search")
public class SearchCategoryController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doc len keyword
		String keyword = req.getParameter("keyword");
		
		//truong hop keyword = null (vi du lan dau vao trang search)
		if (keyword == null) {
			keyword = "";
		}
		
		// day qua view de sử dụng cho vào form search giữ lại giá trị cho các lần search sau cho phân trang
		req.setAttribute("keyword", keyword);

		int pageNo = 1;// mac dinh page dau tien
		
		//doc len so trang
		String pageNoStr = req.getParameter("pageNo");
		// neu co truyen len so trang
		if (pageNoStr != null) {
			pageNo = Integer.parseInt(pageNoStr);
		}
		
		//code phan trang
		CategoryDao categoryDao = new CategoryDaoImpl();

		/// PHAN TRANG
		// MAC DINH
		final int maxPerPage = 12;// FiX Cung
		
		// tinh tong so trang
		int total = categoryDao.count(keyword);
		int maxPage = (int) Math.ceil(total / (double) maxPerPage);
		int startFromRecord = (pageNo - 1) * maxPerPage;

		// day qua view de for
		req.setAttribute("maxPage", maxPage);

		List<Category> categoryList = categoryDao.search(keyword, startFromRecord, maxPerPage);//thay cac bien vao day
		req.setAttribute("categoryList", categoryList);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/category/searchCategory.jsp");
		dispatcher.forward(req, resp);
	}

	// CO THE GOI nguoc ve doGet de su dung lai code phan trang cho de
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
