/*
 * 文 件 名:  StringUtil.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.common.util;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public final class StringUtil
{
    /**
     * <默认构造函数>
     */
    private StringUtil()
    {
        super();
    }
    
    /** 
     * 判断字符是否为空null ''
     * <功能详细描述>
     * @param strings 字符
     * @return true为空 。false不为空
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEmpty(String... strings)
    {
        for (String str : strings)
        {
            if (str == null || "".equals(str))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * 判断是否整数字符
     * <功能详细描述>
     * @param str 字符
     * @return true为整数 ，false不为整数
     * @see [类、类#方法、类#成员]
     */
    public static boolean isInteger(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        try
        {
            Integer.parseInt(str);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        
        return true;
    }
    
    /**
     * 判断是否长整型字符
     * <功能详细描述>
     * @param str 字符
     * @return true为长整数 ，false不为长整数
     * @see [类、类#方法、类#成员]
     */
    public static boolean isLong(String str)
    {
        if (isEmpty(str))
        {
            return false;
        }
        try
        {
            Long.parseLong(str);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
        
        return true;
    }
    
    /**
     * 比较两个字符是否相等
     * <功能详细描述>
     * @param str1 字符1
     * @param str2 字符2
     * @return true相等 ，false不相等
     * @see [类、类#方法、类#成员]
     */
    public static boolean isEqual(String str1, String str2)
    {
        if (null == str1 && null == str2)
        {
            return true;
        }
        
        if (null != str1 && null != str2)
        {
            return str1.equals(str2);
        }
        return false;
    }
    
    /**
     * 汉子转unicode
     * <功能详细描述>
     * @param str 入参
     * @return String
     * @see [类、类#方法、类#成员]
     */
    public static String native2ascii(String str)
    {
        if (isEmpty(str))
        {
            return null;
        }
        
        StringBuffer unicode = new StringBuffer();
        for (int i = 0; i < str.length(); i++)
        {
            // 取出每一个字符
            char c = str.charAt(i);
            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }
        
        return unicode.toString();
    }
}
