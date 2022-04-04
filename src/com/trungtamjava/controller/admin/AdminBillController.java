package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.impl.BillDaoImpl;
import com.trungtamjava.model.Bill;

@WebServlet(urlPatterns = "/admin/bills")
public class AdminBillController extends HttpServlet {
	BillDao billDao = new BillDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Bill> bills = billDao.getAll();

		req.setAttribute("bills", bills);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/bill/bill-list.jsp");
		dispatcher.forward(req, resp);
	}
}
