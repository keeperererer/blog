package com.cn.sxt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateUserServlet extends HttpServlet {

	/**
	 * 更新用户
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1. 接受参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String userid = request.getParameter("userid");
		
		
		
		//2. 处理请求
		int num = DBUtil.update("update userinfo set username=?,password=?,email=? where userid=?",
				new Object[]{username,password,email,userid});
		//3. 重定向到页面
		response.sendRedirect("userinfo.do");
	}

}
