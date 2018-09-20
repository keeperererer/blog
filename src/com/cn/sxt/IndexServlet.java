package com.cn.sxt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {

	/**
	 * 获取首页需要的数据
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List list = DBUtil.selectList("select * from news");
		
		request.setAttribute("list", list);
		
		
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}


}
