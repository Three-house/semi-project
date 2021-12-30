package com.tr.calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tr.log.AccountDAO;

@WebServlet("/CalculatorC")
public class CalculatorC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		AccountDAO.logincheck(request);
		if (request.getParameter("deal_sort").equals("매매")) {
			Calculator.calc_trade(request);
			}else if(request.getParameter("deal_sort").equals("전세")||request.getParameter("deal_sort").equals("월세")) {
				Calculator.calc_jm(request);
			}
		
	request.setAttribute("contentPage", "calculatorJSP/calc_result.jsp");
	request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
