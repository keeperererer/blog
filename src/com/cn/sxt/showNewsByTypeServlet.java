package com.cn.sxt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showNewsByTypeServlet extends HttpServlet {

	/**
	 * 根据分类查找新闻数据
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String type = request.getParameter("type");
		
		List list = DBUtil.selectList("select * from news where type=? order by time desc", new Object[]{type});
	
		request.setAttribute("list", list);
		request.getRequestDispatcher("showNewsByType.jsp").forward(request, response);
	}

}