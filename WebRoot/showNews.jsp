<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>展示新闻列表</title>

  </head>
  
  <body>
    <c:forEach items="${list}" var="news">
    
    	<div> 
    		标题： <a href="showContent.do?newsid=${news.newsid }">${news.title }</a> <br/>
    		发布时间：<fmt:formatDate value="${news.time }" pattern="yyyy-MM-dd HH:mm:ss"/>
    		<a href="editNews.jsp?title=${news.title}&content=${news.content}">修改</a>
    		<a href="deleteNews.do?newsid=${news.newsid}">删除</a>
    	 </div>
    
    </c:forEach>
  </body>
</html>