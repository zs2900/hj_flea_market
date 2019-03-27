/*
 * 文 件 名:  DisplayController.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月26日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.validator.annotations.AOPLogAnnotation;
import com.ecjtu.web.controller.req.SelectDisplayReq;
import com.ecjtu.web.controller.resp.SelectDisplayResp;
import com.ecjtu.web.service.DisplayService;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月26日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@AOPLogAnnotation
@RestController
public class DisplayController
{
    @Autowired
    private DisplayService displayService;
    
    @RequestMapping(value = "/displaylist", method = RequestMethod.POST)
    public SelectDisplayResp selectDisplayList(@RequestBody SelectDisplayReq req)
        throws InnerException
    {
        return displayService.selectDisplayList(req);
    }
    
}
