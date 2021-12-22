package com.tr.account;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tr.log.AccountDAO;

@WebServlet("/RegAccountC")
public class RegAccountC extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ȸ������ ���������� '�����ϱ� ��ư' �����ϴ� ��
		AccountDAO.reg(request);
		AccountDAO.logincheck(request);
		request.setAttribute("contentPage", "jsp/signupOK.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
