package com.tr.comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tr.community.ComDAO;
import com.tr.log.AccountDAO;

@WebServlet("/ReplyDeleteC")
public class ReplyDeleteC extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountDAO.logincheck(request);
		
		ReplyDAO.deleteReplies(request);
		ReplyDAO.getAllReplies(request);
		
		ComDAO.getCdao().getAllCom(request);
		
		request.setAttribute("contentPage", "communityJSP/community.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
