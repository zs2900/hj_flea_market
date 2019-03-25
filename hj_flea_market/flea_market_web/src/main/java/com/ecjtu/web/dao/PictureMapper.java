/*
 * 文 件 名:  PictureMapper.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月17日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ecjtu.web.bean.Picture;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月17日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Mapper
public interface PictureMapper
{
    /**
     * 保存图片
     * <一句话功能简述>
     * <功能详细描述>
     * @param picture
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer savePicture(Picture picture);
    
    /**
     * 删除图片
     * <一句话功能简述>
     * <功能详细描述>
     * @param gId
     * @return
     * @see [类、类#方法、类#成员]
     */
    Integer deletePicture(Integer gId);
}
