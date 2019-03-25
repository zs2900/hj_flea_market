/*
 * 文 件 名:  MailUtil.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月11日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.util;

import java.security.SecureRandom;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月11日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class MailUtil
{
    private static final String SYMBOLS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    private static final Random RANDOM = new SecureRandom();
    
    /**
     * 发送邮件
     * @param to 给谁发
     * @param text 发送内容
     */
    public static void send_mail(String to, String text)
        throws MessagingException
    {
        //创建连接对象 连接到邮件服务器
        Properties properties = new Properties();
        //设置发送邮件的基本参数
        //发送邮件服务器
        properties.put("mail.smtp.host", "smtp.qq.com");
        //发送端口
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.setProperty("mail.debug", "true");//true 打印信息到控制台
        properties.setProperty("mail.transport", "smtp");//发送的协议是简单的邮件传输协议
        properties.setProperty("mail.smtp.ssl.enable", "true");
        //设置发送邮件的账号和密码
        Session session = Session.getInstance(properties, new Authenticator()
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                //两个参数分别是发送邮件的账户和密码
                return new PasswordAuthentication("2335010451@qq.com", "smmgfyvamzxldhhj");
            }
        });
        
        //创建邮件对象
        Message message = new MimeMessage(session);
        //设置发件人
        message.setFrom(new InternetAddress("2335010451@qq.com"));
        //设置收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        //设置主题
        message.setSubject("注册验证码");
        //设置邮件正文  第二个参数是邮件发送的类型
        message.setContent(text, "text/html;charset=UTF-8");
        //发送一封邮件
        Transport.send(message);
    }
    
    /**
     * 获取4随机位字符串
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getRadomNum()
    {
        char[] nonceChars = new char[6];
        
        for (int index = 0; index < nonceChars.length; ++index)
        {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        
        return new String(nonceChars);
    }
}
