/*
 * 文 件 名:  CheckFileUtil.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月25日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月25日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class CheckFileUtil
{
    public final static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();
    
    private CheckFileUtil()
    {
    }
    
    static
    {
        getAllFileType(); //初始化文件类型信息     
    }
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param url
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String getFileName(String url)
    {
        int gindex = url.lastIndexOf(File.separatorChar) + 1;
        int dindex = url.lastIndexOf(".");
        return url.substring(gindex, dindex);
    }
    
    /**   
     * Discription:[getAllFileType,常见文件头信息] 
     */
    private static void getAllFileType()
    {
        FILE_TYPE_MAP.put("FFD8FF", "jpg");
        FILE_TYPE_MAP.put("89504E47", "png");
        FILE_TYPE_MAP.put("47494638", "gif");
        FILE_TYPE_MAP.put("49492A00", "tif");
        FILE_TYPE_MAP.put("424D", "bmp");
        FILE_TYPE_MAP.put("41433130", "dwg"); // CAD
        FILE_TYPE_MAP.put("38425053", "psd");
        FILE_TYPE_MAP.put("7B5C727466", "rtf"); // 日记本
        FILE_TYPE_MAP.put("3C3F786D6C", "xml");
        FILE_TYPE_MAP.put("68746D6C3E", "html");
        FILE_TYPE_MAP.put("44656C69766572792D646174653A", "eml"); // 邮件
        FILE_TYPE_MAP.put("D0CF11E0", "doc");
        FILE_TYPE_MAP.put("D0CF11E0", "xls");//excel2003版本文件
        FILE_TYPE_MAP.put("5374616E64617264204A", "mdb");
        FILE_TYPE_MAP.put("252150532D41646F6265", "ps");
        FILE_TYPE_MAP.put("255044462D312E", "pdf");
        FILE_TYPE_MAP.put("504B0304", "docx");
        FILE_TYPE_MAP.put("504B0304", "xlsx");//excel2007以上版本文件
        FILE_TYPE_MAP.put("52617221", "rar");
        FILE_TYPE_MAP.put("57415645", "wav");
        FILE_TYPE_MAP.put("41564920", "avi");
        FILE_TYPE_MAP.put("2E524D46", "rm");
        FILE_TYPE_MAP.put("000001BA", "mpg");
        FILE_TYPE_MAP.put("000001B3", "mpg");
        FILE_TYPE_MAP.put("6D6F6F76", "mov");
        FILE_TYPE_MAP.put("3026B2758E66CF11", "asf");
        FILE_TYPE_MAP.put("4D546864", "mid");
        FILE_TYPE_MAP.put("1F8B08", "gz");
    }
    
    /**
     * 得到上传文件的文件头
     * @param src 文件字节数据
     * @return 文件头
     */
    public static String bytesToHexString(byte[] src)
    {
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0)
        {
            return null;
        }
        for (int i = 0; i < src.length; i++)
        {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2)
            {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }
    
    /**
     * 根据制定文件的文件头判断其文件类型
     * @param file 文件
     * @return 文件类型
     * @throws Exception 异常
     */
    public static String getFileType(File file)
        throws Exception
    {
        String res = null;
        FileInputStream is = null;
        try
        {
            is = new FileInputStream(file);
            byte[] b = new byte[10];
            is.read(b, 0, b.length);
            String fileCode = bytesToHexString(b);
            
            //这种方法在字典的头代码不够位数的时候可以用但是速度相对慢一点
            Iterator<String> keyIter = FILE_TYPE_MAP.keySet().iterator();
            while (keyIter.hasNext())
            {
                String key = keyIter.next();
                if (key.toLowerCase().startsWith(fileCode.toLowerCase())
                    || fileCode.toLowerCase().startsWith(key.toLowerCase()))
                {
                    res = FILE_TYPE_MAP.get(key);
                    break;
                }
            }
        }
        finally
        {
            if (is != null)
            {
                is.close();
            }
        }
        return res;
    }
    
    public static String getFileTypeM(MultipartFile file)
        throws Exception
    {
        String res = null;
        FileInputStream is = null;
        try
        {
            is = (FileInputStream)file.getInputStream();
            byte[] b = new byte[10];
            is.read(b, 0, b.length);
            String fileCode = bytesToHexString(b);
            //这种方法在字典的头代码不够位数的时候可以用但是速度相对慢一点
            Iterator<String> keyIter = FILE_TYPE_MAP.keySet().iterator();
            while (keyIter.hasNext())
            {
                String key = keyIter.next();
                if (key.toLowerCase().startsWith(fileCode.toLowerCase())
                    || fileCode.toLowerCase().startsWith(key.toLowerCase()))
                {
                    res = FILE_TYPE_MAP.get(key);
                    break;
                }
            }
        }
        finally
        {
            if (is != null)
            {
                is.close();
            }
        }
        return res;
    }
    
    /**
     * 判断文件类型是否为图片
     * <一句话功能简述>
     * <功能详细描述>
     * @param file
     * @return
     * @throws Exception
     * @see [类、类#方法、类#成员]
     */
    public static boolean isPicture(File file)
        throws Exception
    {
        String fileType = getFileType(file);
        if ("jpg".equalsIgnoreCase(fileType) || "png".equalsIgnoreCase(fileType) || "gif".equalsIgnoreCase(fileType)
            || "bmp".equalsIgnoreCase(fileType))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * 
     * <一句话功能简述>
     * <功能详细描述>
     * @param file
     * @return
     * @throws Exception 
     * @see [类、类#方法、类#成员]
     */
    public static boolean isPictureM(MultipartFile file)
        throws Exception
    {
        String fileType = getFileTypeM(file);
        if ("jpg".equalsIgnoreCase(fileType) || "png".equalsIgnoreCase(fileType) || "gif".equalsIgnoreCase(fileType)
            || "bmp".equalsIgnoreCase(fileType))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
