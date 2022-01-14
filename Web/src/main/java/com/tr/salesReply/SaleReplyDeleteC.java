package com.tr.salesReply;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tr.comment.ReplyDAO;
import com.tr.community.ComDAO;
import com.tr.log.AccountDAO;
import com.tr.sales.SalesDAO;


@WebServlet("/SaleReplyDeleteC")
public class SaleReplyDeleteC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.logincheck(request);
		
		SaleReplyDAO.deleteSaleReply(request);
		SaleReplyDAO.getAllSaleReply(request);
		
		SalesDAO.getSdao().sales_select_all(request);
		
		request.setAttribute("contentPage", "salesJSP/sale.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
