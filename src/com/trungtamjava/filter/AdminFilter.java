package com.trungtamjava.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trungtamjava.model.User;

@WebFilter(urlPatterns = { "/admin/*" })
public class AdminFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// Doc Session
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
		HttpSession session = req.getSession();
		System.out.println("session id : " + session.getId());
		
		Object obj = session.getAttribute("loginUser");
		if (obj != null) {
			User user = (User) obj; // ep kieu
			System.out.println(user.getUsername());
			if (user.getRole().equals("ROLE_ADMIN")) {
				// cho di tiep
				arg2.doFilter(arg0, arg1);
			} else {
				// chuyen huong ve trang access deny
				resp.sendRedirect(req.getContextPath() + "/access-deny");
			}
		} else {
			// khong con login , het thoi gian
			// session cu bi xoa, mat du lieu cu
			resp.sendRedirect(req.getContextPath() + "/login-admin");
			return;
		}

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
