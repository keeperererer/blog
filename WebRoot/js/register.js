/*jQuery("选择器")
	jQuery("#username")  通过id选择器选中  id为username的元素
	val() 获取选中元素的值
	var 定义变量
	alert 弹框
*/
/*$("#username").blur 用户名框的失去焦点事件*/
$("#username").blur(function(){
	var name = jQuery("#username").val();
	/*
		^  正则表达式的开始符号
		$  表示结束符号
		\w 表示一个数字字母下划线
	*/
	//1-14位的数字字母或者下划线
	var reg =/^[a-zA-Z0-9]{6,11}$/;/*定义一个正则表达式*/
	// reg.test(name) 用正则表达式去判断一个字符串是否符合规则返回true和false
	if(  $("#username").val() == null ||  $("#username").val() == "" ){//如果用户名为空
		$("#ulbl").text("用户名不为空");
	}else{//如果用户名不为空  ，才进行正则表达式的判断
		if( reg.test(name) ){//如果正则表达式能通过匹配，就将错误显示出来
			$("#ulbl").text("用户名格式正确");
		}else{
			//alert("用户名不符合规则：需要1-14位的数字字母或者下划线");
		 
		 //text()  往选中的元素内写文字内容
		 	$("#ulbl").text("6~11位的数字字母或者下划线");
		}
	}
	//alert(name);
});

//密码框的失去焦点事件
$("#password").blur(function(){
		var pwd = $("#password").val();//获取密码框输入的值
		var reg = /^[\w!@#$^&]{6,18}$/;//密码6到18位
		if(pwd == null || pwd == ""){
			$("#plbl").text("密码不能为空");
		}else{//不为空的情况
			if( reg.test(pwd) ){//判断正则表达式是否能通过
				$("#plbl").text("*");
			}else{
				$("#plbl").text("密码必须为6-18位，不能是中文");
			}
			
		}
	
});

