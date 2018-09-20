package com.cn.sxt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class TestServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request对象的重要方法
		//1. 获取请求中的参数
		String username = request.getParameter("username");//获取请求的参数的值
		System.out.println( "username   :   "  +  username  );
		//2. 设置和获取  request对象中的数据
		request.setAttribute("msg", "123");
		String msg = (String)request.getAttribute("msg");
		System.out.println( "msg   :   "  +  msg  );
		//3. 转发,可以将请求request 和 响应作为参数传递给  转发的页面login.jsp
//		request.getRequestDispatcher("/login.jsp").forward(request, response);
//		//4. 重定向  不带request对象参数，直接跳转到某个页面
//		response.sendRedirect("index.jsp");
		
		//session对象   可以让一个浏览器的用户在一定时间内共享数据
		
		HttpSession  session = request.getSession();
		session.setAttribute("username", username);
		
		response.sendRedirect("index.jsp");
		
	}

}
