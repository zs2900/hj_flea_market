package com.ecjtu.common.enums;

/**
 * 公共返回码
 * <功能详细描述>
 * 
 * @author  longguofei
 * @version  [版本号, 2017年10月19日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public enum ResultCode
{
    /**
     * native service not found
     */
    NATIVE_SERVICE_NOT_FOUND(-2, "找不到对应的服务", "no such service"),
    /**
     * 
     */
    FILE_IS_EMPTY(-3, "文件不存在", "file is empty"),
    /**
     * 未知的错误
     */
    UNKNOW_ERROR(-1, "未知的错误", "unknown error"),
    /**
     * 图片验证码校验失败
     */
    IMAGE_CODE_FILED(-4, "图片验证码错误", "picture verification code error"),
    /**
     * 账号或密码错误
     */
    LOGIN_FILED(-5, "账号或密码错误", "Error in account or password"),
    /**
     * 未登录
     */
    USER_NOT_FIND(-6, "未登录", "User not find"),
    /**
     * 文件类型不支持
     */
    FILE_TYPE_NOT_SUPPORT(-7, "文件类型不支持", "File type is not supported"),
    
    /**
     * 成功
     */
    SUCCESS(0, "成功", "success"),
    /**
     * 非法参数
     */
    INVALID_PARAM(1, "非法参数", "invalid param"),
    /**
     * 非法请求
     */
    REQUEST_INVALID(2, "请求无效", "request invalid"),
    /**
     * 内部错误
     */
    INNER_ERROR(3, "服务器繁忙", "server is busy"),
    /**
     * 请求超时
     */
    REQUEST_EXPIRED(4, "请求超时", "request expired"),
    /**
     * 指定数据不存在
     */
    DATA_NOT_EXIST(1001, "指定数据不存在", "data not exist"),
    /**
     * 下载的文件不存在
     */
    FILE_NOT_EXIST(1003, "下载的文件不存在", "file not exist"),
    /**
     * 获取客户端位置失败
     */
    FAILED_LOCATION(1004, "获取客户端位置失败", "get location is failed"),
    /**
     * 资源找不到
     */
    RESOURCES_NOT_EXIST(302002, "资源找不到", "resources not exist"),
    /**
     * 记录已存在
     */
    RECORD_ALREADY_EXIST(302003, "记录已存在", "record already exist"),
    /**
     * 
     */
    ERROR_DB(302001, "数据库错误", "database error"),
    /**
     * 数据库连接错误
     */
    ERROR_DB_CONNECTION(302004, "数据库连接错误", "database connection error"),
    /**
     * 无效的数据状态
     */
    INVALID_DATA_STATUS(302005, "无效的数据状态", "invalid data status"),
    /**
     * 服务器异常
     */
    SERVICE_ERROR(500, "服务器异常", "service error");
    /**
     * 错误码
     */
    private final int resultCode;
    
    /**
     * 错误消息
     */
    private final String resultMsg;
    
    /**
     * 错误消息(英文)
     */
    private final String resultMsgEn;
    
    /**
     * <默认构造函数>
      * @param resultCode 错误码
      * @param resultMsg 错误消息
     */
    ResultCode(int resultCode, String resultMsg, String resultMsgEn)
    {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.resultMsgEn = resultMsgEn;
    }
    
    public int getResultCode()
    {
        return this.resultCode;
    }
    
    public String getResultMsg()
    {
        return this.resultMsg;
    }
    
    public String getResultMsgEn()
    {
        return this.resultMsgEn;
    }
    
    public static ResultCode getItem(int resultCode)
    {
        for (ResultCode item : ResultCode.values())
        {
            if (resultCode == item.getResultCode())
            {
                return item;
            }
        }
        
        return UNKNOW_ERROR;
    }
}
