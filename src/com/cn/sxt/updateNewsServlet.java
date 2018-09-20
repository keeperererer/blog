package com.cn.sxt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateNewsServlet extends HttpServlet {

	/**
	 * ����news
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1. ���ܲ���
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String newsid = request.getParameter("newsid");
		
		
		
		//2. ��������
		int num = DBUtil.update("update news set title=?,content=? where newsid=?",
				new Object[]{title,content,newsid});
		//3. �ض���ҳ��
		response.sendRedirect("showNews.do");
	}

}
