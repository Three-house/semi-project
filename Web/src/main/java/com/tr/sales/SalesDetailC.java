package com.tr.sales;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tr.log.AccountDAO;
import com.tr.salesReply.SaleReplyDAO;

@WebServlet("/SalesDetailC")
public class SalesDetailC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccountDAO.logincheck(request);
		SalesDAO.getSdao().sales_select_one(request);
		
		SaleReplyDAO.getAllSaleReply(request);
		
		request.setAttribute("contentPage", "salesJSP/sale_detail.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
