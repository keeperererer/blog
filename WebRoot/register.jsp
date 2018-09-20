<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	   <title>用户注册</title>
	   <meta http-equiv="content-type" content="text/html; charset=UTF-8">
	   <link rel="stylesheet" type="text/css" href="css/register.css">
</head>
<body>
     <div id="all_content">
                <div class="left">
   	  	  	       <h2>用户注册</h2>
                      <form  method="get" action="register.do" id="zc" onsubmit="return check();">
                       <div class="row_input">
   	  	  	               <div class="name">姓名</div>
                           <div class="div_input">
                              <input type="text" id="username" name="username" style="border: 1px outset;border-radius: 5px; " onblur="check_name()" />
                           </div>
                           <span id="name_tip" style="color:red;">*(请输入6~11位字母或数字)</span>
                       </div>
                       <div class="row_input">
   	  	  	               <div class="name">电子邮箱</div>
   	  	  	               <div class="div_input">
   	  	  	                  <input type="text" id="email" name="email" style="border: 1px outset;border-radius: 5px;" onblur="check_email()" />
   	  	  	               </div>
   	  	  	               <span id="email_tip" style="color:red;"></span>
   	  	  	            </div>
                        <div class="row_input">
   	  	  	               <div class="name">密码</div>
   	  	  	               <div class="div_input">
   	  	  	                  <input type="password" id="psw" name="psw" style="border: 1px outset;border-radius: 5px;" onblur="check_psw()" />
   	  	  	               </div>
   	  	  	               <span id="psw_tip" style="color:red;">*(请输入6~11位字母或数字)</span>
                        </div>
                        <div class="row_input">  	  	  	               
   	  	  	               <div class="name">确认密码</div>
   	  	  	               <div class="div_input">
                              <input type="password" id="psw2" name="psw2" style="border: 1px outset;border-radius: 5px;" onblur="check_psw1()" />
   	  	  	               </div>
   	  	  	               <span id="psw2_tip" style="color:red;"></span>
   	  	  	            </div>
                        <div class="div_button">
   	  	  	                   <input type="submit" name="sub" value="注册" style="margin-right:20px;width: 50px;"/>
   	  	  	                   <input type="reset" name="res" value="重置" style=" width: 50px;"/>
   	  	  	            </div>
                      </form>
   	  	  	    </div>
   	  	  	    <!-- el表达式 -->   
                 	<div><%=request.getAttribute("msg") %></div>
   	 </div>
 <script type="text/javascript" src="js/jquery.min.js"></script>
 <script type="text/javascript" src="js/test.js"></script>
</body>
</html>