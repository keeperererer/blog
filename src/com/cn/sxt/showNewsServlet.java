package com.cn.sxt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class showNewsServlet extends HttpServlet {

	/**
	 * 展示新闻数据
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List list = DBUtil.selectList("select * from news order by time desc");
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/showNews.jsp").forward(request, response);
	}

}
