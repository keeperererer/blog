<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>用户信息管理</title>
  <style>
     th,td
     {
       width:100px;
       text-align:center;
     }
  </style>
  </head>
  <body>
  	<!-- 请访问 这个页面对应的servlet    [图片]userinfo.do来查询数据，并且将数据转发到这个页面 -->
    <table>
    	<tr>
    		<th>用户名</th>
    		<th>密码</th>
    		<th>邮箱</th>
    		<th>修改用户</th>
    		<th>删除用户</th>
    	</tr>
    	
    	<!-- 使用jstl表达式获取循环遍历 request对象中的值 
    		items=""  需要循环遍历的元素，可以使用el表达式
    		var 变量名    可以将每一次遍历到的数据，赋值到该变量名中
    	-->
    	<c:forEach items="${list}" var="user">
    		
    		<tr>
    			<td>${user.username }</td>
    			<td>${user.password }</td>
    			<td>${user.email }</td>
    			<td><a href="editUser.jsp?username=${user.username}&password=${user.password}&email=${user.email}&userid=${user.userid}">修改</a></td>
    			<td><a href="deleteUser.do?userid=${user.userid}">删除</a></td>
    		</tr>
    		
    	</c:forEach>
    	
    </table>
    <!-- el表达式  可以取request和session中的值 -->
  </body>
</html>
