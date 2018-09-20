<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>首页</title>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/news.js"></script>
    <link rel="stylesheet" type="text/css" href="css/first.css">
  </head>
  
  <body>
      <div id="header_top">
      	    <span>博客</span>
      	    <span style="float: right;"><a href="login.jsp">登录</a>/<a href="register.jsp">注册</a>&nbsp;<a href="admin_sign.html">后台管理</a></span>
      </div>
      <div id="all_content">
        <ul id="nav">
              <li><a href="index.html">首页</a>
              </li>
              <li><a href="https://blog.csdn.net/" class="a1">博客</a></li>
              <li><a href="https://edu.csdn.net/" class="a1">学院</a></li>
              <li><a href="https://download.csdn.net/" class="a1">下载</a></li>
              <li><a href="https://gitbook.cn/?ref=csdn" class="a1">GitChat</a></li>
              <li><a href="https://www.tinymind.cn/?utm_source=csdnbar" class="a1">TinyMind</a></li>
              <li><a href="https://bbs.csdn.net/" class="a1">论坛</a></li>
              <li><a href="https://ask.csdn.net/" class="a1">问答</a></li>
              <li class="write1"><a href="ueditor.html">写博客</a></li>
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
        <div id="middle">
             <div id="middle_le">
                        <h2>推荐</h2>
                       <ul>
                            <li><a href="showNewsByType.do?type=1">人工智能</a></li>
                            <li><a href="showNewsByType.do?type=2">云计算</a></li>
                            <li><a href="showNewsByType.do?type=3">区块链</a></li>
                            <li><a href="showNewsByType.do?type=4">数据库</a></li>
                            <li><a href="showNewsByType.do?type=5">程序人生</a></li>
                            <li><a href="showNewsByType.do?type=6">游戏人生</a></li>
                            <li><a href="showNewsByType.do?type=7">研发管理</a></li>
                            <li><a href="showNewsByType.do?type=8">前端</a></li>
                            <li><a href="showNewsByType.do?type=9">移动开发</a></li>
                            <li><a href="showNewsByType.do?type=10">物联网</a></li>
                            <li><a href="showNewsByType.do?type=11">编程语言</a></li>
                            <li><a href="showNewsByType.do?type=12">计算机基础</a></li>
                        </ul>
                   </div>
                    <div id="middle_mi">
                        <ul>
                            <li class="middle_li">
                               <div class="list_con">
                               <c:forEach items="${list}" var="news">
                                    <div class="title">
                                      <h2>
<a href="showContent.do?newsid=${news.newsid }">${news.title }</a> 
<span>发布时间：<fmt:formatDate value="${news.time }" pattern="yyyy-MM-dd HH:mm:ss"/></span>

</h2>
                                    </div>
                                    <div class="summary_online">
                                    <p>${news.content }</p>
                                    </div>
                                 </c:forEach>
                                 
                               </div>
                            </li>
                        </ul>
                    </div>
                     <div id="middle_ri">
                      <span>今日推荐</span>
                      <ul>
                        <li>
                          <img src="images/jin1.png" alt="">
                          <h3><a href="https://blog.csdn.net/blockchain_lemon/article/details/81008794">20行代码，带你了解未来颠覆性的工作模式</a></h3>
                          <span>在传统的上下级工作模式下，个人缺少展示自我的机会，劳动力效率低下，成长速度较慢、缺少完整的反馈机制，不利于个人和团体的协同发展。</span>
                        </li>
                        <li>
                          <img src="images/jin2.jpg" alt="">
                          <h3><a href="https://www.tinymind.cn/articles/1171">TensorFlow实现卷积自编码器对图像进行</a></h3>
                          <span>自编码器是一种执行数据压缩的网络架构，其中的压缩和解压缩功能是从数据本身学习得到的，</span>
                        </li>
                        <li>
                        	<img src="images/jin3.jpg" alt="">
                          <h3><a href="http://www.tinymind.cn/articles/719?from=home1">人工智能写诗大赛来了！！</a></h3>
                          <span>我不是天生诗人，但我有写词机啊</span>
                        </li>
                        <li>
                        <img src="images/jin4.jpg" alt="">
                          <h3><a href="[图片]https://blog.csdn.net/csdnnews/article/details/81009434">大龄程序员如何在科技公司生存？</a></h3>
                          <span></span>
                        </li>
                        <li>
                        <img src="images/jin5.jpg" alt="">
                          <h3><a href="https://blog.csdn.net/csdnsevenn/article/details/80971548">你们要的代码来了！爬了菊姐的两万条评论——详细代码解读篇</a></h3>
                          <span></span>
                        </li>
                        <li>
                        <img src="images/jin6.jpg" alt="">
                          <h3><a href="[图片]https://edu.csdn.net/huiyiCourse/series_detail/108?utm_source=home4">机器学习十二讲（核心算法各个击破）</a></h3>
                          <span></span>
                        </li>
                        <li>
                        <img src="images/jin7.jpg" alt="">
                          <h3><a href="https://bss.csdn.net/m/topic/mi_app">【干货】快应用开发体验与技术架构深度解析！</a></h3>
                          <span></span>
                        </li>
                        <li>
                        <img src="images/jin2.jpg" alt="">
                          <h3><a href="http://ibmuniversity.csdn.net/">人工智能、机器学习和认知计算入门指南</a></h3>
                          <span></span>
                        </li>
                      </ul>
                    </div>   
        </div>
         <footer>
           <ul>
             <li>版权所有:郭舒婷 周涛</li>
             <li>联系我们：计科1604 201650080401 201650080404</li>
           </ul> 
           
         </footer>
    </div>
</body>
</html>