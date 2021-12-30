package com.tr.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tr.log.AccountDAO;

@WebServlet("/UpdateAccountC")
public class UpdateAccountC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 내 정보 수정 페이지에서 작동 수행
		AccountDAO.updateAccount(request);
		AccountDAO.login(request);
		AccountDAO.logincheck(request);
		request.setAttribute("contentPage", "loginJSP/home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 내 정보 페이지에서 수정하기 버튼 누르면 이동
		AccountDAO.logincheck(request);
		request.setAttribute("contentPage", "loginJSP/updateMypage.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
