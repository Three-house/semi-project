package com.tr.salesReply;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tr.log.AccountDAO;
import com.tr.sales.SalesDAO;

@WebServlet("/SaleReplyRegC")
public class SaleReplyRegC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.logincheck(request);
		
		SaleReplyDAO.regSaleReply(request);
		SaleReplyDAO.getAllSaleReply(request);
		
		SalesDAO.sales_select_all(request);
		
		request.setAttribute("contentPage", "saleJSP/sale.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
