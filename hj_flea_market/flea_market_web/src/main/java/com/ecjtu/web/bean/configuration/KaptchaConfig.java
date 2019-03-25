/*
 * 文 件 名:  KaptchaConfig.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.bean.configuration;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

/**
 * Kaptcha配置
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Component
public class KaptchaConfig
{
    @Bean
    public DefaultKaptcha getDefaultKaptcha()
    {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 图片宽
        properties.setProperty("kaptcha.image.width", "140");
        // 图片高
        properties.setProperty("kaptcha.image.height", "40");
        // 图片边框
        properties.setProperty("kaptcha.border", "no");
        // 边框颜色
        //properties.setProperty("kaptcha.border.color", "255,255,255");
        // 字体颜色
        properties.setProperty("kaptcha.textproducer.font.color", "60,179,113");
        // 字体大小
        properties.setProperty("kaptcha.textproducer.font.size", "32");
        // session key
        properties.setProperty("kaptcha.session.key", "code");
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        // 字体
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
