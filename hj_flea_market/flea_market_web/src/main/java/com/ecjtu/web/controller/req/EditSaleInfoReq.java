/*
 * 文 件 名:  EditSaleInfoReq.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月20日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller.req;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.request.BaseRequest;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月20日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class EditSaleInfoReq extends BaseRequest
{
    private Integer gId;
    
    private String title;
    
    private String detail;
    
    private String address;
    
    private String daofou;
    
    private Double price;
    
    private Integer type;
    
    private Integer school;
    
    private String tel;
    
    private Integer qq;
    
    private String weixin;
    
    private String thumb;
    
    private List<String> images;
    
    /**
     * @return 返回 gId
     */
    public Integer getgId()
    {
        return gId;
    }
    
    /**
     * @param 对gId进行赋值
     */
    public void setgId(Integer gId)
    {
        this.gId = gId;
    }
    
    /**
     * @return 返回 title
     */
    public String getTitle()
    {
        return title;
    }
    
    /**
     * @param 对title进行赋值
     */
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    /**
     * @return 返回 detail
     */
    public String getDetail()
    {
        return detail;
    }
    
    /**
     * @param 对detail进行赋值
     */
    public void setDetail(String detail)
    {
        this.detail = detail;
    }
    
    /**
     * @return 返回 address
     */
    public String getAddress()
    {
        return address;
    }
    
    /**
     * @param 对address进行赋值
     */
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    /**
     * @return 返回 daofou
     */
    public String getDaofou()
    {
        return daofou;
    }
    
    /**
     * @param 对daofou进行赋值
     */
    public void setDaofou(String daofou)
    {
        this.daofou = daofou;
    }
    
    /**
     * @return 返回 price
     */
    public Double getPrice()
    {
        return price;
    }
    
    /**
     * @param 对price进行赋值
     */
    public void setPrice(Double price)
    {
        this.price = price;
    }
    
    /**
     * @return 返回 type
     */
    public Integer getType()
    {
        return type;
    }
    
    /**
     * @param 对type进行赋值
     */
    public void setType(Integer type)
    {
        this.type = type;
    }
    
    /**
     * @return 返回 school
     */
    public Integer getSchool()
    {
        return school;
    }
    
    /**
     * @param 对school进行赋值
     */
    public void setSchool(Integer school)
    {
        this.school = school;
    }
    
    /**
     * @return 返回 tel
     */
    public String getTel()
    {
        return tel;
    }
    
    /**
     * @param 对tel进行赋值
     */
    public void setTel(String tel)
    {
        this.tel = tel;
    }
    
    /**
     * @return 返回 qq
     */
    public Integer getQq()
    {
        return qq;
    }
    
    /**
     * @param 对qq进行赋值
     */
    public void setQq(Integer qq)
    {
        this.qq = qq;
    }
    
    /**
     * @return 返回 weixin
     */
    public String getWeixin()
    {
        return weixin;
    }
    
    /**
     * @param 对weixin进行赋值
     */
    public void setWeixin(String weixin)
    {
        this.weixin = weixin;
    }
    
    /**
     * @return 返回 thumb
     */
    public String getThumb()
    {
        return thumb;
    }
    
    /**
     * @param 对thumb进行赋值
     */
    public void setThumb(String thumb)
    {
        this.thumb = thumb;
    }
    
    /**
     * @return 返回 images
     */
    public List<String> getImages()
    {
        return images;
    }
    
    /**
     * @param 对images进行赋值
     */
    public void setImages(List<String> images)
    {
        this.images = images;
    }
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @return
     * @see [类、类#方法、类#成员]
     */
    
    public String toString()
    {
        return JSONObject.toJSONString(this);
    }
    
}
