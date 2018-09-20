<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>编辑用户信息</title>
  </head>
  
  <body>
   <center>
  <table style="margin-top:30px;">
     <form action="updateUser.do">
    	<tr>
    	<td>用户名：</td>
    	<td><input name="username" value="${param.username}"/></td>
        </tr>
        <tr>
    	 <td>密码：</td>
    	 <td><input name="password" value="${param.password}"/></td>  
    	</tr>
    	<tr>
    	<td>电子邮箱：</td>
    	<td><input name="email" value="${param.email}"/></td>
    	</tr>
    	<tr>
    	 <td>用户id：</td>
    	 <td><input readonly="readonly" name="userid" value="${param.userid}"/></td>
    	</tr>
    	<tr>
    	<td></td>
    	<td><button>提交编辑</button></td>
    	</tr>
    </form>
    </table>
    </center>

  </body>
</html>
