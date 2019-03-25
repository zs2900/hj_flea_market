package com.ecjtu.common.enums;

/**
 * 日志级别枚举类
 * <功能详细描述>
 * 
 * @author  longguofei
 * @version  [版本号, 2017年10月20日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public enum LogLevel
{
    /**
     * 调试
     */
    DEBUG("DEBUG"),
    /**
     * 正常
     */
    INFO("INFO"),
    /**
     * 告警
     */
    WARN("WARN"),
    /**
     * 错误
     */
    ERROR("ERROR");
    
    /**
     * 日志级别
     */
    private String level;
    
    /**
     * <默认构造函数>
      * @param level 日志级别
     */
    LogLevel(String level)
    {
        this.level = level;
    }
    
    public String getLevel()
    {
        return level;
    }
}
