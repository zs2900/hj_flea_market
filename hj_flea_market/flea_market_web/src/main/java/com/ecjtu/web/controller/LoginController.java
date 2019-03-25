/*
 * 文 件 名:  LoginController.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.validator.annotations.AOPLogAnnotation;
import com.ecjtu.web.controller.req.UserLoginReq;
import com.ecjtu.web.controller.req.UserLoginStateReq;
import com.ecjtu.web.controller.resp.UserLoginResp;
import com.ecjtu.web.controller.resp.UserLoginStateResp;
import com.ecjtu.web.service.UserService;
import com.google.code.kaptcha.impl.DefaultKaptcha;

/**
 * 登录控制
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@AOPLogAnnotation
@RestController
public class LoginController
{
    @Autowired
    private DefaultKaptcha defaultKaptcha;
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/verifycode", method = RequestMethod.GET)
    public void createImageCode(HttpServletRequest request, HttpServletResponse response)
        throws Exception
    {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try
        {
            // 生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            request.getSession().setAttribute("imageCode", createText);
            // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        }
        catch (IllegalArgumentException e)
        {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        
        // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        //返回图片
        ServletOutputStream responseOutputStream = response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserLoginResp userLogin(@RequestBody UserLoginReq req, HttpSession session)
        throws InnerException
    {
        return userService.userLogin(req, session);
    }
    
    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    public UserLoginStateResp userLoginState(@RequestBody UserLoginStateReq req, HttpSession session)
        throws InnerException
    {
        return userService.userLoginState(req, session);
    }
    
}
