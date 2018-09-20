<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>ueditor.html</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <!--<link rel="stylesheet" type="text/css" href="./styles.css">-->
	<script type="text/javascript" charset="utf-8" src="ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" charset="utf-8" src="ueditor/ueditor.parse.js"></script>
    <script type="text/javascript" src="js/jquery.min.js"></script>
  </head>
  
  <body>
    <!-- 导入编辑器 -->
          标题：<input id="title"/>  <br/>
     选择发布板块：<select id="type">
           		<option value="1">人工智能</option>
           		<option value="2">云计算</option>
           		<option value="3">区块链</option>
           		<option value="4">数据库</option>
           		<option value="5">程序人生</option>
           		<option value="6">游戏人生</option>
           		<option value="7">研发管理</option>
           		<option value="8">前端</option>
           		<option value="9">移动开发</option>
           		<option value="10">物联网</option>
           		<option value="11">编程语言</option>
           		<option value="12">计算机基础</option>
           		
           </select>  <br/>
          正文：
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
    
    <button id="btn">提交编辑</button>
    
    <script type="text/javascript">
    	//加载编辑器
    	var ue = UE.getEditor('editor',{});
    	//提交新闻
    	$("#btn").click(function(){
    		
    		var title = $("#title").val();//获取标题
    	
    		var content = ue.getContent();//获取内容
    		var type = $("#type").val();
    		//addNews.do?title=新闻1&content=正文1
			location.href="addNews.do?title="+title+"&content="+content+"&type="+type;    		
    		//alert(  ue.getContent()  );
    		//location.href = "show.jsp?str="+ue.getContent();
    	});
    </script>
  </body>
</html>
