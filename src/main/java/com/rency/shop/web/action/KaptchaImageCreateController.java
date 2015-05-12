package com.rency.shop.web.action;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Producer;
import com.rency.shop.web.tools.Const;

@Controller
@RequestMapping("/")
public class KaptchaImageCreateController {
	
	private static final Logger logger = LoggerFactory.getLogger(KaptchaImageCreateController.class);

	@Autowired
	@Qualifier("kaptchaProducer")
	private Producer kaptchaProducer = null;
	
	/**
	 * 创建验证码图片
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/captcha-image.htm")
	public ModelAndView creater(HttpServletRequest request,HttpServletResponse response) throws Exception{
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String kapTxt = kaptchaProducer.createText();
        logger.debug("create kaptcha image."+kapTxt);
        request.getSession().setAttribute(Const.SESSION_KAPTCHA_KEY, kapTxt);
        BufferedImage bi = kaptchaProducer.createImage(kapTxt);
        ServletOutputStream sos = response.getOutputStream();
        ImageIO.write(bi, "jpg", sos);
        try {
        	sos.flush();
		} finally {
			sos.close();
		}
        return null;
	}
	
	/**
	 * 校验验证码是否正确
	 * @param request
	 * @param randCode
	 * @return
	 * @throws Exception
	 */
	public static boolean validateRandCode(HttpServletRequest request,String randCode)throws Exception {
		logger.info("kaptcha validate:" + request.getSession().getAttribute(Const.SESSION_KAPTCHA_KEY));
		if (randCode == null || !randCode.equals(request.getSession().getAttribute(Const.SESSION_KAPTCHA_KEY))) {
			return false;
		}
		return true;
	}
	
}
