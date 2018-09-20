package com.cn.sxt;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addNewsServlet extends HttpServlet {

	/**
	 * 添加新闻
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取参数
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String type = request.getParameter("type");
		
		
		DBUtil.insert("insert into news(title,content,time,type) values(?,?,?,?)", new Object[]{title,content,new Date(),type});
	
		response.sendRedirect("showNews.do");
	}

}