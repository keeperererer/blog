package com.cn.sxt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet {

	/**
	 * ע��
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//1. ��ȡ�������
		String username = request.getParameter("username");
		String password = request.getParameter("psw");
		String email = request.getParameter("email");
		
		//2. ��������
		if(username == null || username == "" || password == null || password == "" ||
			email == null || email == ""){
			request.setAttribute("msg",	 "�����������Ϊ��");
			//�����ݣ�������Ϣת����ע��ҳ��
			request.getRequestDispatcher("/register.jsp").forward(request, response);
			
		}
		else
		    {//��������������Ҫ�󣬾������ݿ�������
			//���num == 1  ˵��������ɹ�
			int num = DBUtil.insert("insert into userinfo(username,password,email) values(?,?,?)",
					new Object[]{username,password,email});
			if(num == 1){//�������ݿ�ɹ�
				//��session �����д��һ���û�������  �����ݿ�����ͬһ��������е��κ�ҳ��30�����ڹ���
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				//�ض�����ҳ  ��ת����ҳ
				response.sendRedirect("index.html");
				
			}else{//�������ݿ�ʧ��
				request.setAttribute("msg",	 "ע��ʧ��");
				//�����ݣ�������Ϣת����ע��ҳ��
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}
	}

}
