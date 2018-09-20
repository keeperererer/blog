<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<title>编辑用户信息</title>
  </head>
  
  <body>
   <center>
  <table style="margin-top:30px;">
     <form action="updateNews.do">
    	<tr>
    	<td>标题：</td>
    	<td><input name="title" value="${param.title}"/></td>
        </tr>
        <tr>
    	 <td>主体：</td>
    	 <td><input name="content" value="${param.content}"/></td>  
    	</tr>
    	
    	<tr>
    	 <td>新闻id：</td>
    	 <td><input readonly="readonly" name="newsid" value="${param.newsid}"/></td>
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
