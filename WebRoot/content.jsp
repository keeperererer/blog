<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>首页</title>
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/news.js"></script>
    <link rel="stylesheet" type="text/css" href="css/first.css">
  </head>
  
  <body>
      <div id="header_top">
      	    <span>博客</span>
      	    <span style="float: right;">
      </div>
      <div id="all_content">
        <ul id="nav">
              <li><a href="first.html">首页</a></li>
              <li><a href="#" class="a1">博客</a></li>
              <li><a href="#" class="a1">学院</a></li>
              <li><a href="#" class="a1">下载</a></li>
              <li><a href="#" class="a1">GitChat</a></li>
              <li><a href="#" class="a1">TinyMind</a></li>
              <li><a href="#" class="a1">论坛</a></li>
              <li><a href="#" class="a1">问答</a></li>
              <li class="write1"><a href="#">写博客</a></li>
              <li class="write2"><a href="#">发Chat</a></li>
        </ul>
        <div id="picture">
        <div id="banner_images">
              <img src="images/1.jpg">
            </div>
                  <div id="post"></div>
                  <div id="next"></div>
                  <div id="banner_btn">
                    <ul>
                      <li>1</li>
                      <li>2</li>
                      <li>3</li>
                      <li>4</li>
                    </ul>
             </div>
        </div>
        <div class="Ccontent">
              	标题：${map.title }
   				 <br/>
    			日期：${map.time }
   				 <br/>
  				正文：<br/>
 				 ${map.content }
        </div>
       </div>
         <footer>
           <ul>
             <li>版权所有:郭舒婷 周涛</li>
             <li>联系我们：计科1604 201650080401 201650080404</li>
           </ul> 
           
         </footer>
</body>
</html>