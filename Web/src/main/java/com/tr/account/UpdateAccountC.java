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
		
		// �� ���� ���� ���������� �۵� ����
		AccountDAO.updateAccount(request);
		AccountDAO.login(request);
		AccountDAO.logincheck(request);
		request.setAttribute("contentPage", "loginJSP/home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// �� ���� ���������� �����ϱ� ��ư ������ �̵�
		AccountDAO.logincheck(request);
		request.setAttribute("contentPage", "loginJSP/updateMypage.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
