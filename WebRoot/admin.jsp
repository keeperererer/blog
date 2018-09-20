<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>后台管理页面</title>
  <link rel="stylesheet" type="text/css" href="css/admin.css">
</head>
<body>
  <h2>后台管理系统</h2>
  <a href="index.html" style="font:20px 幼圆">首页</a>
  <ul>
  <li><a href="userinfo.do" target="ifrm" class="a1">查看用户列表</a></li>
  <li><a href="addNews.jsp" target="ifrm" class="a2">发布新闻</a></li>
  </ul>
    <iframe name="ifrm" src="userinfo.do"></iframe>
  </body>
</html>