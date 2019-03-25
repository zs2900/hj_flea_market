package com.ecjtu.common.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.alibaba.fastjson.util.IOUtils;
import com.ecjtu.common.constants.NumberKeys;

/**
 * 文件工具
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  tianqiuming
 * @version  [版本号, 2017年11月6日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public abstract class FileUtil
{
    /** 
     * 获取文件属性
     * @param in InputStream  
     * @param filePath 文件的保存路径 
     * @param fileName 文件的名称 
     * @param path url路径
     * @return file属性大小，路径
     * @throws IOException 
     */
    public static Map<String, Object> saveFile(InputStream in, String filePath, String fileName, String path)
        throws IOException
    {
        
        //将流转成临时存储文件，拿到属性存储在map里面然后删除临时文件。
        Map<String, Object> map = new HashMap<String, Object>();
        FileOutputStream fos = null;
        File file = null;
        byte[] b = null;
        try
        {
            file = new File(filePath, fileName);
            fos = new FileOutputStream(file);
            b = new byte[NumberKeys.NUM_1024];
            int nRead = NumberKeys.NUM_0;
            while ((nRead = in.read(b)) != NumberKeys.NEGATIVE_NUM_1)
            {
                fos.write(b, NumberKeys.NUM_0, nRead);
            }
            fos.flush();
            map.put("size", getPrintSize(file.length()));
            map.put("url", path + "/" + fileName);
        }
        finally
        {
            IOUtils.close(fos);
            IOUtils.close(in);
        }
        return map;
    }
    
    /** 
    * 获取文件属性
    * @param in InputStream  
    * @param imgPath 图片的保存路径 
    * @param imgName 图片的名称 
    * @param path url路径
    * @return 图片数据
    * @throws IOException 
    */
    public static Map<String, Object> saveImg(InputStream in, String imgPath, String imgName, String path)
        throws IOException
    {
        
        //将流转成临时存储文件，拿到属性存储在map里面然后删除临时文件。
        Map<String, Object> map = new HashMap<String, Object>();
        FileOutputStream fos = null;
        BufferedImage bufferedImage = null;
        File file = null;
        File f = null;
        byte[] b = null;
        FileInputStream fis = null;
        try
        {
            // 将上面生成的图片格式字符串 imgStr，还原成图片显示 
            file = new File(imgPath, imgName);//可以是任何图片格式.jpg,.png等 
            fos = new FileOutputStream(file);
            b = new byte[NumberKeys.NUM_1024];
            int nRead = 0;
            while ((nRead = in.read(b)) != -1)
            {
                fos.write(b, 0, nRead);
            }
            fos.flush();
            map.put("size", getPrintSize(file.length()));
            bufferedImage = ImageIO.read(file);
            map.put("width", bufferedImage.getWidth());
            map.put("height", bufferedImage.getHeight());
            
            //这里为什么要新得到一个流呢，因为上面流写入完了，发现传到存储服务器的文件是空的，个人猜测，流空了，没有深入研究过=.=
            f = new File(imgPath + "/" + imgName);
            fis = new FileInputStream(f);
            
            map.put("url", path + "/" + imgName);
        }
        finally
        {
            IOUtils.close(fos);
            IOUtils.close(fis);
            IOUtils.close(in);
        }
        return map;
    }
    
    /**
    * 将文件大小b转为mb
    * @param size 大小
    * @return 数据
    */
    public static String getPrintSize(long size)
    {
        //如果字节数少于1024，则直接以B为单位，否则先除于1024，后3位因太少无意义 
        if (size < NumberKeys.NUM_1024)
        {
            return String.valueOf(size) + "B";
        }
        else
        {
            size = size / NumberKeys.NUM_1024;
        }
        //如果原字节数除于1024之后，少于1024，则可以直接以KB作为单位 
        //因为还没有到达要使用另一个单位的时候 
        //接下去以此类推 
        if (size < NumberKeys.NUM_1024)
        {
            return String.valueOf(size) + "KB";
        }
        else
        {
            size = size / NumberKeys.NUM_1024;
        }
        //if (size < 1024) { 
        //因为如果以MB为单位的话，要保留最后1位小数， 
        //因此，把此数乘以100之后再取余 
        size = size * NumberKeys.NUM_100;
        return String.valueOf(size / NumberKeys.NUM_100) + "." + String.valueOf(size % NumberKeys.NUM_100) + "MB";
        /*} else { 
        //否则如果要以GB为单位的，先除于1024再作同样的处理 
        size = size * 100 / 1024; 
        return String.valueOf((size / 100)) + "." 
        + String.valueOf((size % 100)) + "GB"; 
        } */
    }
    
    /**
    * 删除指定文件或者指定文件夹下的文件
    * @param folderPath 路径
    */
    public static void delFolder(String folderPath)
    {
        File myFilePath = null;
        try
        {
            myFilePath = new File(folderPath);
            if (myFilePath.exists())
            {
                boolean result = myFilePath.delete();
                if (!result)
                {
                    throw new IOException("删除文件失败:" + folderPath);
                }
                
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            myFilePath = null;
        }
    }
    
}
