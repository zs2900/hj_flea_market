/*
 * 文 件 名:  DisplayServiceImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月26日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.model.Display;
import com.ecjtu.web.controller.req.SelectDisplayReq;
import com.ecjtu.web.controller.resp.SelectDisplayResp;
import com.ecjtu.web.dao.DisplayMapper;
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
@Service
public class DisplayServiceImpl implements DisplayService
{
    @Autowired
    private DisplayMapper displayMapper;
    
    @Value("${file.service.uri}")
    private String imageRoot;
    
    /** 
     * <一句话功能简述>
     * <功能详细描述>
     * @param req
     * @return
     * @throws InnerException
     * @see [类、类#方法、类#成员]
     */
    @Override
    public SelectDisplayResp selectDisplayList(SelectDisplayReq req)
        throws InnerException
    {
        //取启用的展示栏
        List<Display> displays = displayMapper.selectDisplayList(req.getdState());
        SelectDisplayResp resp = new SelectDisplayResp();
        resp.setDisplays(displays);
        resp.setImageRoot(imageRoot);
        return resp;
    }
    
}
