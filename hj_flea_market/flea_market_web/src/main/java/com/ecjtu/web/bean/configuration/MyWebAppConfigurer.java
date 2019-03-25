/*
 * 文 件 名:  MyWebAppConfigurer.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月11日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.bean.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月11日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter
{
    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**");
    }
}
