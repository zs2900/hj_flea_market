/*
 * 文 件 名:  UserServiceImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.common.enums.ResultCode;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.model.User;
import com.ecjtu.common.util.MD5Util;
import com.ecjtu.common.validator.Validator;
import com.ecjtu.web.controller.req.GetUserInfoReq;
import com.ecjtu.web.controller.req.UpdateHeadPicReq;
import com.ecjtu.web.controller.req.UpdateUserInfoReq;
import com.ecjtu.web.controller.req.UserLoginReq;
import com.ecjtu.web.controller.req.UserLoginStateReq;
import com.ecjtu.web.controller.resp.GetuserInfoResp;
import com.ecjtu.web.controller.resp.UpdateuserInfoResp;
import com.ecjtu.web.controller.resp.UserLoginResp;
import com.ecjtu.web.controller.resp.UserLoginStateResp;
import com.ecjtu.web.dao.UserMapper;
import com.ecjtu.web.service.UserService;
import com.ecjtu.web.util.TimeUtil;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class UserServiceImpl implements UserService
{
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    
    @Autowired
    private UserMapper userMapper;
    
    @Value("${user.head.image}")
    private String headPic;
    
    @Override
    public UserLoginResp userLogin(UserLoginReq req, HttpSession session)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(UserLoginReq.class, req);
        
        //校验图片验证码
        String kaptchaExpected = (String)session.getAttribute("imageCode");
        LOGGER.info("kaptchaExpected : {}", kaptchaExpected);
        if (!req.getUserImgCode().equals(kaptchaExpected))
        {
            UserLoginResp userLoginResp = new UserLoginResp();
            userLoginResp.setRetCode(ResultCode.IMAGE_CODE_FILED.getResultCode());
            userLoginResp.setRetMsg(ResultCode.IMAGE_CODE_FILED.getResultMsg());
            return userLoginResp;
        }
        
        //用户账号密码验证
        User user = userMapper.selectUbyEmail(req.getUserEmail());
        UserLoginResp userLoginResp = new UserLoginResp();
        if (user == null)
        {
            userLoginResp.setRetCode(ResultCode.LOGIN_FILED.getResultCode());
            userLoginResp.setRetMsg(ResultCode.LOGIN_FILED.getResultMsg());
        }
        else if (!MD5Util.getSaltverifyMD5(req.getUserPWD(), user.getuPassword()))
        {
            userLoginResp.setRetCode(ResultCode.LOGIN_FILED.getResultCode());
            userLoginResp.setRetMsg(ResultCode.LOGIN_FILED.getResultMsg());
        }
        else
        {
            userLoginResp.setuId(user.getuId());
            userLoginResp.setuName(user.getuName());
            session.setAttribute("userAccount", user);
        }
        return userLoginResp;
    }
    
    @Override
    public UserLoginStateResp userLoginState(UserLoginStateReq req, HttpSession session)
        throws InnerException
    {
        User user = (User)session.getAttribute("userAccount");
        UserLoginStateResp userLoginStateResp = null;
        if (user != null)
        {
            userLoginStateResp = new UserLoginStateResp();
            userLoginStateResp.setHeadPic(user.getuHeadPic() == null ? headPic : user.getuHeadPic());
            userLoginStateResp.setuName(user.getuName());
        }
        else
        {
            userLoginStateResp = new UserLoginStateResp();
            userLoginStateResp.setRetCode(ResultCode.USER_NOT_FIND.getResultCode());
            userLoginStateResp.setRetMsg(ResultCode.USER_NOT_FIND.getResultMsg());
        }
        return userLoginStateResp;
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @param session
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @Override
    public GetuserInfoResp getuserInfo(GetUserInfoReq req, HttpSession session)
        throws InnerException
    {
        //用户是否登录
        User user = (User)session.getAttribute("userAccount");
        if (user == null)
        {
            GetuserInfoResp resp = new GetuserInfoResp();
            resp.setRetCode(ResultCode.USER_NOT_FIND.getResultCode());
            resp.setRetMsg(ResultCode.USER_NOT_FIND.getResultMsg());
            return resp;
        }
        
        //查询用户信息
        User user2 = userMapper.selectUbyId(user.getuId());
        GetuserInfoResp resp = new GetuserInfoResp();
        resp.setUser(user2);
        
        return resp;
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @param session
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @Override
    public UpdateuserInfoResp updateUserinfo(UpdateUserInfoReq req, HttpSession session)
        throws InnerException
    {
        //验证用户登录
        User user = (User)session.getAttribute("userAccount");
        if (user == null)
        {
            UpdateuserInfoResp resp = new UpdateuserInfoResp();
            resp.setRetCode(ResultCode.USER_NOT_FIND.getResultCode());
            resp.setRetMsg(ResultCode.USER_NOT_FIND.getResultMsg());
            return resp;
        }
        
        //修改用户信息
        req.getUser().setuId(user.getuId());
        userMapper.updateUserInfo(req.getUser());
        UpdateuserInfoResp resp = new UpdateuserInfoResp();
        
        return resp;
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @param session
     * @return
     * @throws InnerException
     * @throws FileNotFoundException 
     * @see [类、类#方法、类#成员]
     */
    @Override
    public BaseResponse updateUserHeadPic(UpdateHeadPicReq req, HttpSession session)
        throws Exception
    {
        User user = (User)session.getAttribute("userAccount");
        if (user == null)
        {
            BaseResponse resp = new BaseResponse();
            resp.setRetCode(ResultCode.USER_NOT_FIND.getResultCode());
            resp.setRetMsg(ResultCode.USER_NOT_FIND.getResultMsg());
            return resp;
        }
        
        LOGGER.info("imageFile : {}", req.getImage());
        if ("data:image/png".equals(req.getImage().split(";")[0]))
        {
            // 去掉base64编码的头部 如："data:image/png;base64," 如果不去，转换的图片不可以查看  
            String imageFile = req.getImage().split(",")[1];
            LOGGER.info("imageFile : {}", imageFile);
            //解码  
            byte[] imgByte = Base64Utils.decodeFromString(imageFile);
            // 文件保存路径  
            String filePath = session.getServletContext().getRealPath("/") + "uploads/heads/"
                + TimeUtil.getCurrentDate() + File.separator;
            String fileName = user.getuEmail().hashCode() + ".png";
            // 转存文件  
            File file2 = new File(filePath);
            if (!file2.exists())
            {
                file2.mkdirs();
            }
            File file = new File(filePath + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(imgByte);
            fos.close();
            User user2 = new User();
            user2.setuId(user.getuId());
            user2.setuHeadPic(filePath.substring(filePath.lastIndexOf("uploads")) + fileName);
            userMapper.updateUserInfo(user2);
            return new BaseResponse();
        }
        else
        {
            BaseResponse resp = new BaseResponse();
            resp.setRetCode(ResultCode.FILE_TYPE_NOT_SUPPORT.getResultCode());
            resp.setRetMsg(ResultCode.FILE_TYPE_NOT_SUPPORT.getResultMsg());
            return resp;
        }
        
    }
    
}
