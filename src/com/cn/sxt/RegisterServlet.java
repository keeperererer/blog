package com.cn.sxt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {

	/**
	 * 注册
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1. 获取请求参数
		String username = request.getParameter("username");
		String password = request.getParameter("psw");
		String email = request.getParameter("email");
		
		//2. 处理请求
		if(username == null || username == "" || password == null || password == "" ||
			email == null || email == ""){
			request.setAttribute("msg",	 "请求参数不能为空");
			//把数据，错误信息转发到注册页面
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			
		}
		else
		    {//如果请求参数符合要求，就做数据库插入操作
			//如果num == 1  说明插入出成功
			int num = DBUtil.insert("insert into userinfo(username,password,email) values(?,?,?)",
					new Object[]{username,password,email});
			if(num == 1){//插入数据库成功
				//往session 对象中存放一个用户名数据  该数据可以在同一个浏览器中的任何页面30分钟内共享
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				//重定向到首页  跳转到首页
				response.sendRedirect("index.html");
				
			}else{//插入数据库失败
				request.setAttribute("msg",	 "注册失败");
				//把数据，错误信息转发到注册页面
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}
	}

}
