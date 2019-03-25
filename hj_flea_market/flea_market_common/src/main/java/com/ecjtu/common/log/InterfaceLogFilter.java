/*
 * 文 件 名:  InterfaceLogFilter.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月13日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.common.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月13日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class InterfaceLogFilter extends Filter<ILoggingEvent>
{
    
    /**
     * 日志记录器名称
     */
    private String loggerName;
    
    @Override
    public FilterReply decide(ILoggingEvent event)
    {
        if (event.getLoggerName().equals(loggerName))
        {
            // 允许输入
            return FilterReply.ACCEPT;
        }
        else
        {
            // 不允许输出
            return FilterReply.DENY;
        }
    }
    
    public String getLoggerName()
    {
        return loggerName;
    }
    
    public void setLoggerName(String loggerName)
    {
        this.loggerName = loggerName;
    }
    
}
