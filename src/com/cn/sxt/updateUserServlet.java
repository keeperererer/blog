package com.cn.sxt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updateUserServlet extends HttpServlet {

	/**
	 * �����û�
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1. ���ܲ���
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String userid = request.getParameter("userid");
		
		
		
		//2. ��������
		int num = DBUtil.update("update userinfo set username=?,password=?,email=? where userid=?",
				new Object[]{username,password,email,userid});
		//3. �ض���ҳ��
		response.sendRedirect("userinfo.do");
	}

}
