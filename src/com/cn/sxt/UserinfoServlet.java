package com.cn.sxt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserinfoServlet extends HttpServlet {

	/**
	 * 查询用户信息
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List list = DBUtil.selectList("select * from userinfo");
		//将从数据库里面查询出来的数据转发到userinfo.jsp页面
		request.setAttribute("list", list);
		request.getRequestDispatcher("/userinfo.jsp").forward(request, response);
	}

}
