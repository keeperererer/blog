package com.cn.sxt;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*url  /login.do */
public class LoginServlet extends HttpServlet{
	/*  alt + /  */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. 获取请求参数
		/*
		 * 在tomcat的conf文件夹下server.xml配置文件第52行
		 * 加上  URIEncoding="utf-8"  
		 * 可以解决get方式提交的中文乱码处理
		 * */
		String username = request.getParameter("username");
		String password = request.getParameter("psw");
		// 2. 处理请求
//		if(!imageCode.equals(code.toLowerCase())){//如果验证码不正确的时候
//			//在request对象中添加错误信息
//			request.setAttribute("msg", "验证码不正确");
//			//将错误信息转发回登陆页面    转发  可以将request对象中的值转发到另外一个页面进行处理
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
//		}else 
		if(username == null || username == ""){
			//在request对象中添加错误信息
			request.setAttribute("msg", "您的用户名为空");
			//将错误信息转发回登陆页面    转发  可以将request对象中的值转发到另外一个页面进行处理
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if( !username.matches("^[a-zA-Z0-9]{6,11}$") ){//正则表达式匹配用户名  如果不能匹配的时候
			//在request对象中添加错误信息
			request.setAttribute("msg", "用户名必须是6-11位的数字字母");
			//将错误信息转发回登陆页面    转发  可以将request对象中的值转发到另外一个页面进行处理
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if( password == null || password == "" ){//正则表达式匹配用户名  如果不能匹配的时候
			//在request对象中添加错误信息
			request.setAttribute("msg", "您的密码为空");  
			//将错误信息转发回登陆页面    转发  可以将request对象中的值转发到另外一个页面进行处理
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if( !password.matches("^[a-zA-Z0-9]{6,11}$") ){//正则表达式匹配用户名  如果不能匹配的时候
			//在request对象中添加错误信息
			request.setAttribute("msg", "密码必须是6-11位的数字字母");
			//将错误信息转发回登陆页面    转发  可以将request对象中的值转发到另外一个页面进行处理
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{//当非空验证和正则表达式都能符合要求的时候，要判断用户名密码是否真的能够登陆
			boolean flag = DBUtil.selectExist("select * from userinfo where username=? and password=?", 
					new Object[]{username,password}) ;
			
			if(  flag  ){
				//获取session对象
				HttpSession session = request.getSession();
				//将用户名设置到 session对象中
				session.setAttribute("username", username);
				//登陆成功  重定向到首页
				response.sendRedirect("index.html");
			}else{
				//在request对象中添加错误信息
				request.setAttribute("msg", "用户名或密码错误");
				//将错误信息转发回登陆页面    转发  可以将request对象中的值转发到另外一个页面进行处理
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		}
		
		// 3. 响应请求
	}

}
