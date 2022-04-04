package com.trungtamjava.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trungtamjava.dao.BillDao;
import com.trungtamjava.dao.BillProductDao;
import com.trungtamjava.dao.impl.BillDaoImpl;
import com.trungtamjava.dao.impl.BillProductDaoImpl;
import com.trungtamjava.model.BillProduct;

@WebServlet(urlPatterns = "/admin/bill/delete")
public class AdminBillDeleteController extends HttpServlet {
	BillProductDao billProductDao = new BillProductDaoImpl();
	BillDao billDao = new BillDaoImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String billId = req.getParameter("billid");

		/// xoa het cac mat hang billproduct truoc, sau do moi xoa bill
		List<BillProduct> billProducts = billProductDao.search(Integer.parseInt(billId));
		for (BillProduct billProduct : billProducts) {
			billProductDao.delete(billProduct.getId());
		}

		// sau do xoa bill
		billDao.delete(Integer.parseInt(billId));

		resp.sendRedirect(req.getContextPath() + "/admin/bills");
	}
}
