package com.cn.sxt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showContentServlet extends HttpServlet {

	/**
	 * 展示文章内容
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newsid = request.getParameter("newsid");
		
		Map map = DBUtil.selectOne("select * from news where newsid = ?", new Object[]{newsid});
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("/content.jsp").forward(request, response);
	}

}
