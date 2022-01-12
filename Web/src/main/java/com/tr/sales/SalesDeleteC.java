package com.tr.sales;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tr.log.AccountDAO;


@WebServlet("/SalesDeleteC")
public class SalesDeleteC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.logincheck(request);
		SalesDAO.getSdao().sales_delete(request);
		SalesDAO.getSdao().sales_select_all(request);
		//페이징 때문에 에러나서 주석함
		//SalesDAO.getSdao().paging(1, request);
		request.setAttribute("contentPage", "salesJSP/sale.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
