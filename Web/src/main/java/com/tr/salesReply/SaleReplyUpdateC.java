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

@WebServlet("/SaleReplyUpdateC")
public class SaleReplyUpdateC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.logincheck(request);
		
		ReplyDAO.updateReplies(request);
		ReplyDAO.getAllReplies(request);
						
		ComDAO.getCdao().getAllCom(request);
		SalesDAO.getSdao().paging(1, request);                                                                                                                                                        
						
		request.setAttribute("contentPage", "salesJSP/sale.jsp");
							
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
