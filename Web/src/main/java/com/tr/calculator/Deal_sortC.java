package com.tr.calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tr.log.AccountDAO;


@WebServlet("/Deal_sortC")
public class Deal_sortC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	AccountDAO.logincheck(request);	
	request.setAttribute("contentPage", "calculatorJSP/calculator.jsp");
	
	if (request.getParameter("deal_sort").equals("매매")) {
	request.setAttribute("dealSortPage", "trade.jsp");	
	}else if(request.getParameter("deal_sort").equals("전세")) {
	request.setAttribute("dealSortPage", "jeonse.jsp");	
	}else if(request.getParameter("deal_sort").equals("월세")) {
	request.setAttribute("dealSortPage", "monthly.jsp");	
	}
	request.setAttribute("deal_sort", request.getParameter("deal_sort"));
	request.getRequestDispatcher("index.jsp").forward(request, response);
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
