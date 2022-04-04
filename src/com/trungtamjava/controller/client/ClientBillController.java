package com.trungtamjava.controller.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.impl.BillDaoImpl;
import com.trungtamjava.model.Bill;
import com.trungtamjava.model.User;

@WebServlet(urlPatterns = "/member/bills")
public class ClientBillController extends HttpServlet {
	BillDao billDao = new BillDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		// lay dang nhap
		User buyer = (User) session.getAttribute("loginUser");
		
		///tim don hang cua user dang dang nhap
		
		List<Bill> bills = billDao.search(buyer.getId());
		
		req.setAttribute("bills", bills);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/client/bill/bill-list.jsp");
		dispatcher.forward(req, resp);
	}
}
