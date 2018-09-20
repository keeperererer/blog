package com.cn.sxt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class deleteNewsServlet extends HttpServlet {

	/**
	 * É¾³ýÓÃ»§
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newsid = request.getParameter("newsid");
		DBUtil.delete("delete from news where newsid = ?" , new Object[]{newsid});
		response.sendRedirect("showNews.do");
	}

}
