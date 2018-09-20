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
		//request�������Ҫ����
		//1. ��ȡ�����еĲ���
		String username = request.getParameter("username");//��ȡ����Ĳ�����ֵ
		System.out.println( "username   :   "  +  username  );
		//2. ���úͻ�ȡ  request�����е�����
		request.setAttribute("msg", "123");
		String msg = (String)request.getAttribute("msg");
		System.out.println( "msg   :   "  +  msg  );
		//3. ת��,���Խ�����request �� ��Ӧ��Ϊ�������ݸ�  ת����ҳ��login.jsp
//		request.getRequestDispatcher("/login.jsp").forward(request, response);
//		//4. �ض���  ����request���������ֱ����ת��ĳ��ҳ��
//		response.sendRedirect("index.jsp");
		
		//session����   ������һ����������û���һ��ʱ���ڹ�������
		
		HttpSession  session = request.getSession();
		session.setAttribute("username", username);
		
		response.sendRedirect("index.jsp");
		
	}

}
