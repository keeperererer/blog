package com.cn.sxt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateNewsServlet extends HttpServlet {

	/**
	 * 更新news
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1. 接受参数
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String newsid = request.getParameter("newsid");
		
		
		
		//2. 处理请求
		int num = DBUtil.update("update news set title=?,content=? where newsid=?",
				new Object[]{title,content,newsid});
		//3. 重定向到页面
		response.sendRedirect("showNews.do");
	}

}
