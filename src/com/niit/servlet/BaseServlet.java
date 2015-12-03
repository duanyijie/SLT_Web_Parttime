package com.niit.servlet;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseServlet extends HttpServlet {
	private static final ResourceBundle BUNDLE = ResourceBundle
			.getBundle("connection");
	public int pageSize = 10;

	public BaseServlet() {
		super();
		pageSize = Integer.parseInt(BUNDLE.getString("PAGESIZE"));

	}

	public void Dispatcher(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
