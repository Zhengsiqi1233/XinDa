package com.datangedu.cn.controller.pub;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.datangedu.cn.util.ImgCodeUtil;

@Controller
public class PubController {
	@RequestMapping("/redirect")
	public String page(HttpServletRequest request) {
		String url = request.getParameter("page");
		System.out.println(url);
		return url;
	}
	
	@RequestMapping("/imgGetCode")
	public void imgGetCode(HttpServletRequest req, HttpServletResponse resp) {
		// 调用工具类生成的验证码和验证码图片
        Map<String, Object> codeMap = ImgCodeUtil.generateCodeAndPic();

        // 将四位数字的验证码保存到Session中。
        HttpSession session = req.getSession();
        session.setAttribute("code", codeMap.get("code").toString());

        // 禁止图像缓存。
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("Cache-Control", "no	-cache");
        resp.setDateHeader("Expires", -1);

        resp.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        ServletOutputStream sos;
        try {
            sos = resp.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos); 
            sos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
		
	
}
