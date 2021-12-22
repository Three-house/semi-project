package com.tr.log;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginC")
public class LoginC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.loginOut(request);
		AccountDAO.logincheck(request);
		request.setAttribute("contentPage", "jsp/home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.login(request);
		AccountDAO.logincheck(request);
		request.setAttribute("contentPage", "jsp/home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
