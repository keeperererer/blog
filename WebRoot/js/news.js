$(function(){
	var num = 1;//���ڼ�¼��ǰ����չʾ�����ĸ�ͼƬ
	
	/*1.2.3.4�ĵ���¼�*/
	$("#banner_btn>ul>li").click(function(){
		
		window.clearInterval(t);//ֹͣwindow.setInterval�¼�
		//  $(this)  �ǻ�ȡ��ǰ�������Ԫ�ص�jquery����
		
		//text()  jquery ��������ȡԪ���ڵ��ı���Ϣ  
		num = $(this).text();
		//����
		$("#banner_images > img").fadeOut(500);
		//window.setTimeout(  0.5������
		window.setTimeout(function(){
			$("#banner_images > img").attr("src","images/"+num+".jpg");
			
		}, 500);
		//fadeIn  0.5�뵭��
		$("#banner_images > img").fadeIn(500);
		//ÿ��5�����Զ�����
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
	//ҳ����ص�ʱ������Զ��ֲ�
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