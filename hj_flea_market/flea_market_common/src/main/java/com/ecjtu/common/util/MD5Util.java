/*
 * 文 件 名:  MD5Util.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.common.util;

import java.security.MessageDigest;
import java.util.Random;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class MD5Util
{
    /**
     * byte[]字节数组 转换成 十六进制字符串
     * <一句话功能简述>
     * <功能详细描述>
     * @param arr 要转换的byte[]字节数组
    
     * @return 返回十六进制字符串
     * @see [类、类#方法、类#成员]
     */
    private static String hex(byte[] arr)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < arr.length; ++i)
        {
            sb.append(Integer.toHexString((arr[i] & 0xFF) | 0x100).substring(1, 3));
        }
        return sb.toString();
    }
    
    /**
     * MD5加密,并把结果由字节数组转换成十六进制字符串
     * <一句话功能简述>
     * <功能详细描述>
     * @param str 要加密的内容
     * @return 返回加密后的十六进制字符串
     * @see [类、类#方法、类#成员]
     */
    public static String md5Hex(String str)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(str.getBytes());
            return hex(digest);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.toString());
            return "";
        }
    }
    
    /**
     * 生成含有随机盐的密码
     * <一句话功能简述>
     * <功能详细描述>
     * @param password 要加密的密码
     * @return 含有随机盐的密码
     * @see [类、类#方法、类#成员]
     */
    public static String getSaltMD5(String password)
    {
        // 生成一个16位的随机数
        Random random = new Random();
        StringBuilder sBuilder = new StringBuilder(16);
        sBuilder.append(random.nextInt(99999999)).append(random.nextInt(99999999));
        int len = sBuilder.length();
        if (len < 16)
        {
            for (int i = 0; i < 16 - len; i++)
            {
                sBuilder.append("0");
            }
        }
        // 生成最终的加密盐
        String salt = sBuilder.toString();
        password = md5Hex(password + salt);
        char[] cs = new char[48];
        for (int i = 0; i < 48; i += 3)
        {
            cs[i] = password.charAt(i / 3 * 2);
            char c = salt.charAt(i / 3);
            cs[i + 1] = c;
            cs[i + 2] = password.charAt(i / 3 * 2 + 1);
        }
        System.out.println("加密：" + String.valueOf(cs));
        return String.valueOf(cs);
    }
    
    /**
     * 判断原字符串和加密字符串是否一致
     * <一句话功能简述>
     * <功能详细描述>
     * @param password 原密码
     * @param md5str 加密密码
     * @return 是否一致
     * @see [类、类#方法、类#成员]
     */
    public static boolean getSaltverifyMD5(String password, String md5str)
    {
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for (int i = 0; i < 48; i += 3)
        {
            cs1[i / 3 * 2] = md5str.charAt(i);
            cs1[i / 3 * 2 + 1] = md5str.charAt(i + 2);
            cs2[i / 3] = md5str.charAt(i + 1);
        }
        String Salt = new String(cs2);
        return md5Hex(password + Salt).equals(String.valueOf(cs1));
    }
}
