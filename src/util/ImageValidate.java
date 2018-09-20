package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 生成图片验证�?
 * 并将验证码的字符�?作为字符串rand存到session�?
 * @author admin
 *
 */
public class ImageValidate extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//清除网页缓存
		response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        response.setContentType("image/jpeg");  
          
        //生成随机字串  
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);  
        //存入会话session  
        HttpSession session = request.getSession(true);
        //把生成的验证码的字符串存到session�?
        session.setAttribute("imageCode", verifyCode.toLowerCase());  
        System.out.println("imageCode�?"+verifyCode.toLowerCase());
        //生成图片  
        int w = 200, h = 80;  
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);  
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
