package com.tr.community;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tr.log.AccountDAO;

@WebServlet("/ComRegC")
public class ComRegC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.logincheck(request);
		request.setAttribute("contentPage", "communityJSP/com_reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.logincheck(request);
		// insert
		ComDAO.regCom(request);
		// Á¶È¸
		ComDAO.getAllCom(request);
		
		request.setAttribute("contentPage", "communityJSP/community.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
