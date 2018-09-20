package com.cn.sxt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deleteUserServlet extends HttpServlet {

	/**
	 * É¾³ýÓÃ»§
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userid = request.getParameter("userid");
		DBUtil.delete("delete from userinfo where userid = ?" , new Object[]{userid});
		response.sendRedirect("userinfo.do");
	}

}
