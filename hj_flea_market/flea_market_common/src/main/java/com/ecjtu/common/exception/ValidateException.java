package com.ecjtu.common.exception;

/**
 * 参数校验的异常类
 * 
 * @author  longguofei
 * @version  [版本号, 2017年10月18日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ValidateException extends InnerException
{
    /**
     * 序列id
     */
    private static final long serialVersionUID = 6738913338570396284L;
    
    /**
     * 详细异常信息
     */
    private String content;
    
    /**
     * <默认构造函数>
     * @param errCode 错误码
     */
    public ValidateException(int errCode)
    {
        super(errCode);
    }
    
    /**
     * <默认构造函数>
     * @param errCode 错误码
     * @param errMsg 错误消息
     */
    public ValidateException(int errCode, String errMsg)
    {
        super(errCode, errMsg);
    }
    
    /**
     * <默认构造函数>
     * @param errCode 错误码
     * @param errMsg 错误消息
     * @param content 详细异常信息
     */
    public ValidateException(int errCode, String errMsg, String content)
    {
        super(errCode, errMsg);
        this.content = content;
    }
    
    /**
     * <默认构造函数>
     * @param errCode 错误码
     * @param errMsg 错误消息
     * @param cause 异常堆栈
     */
    public ValidateException(int errCode, String errMsg, Throwable cause)
    {
        super(errCode, errMsg, cause);
    }
    
    /**
     * <默认构造函数>
     * @param errCode 错误码
     * @param errMsg 错误消息
     * @param content 详细异常信息
     * @param cause 异常堆栈
    */
    public ValidateException(int errCode, String errMsg, String content, Throwable cause)
    {
        super(errCode, errMsg, cause);
        this.content = content;
    }
    
    /**
     * <默认构造函数>
     * @param pattern 格式化
     * @param arguments 格式化消息
     */
    public ValidateException(String pattern, Object[] arguments)
    {
        super(pattern, arguments);
    }
    
    /**
     * <默认构造函数>
     * @param cause 异常堆栈
     * @param pattern 格式化
     * @param arguments 格式化消息
     */
    public ValidateException(Throwable cause, String pattern, Object[] arguments)
    {
        super(cause, pattern, arguments);
    }
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }
    
}
