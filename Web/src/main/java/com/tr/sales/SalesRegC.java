package com.tr.sales;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tr.log.AccountDAO;


@WebServlet("/SalesRegC")
public class SalesRegC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// sale.jsp에서 '매물내놓기 버튼' 누르면 동작
		AccountDAO.logincheck(request);
		request.setAttribute("contentPage", "salesJSP/sale_reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.logincheck(request);
		SalesDAO.sales_insert(request);
		SalesDAO.sales_select_all(request);
		request.setAttribute("contentPage", "salesJSP/sale.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
