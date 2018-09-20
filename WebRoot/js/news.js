$(function(){
	var num = 1;//用于记录当前正在展示的是哪个图片
	
	/*1.2.3.4的点击事件*/
	$("#banner_btn>ul>li").click(function(){
		
		window.clearInterval(t);//停止window.setInterval事件
		//  $(this)  是获取当前被点击的元素的jquery对象
		
		//text()  jquery 方法，获取元素内的文本信息  
		num = $(this).text();
		//淡出
		$("#banner_images > img").fadeOut(500);
		//window.setTimeout(  0.5秒后调用
		window.setTimeout(function(){
			$("#banner_images > img").attr("src","images/"+num+".jpg");
			
		}, 500);
		//fadeIn  0.5秒淡入
		$("#banner_images > img").fadeIn(500);
		//每隔5秒钟自动播放
		t = window.setInterval(lunbo, 5000);
	});
	$("#next").click(function()
			{
	         num = parseInt(num) + 1;
	         num = num > 4 ? 1 : num;
		     $("#banner_images > img").attr("src","images/"+num+".jpg");
});
	$("#post").click(function()
			{
	         num = parseInt(num) - 1;
	         num = num < 2 ? 4 : num;
		     $("#banner_images > img").attr("src","images/"+num+".jpg");
});
	//页面加载的时候调用自动轮播
	var t = window.setInterval(lunbo, 5000);
	
	function  lunbo(){
		num = parseInt(num) + 1;
		num = num > 4 ? 1 : num;
		$("#banner_images > img").fadeOut(500);
		window.setTimeout(function(){
			$("#banner_images > img").attr("src","images/"+num+".jpg");
			
		}, 500);
		$("#banner_images > img").fadeIn(500);
	}
	 
});