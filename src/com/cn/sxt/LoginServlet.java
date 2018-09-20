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
		// 1. ��ȡ�������
		/*
		 * ��tomcat��conf�ļ�����server.xml�����ļ���52��
		 * ����  URIEncoding="utf-8"  
		 * ���Խ��get��ʽ�ύ���������봦��
		 * */
		String username = request.getParameter("username");
		String password = request.getParameter("psw");
		// 2. ��������
//		if(!imageCode.equals(code.toLowerCase())){//�����֤�벻��ȷ��ʱ��
//			//��request��������Ӵ�����Ϣ
//			request.setAttribute("msg", "��֤�벻��ȷ");
//			//��������Ϣת���ص�½ҳ��    ת��  ���Խ�request�����е�ֵת��������һ��ҳ����д���
//			request.getRequestDispatcher("/login.jsp").forward(request, response);
//		}else 
		if(username == null || username == ""){
			//��request��������Ӵ�����Ϣ
			request.setAttribute("msg", "�����û���Ϊ��");
			//��������Ϣת���ص�½ҳ��    ת��  ���Խ�request�����е�ֵת��������һ��ҳ����д���
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if( !username.matches("^[a-zA-Z0-9]{6,11}$") ){//������ʽƥ���û���  �������ƥ���ʱ��
			//��request��������Ӵ�����Ϣ
			request.setAttribute("msg", "�û���������6-11λ��������ĸ");
			//��������Ϣת���ص�½ҳ��    ת��  ���Խ�request�����е�ֵת��������һ��ҳ����д���
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if( password == null || password == "" ){//������ʽƥ���û���  �������ƥ���ʱ��
			//��request��������Ӵ�����Ϣ
			request.setAttribute("msg", "��������Ϊ��");  
			//��������Ϣת���ص�½ҳ��    ת��  ���Խ�request�����е�ֵת��������һ��ҳ����д���
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if( !password.matches("^[a-zA-Z0-9]{6,11}$") ){//������ʽƥ���û���  �������ƥ���ʱ��
			//��request��������Ӵ�����Ϣ
			request.setAttribute("msg", "���������6-11λ��������ĸ");
			//��������Ϣת���ص�½ҳ��    ת��  ���Խ�request�����е�ֵת��������һ��ҳ����д���
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{//���ǿ���֤��������ʽ���ܷ���Ҫ���ʱ��Ҫ�ж��û��������Ƿ�����ܹ���½
			boolean flag = DBUtil.selectExist("select * from userinfo where username=? and password=?", 
					new Object[]{username,password}) ;
			
			if(  flag  ){
				//��ȡsession����
				HttpSession session = request.getSession();
				//���û������õ� session������
				session.setAttribute("username", username);
				//��½�ɹ�  �ض�����ҳ
				response.sendRedirect("index.html");
			}else{
				//��request��������Ӵ�����Ϣ
				request.setAttribute("msg", "�û������������");
				//��������Ϣת���ص�½ҳ��    ת��  ���Խ�request�����е�ֵת��������һ��ҳ����д���
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			
		}
		
		// 3. ��Ӧ����
	}

}
