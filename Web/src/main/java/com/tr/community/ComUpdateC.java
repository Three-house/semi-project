package com.tr.community;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tr.log.AccountDAO;


@WebServlet("/ComUpdateC")
public class ComUpdateC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		AccountDAO.logincheck(request);
		ComDAO.getCom(request);	
		request.setAttribute("contentPage", "communityJSP/com_update.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.logincheck(request);
		ComDAO.updateCom(request);
		ComDAO.getAllCom(request);
		
		request.setAttribute("contentPage", "communityJSP/community.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);


	}

}
