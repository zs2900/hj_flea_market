package com.ecjtu.common.exception;

import java.text.MessageFormat;

/**
 * 系统内部异常类
 * <功能详细描述>
 * 
 * @author  longguofei
 * @version  [版本号, 2017年10月19日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class InnerException extends Exception
{
    /**
     * 注释内容
     */
    private static final long serialVersionUID = -5225254453889416247L;
    
    private int errorCode;
    
    private String errorDesc;
    
    /**
     * <默认构造函数>
      *
     */
    public InnerException()
    {
    }
    
    /**
     * <默认构造函数>
     * @param errorCode 错误码
     */
    public InnerException(int errorCode)
    {
        this.errorCode = errorCode;
    }
    
    /**
     * <默认构造函数>
     * @param errorDesc 错误消息
     */
    public InnerException(String errorDesc)
    {
        super(errorDesc);
        this.errorDesc = errorDesc;
    }
    
    /**
     * <默认构造函数>
      * @param errorCode 错误码
      * @param errorDesc 错误消息
     */
    public InnerException(int errorCode, String errorDesc)
    {
        super(errorDesc);
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }
    
    /**
     * <默认构造函数>
     * @param errorCode 错误码
     * @param errorDesc 错误消息
     * @param cause 异常堆栈
     */
    public InnerException(int errorCode, String errorDesc, Throwable cause)
    {
        super(errorDesc, cause);
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }
    
    /**
     * <默认构造函数>
     * @param pattern 格式化
     * @param arguments 格式化消息
     */
    public InnerException(String pattern, Object[] arguments)
    {
        super(MessageFormat.format(pattern, arguments));
    }
    
    /**
     * @param cause 异常堆栈
      * @param pattern 格式化
      * @param arguments 格式化消息
     */
    public InnerException(Throwable cause, String pattern, Object[] arguments)
    {
        super(MessageFormat.format(pattern, arguments), cause);
    }
    
    /**
     * <默认构造函数>
     * @param cause 异常堆栈
     */
    public InnerException(Throwable cause)
    {
        super(cause);
    }
    
    public void setErrorCode(int errorCode)
    {
        this.errorCode = errorCode;
    }
    
    public int getErrorCode()
    {
        return errorCode;
    }
    
    public String getErrorDesc()
    {
        return errorDesc;
    }
    
}
