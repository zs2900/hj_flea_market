/*
 * 文 件 名:  SaleGoodsServiceImpl.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月13日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.web.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.ecjtu.common.constants.Strings;
import com.ecjtu.common.controller.response.BaseResponse;
import com.ecjtu.common.enums.ResultCode;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.model.Goods;
import com.ecjtu.common.model.Picture;
import com.ecjtu.common.model.User;
import com.ecjtu.common.validator.Validator;
import com.ecjtu.web.bean.resp.SelectGoods;
import com.ecjtu.web.controller.req.EditSaleInfoReq;
import com.ecjtu.web.controller.req.GetSaleReturnReq;
import com.ecjtu.web.controller.req.GetUserSaleListReq;
import com.ecjtu.web.controller.req.SaleGoodsReq;
import com.ecjtu.web.controller.req.SelectGoodsDetailReq;
import com.ecjtu.web.controller.req.SelectGoodsListReq;
import com.ecjtu.web.controller.req.SelectGoodsNumReq;
import com.ecjtu.web.controller.resp.EditSaleInfoResp;
import com.ecjtu.web.controller.resp.GetSaleReturnResp;
import com.ecjtu.web.controller.resp.GetUserSaleListResp;
import com.ecjtu.web.controller.resp.SelectGoodsDetailResp;
import com.ecjtu.web.controller.resp.SelectGoodsListResp;
import com.ecjtu.web.controller.resp.SelectGoodsNumResp;
import com.ecjtu.web.dao.GoodsMapper;
import com.ecjtu.web.dao.PictureMapper;
import com.ecjtu.web.service.SaleGoodsService;
import com.ecjtu.web.util.FileUtil;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月13日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Service
public class SaleGoodsServiceImpl implements SaleGoodsService
{
    @Autowired
    private GoodsMapper goodsMapper;
    
    @Autowired
    private PictureMapper pictureMapper;
    
    @Value("${user.head.image}")
    private String headImage;
    
    @Override
    public SelectGoodsNumResp selectGoodsTotal(SelectGoodsNumReq req)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(SelectGoodsNumReq.class, req);
        req.setgState(1);
        //查询二手商品数量
        Integer total = goodsMapper.selectGoodsTotal(req);
        Integer pageSize = total / req.getPageSize() == 0 ? total / req.getPageSize() : total / req.getPageSize() + 1;
        SelectGoodsNumResp resp = new SelectGoodsNumResp();
        resp.setGoodsNum(total);
        resp.setPageSize(pageSize);
        return resp;
    }
    
    @Override
    public SelectGoodsListResp selectGoodsList(SelectGoodsListReq req)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(SelectGoodsListReq.class, req);
        req.setgState(1);
        List<SelectGoods> list = goodsMapper.selectGoodsList(req);
        SelectGoodsListResp resp = new SelectGoodsListResp();
        resp.setGoodsList(list);
        return resp;
    }
    
    @Override
    public SelectGoodsDetailResp selectGoodsDetail(SelectGoodsDetailReq req, HttpSession session)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(SelectGoodsDetailReq.class, req);
        
        SelectGoodsDetailResp resp = goodsMapper.selectGoodsDetail(req.getgId());
        if (session.getAttribute("userAccount") != null)
        {
            resp.setIsLogin(1);
            if (resp.getuHeadPic() == null)
            {
                resp.setuHeadPic(headImage);
            }
        }
        else
        {
            //未登录隐藏重要信息
            resp.setIsLogin(0);
            resp.setuPhoneNumber(Strings.hidenNum);
            resp.setuQQNumber(Strings.hidenNum);
        }
        return resp;
    }
    
    @Override
    public BaseResponse saleGoods(SaleGoodsReq req, HttpSession session)
        throws InnerException
    {
        //参数校验
        Validator.getInstance().validate(SaleGoodsReq.class, req);
        
        //判断用户是否登录
        User user = (User)session.getAttribute("userAccount");
        if (user == null)
        {
            BaseResponse response = new BaseResponse();
            response.setRetCode(ResultCode.USER_NOT_FIND.getResultCode());
            response.setRetMsg(ResultCode.USER_NOT_FIND.getResultMsg());
            return response;
        }
        //保存商品信息
        Goods goods = new Goods();
        goods.setgName(req.getTitle());
        goods.setgDescription(req.getDetail());
        goods.setgPrice(req.getPrice());
        goods.setgType(req.getType());
        goods.setgNumber(1);
        goods.setgState(0);
        goods.setgAddress(req.getAddress());
        goods.setuId(user.getuId());
        goods.setgImage(req.getThumb());
        
        //插入数据库得到插入的gId
        goodsMapper.saveGoods(goods);
        System.out.println("goods id: " + goods.getgId());
        for (String url : req.getImages())
        {
            Picture picture = new Picture();
            picture.setgId(goods.getgId());
            picture.setpUrl(url);
            picture.setpCode(FileUtil.getFileName(url));
            //将图片插入数据库picture表
            pictureMapper.savePicture(picture);
        }
        
        //返回成功信息
        return new BaseResponse();
    }
    
    @Override
    public GetUserSaleListResp getUserSaleList(GetUserSaleListReq req, HttpSession session)
        throws InnerException
    {
        //验证用户是否登录
        User user = (User)session.getAttribute("userAccount");
        if (user == null)
        {
            GetUserSaleListResp resp = new GetUserSaleListResp();
            resp.setRetCode(ResultCode.USER_NOT_FIND.getResultCode());
            resp.setRetMsg(ResultCode.USER_NOT_FIND.getResultMsg());
            return resp;
        }
        
        //获取用户商品总数
        req.setuId(user.getuId());
        List<Goods> list = goodsMapper.getUserSaleList(req);
        Integer total = goodsMapper.getUserSaleNum(user.getuId());
        
        //获取用户商品列表
        GetUserSaleListResp resp = new GetUserSaleListResp();
        resp.setGoodsList(list);
        resp.setTotalPage(total % req.getPageSize() == 0 ? total / req.getPageSize() : total / req.getPageSize() + 1);
        
        return resp;
    }
    
    @Override
    public GetSaleReturnResp getSaleReturn(GetSaleReturnReq req, HttpSession session)
        throws InnerException
    {
        //验证用户登录
        User user = (User)session.getAttribute("userAccount");
        if (user == null)
        {
            GetSaleReturnResp resp = new GetSaleReturnResp();
            resp.setRetCode(ResultCode.USER_NOT_FIND.getResultCode());
            resp.setRetMsg(ResultCode.USER_NOT_FIND.getResultMsg());
            return resp;
        }
        
        //获取商品信息
        SelectGoods goods = goodsMapper.getSaleReturn(req.getgId());
        GetSaleReturnResp resp = new GetSaleReturnResp();
        resp.setGoods(goods);
        
        return resp;
    }
    
    @Override
    public EditSaleInfoResp editSaleInfo(EditSaleInfoReq req, HttpSession session)
        throws InnerException
    {
        //验证用户登录
        User user = (User)session.getAttribute("userAccount");
        if (user == null)
        {
            EditSaleInfoResp resp = new EditSaleInfoResp();
            resp.setRetCode(ResultCode.USER_NOT_FIND.getResultCode());
            resp.setRetMsg(ResultCode.USER_NOT_FIND.getResultMsg());
            return resp;
        }
        
        //验证用户商品权限
        Goods goods = goodsMapper.getGoodsById(req.getgId());
        if (goods.getuId().equals(user.getuId()))
        {
            goods.setgImage(req.getThumb());
            goods.setgName(req.getTitle());
            goods.setgPrice(req.getPrice());
            goods.setgState(0);
            goods.setgType(req.getType());
            goods.setgAddress(req.getAddress());
            goodsMapper.editSaleInfo(goods);
            
            //判断是否输入商品图片
            if (req.getImages() != null)
            {
                pictureMapper.deletePicture(goods.getgId());
                for (String imagePath : req.getImages())
                {
                    Picture picture = new Picture();
                    picture.setgId(goods.getgId());
                    picture.setpUrl(imagePath);
                    picture.setpCode(FileUtil.getFileName(imagePath));
                    pictureMapper.savePicture(picture);
                }
            }
        }
        else
        {
            EditSaleInfoResp resp = new EditSaleInfoResp();
            resp.setRetCode(ResultCode.DATA_NOT_EXIST.getResultCode());
            resp.setRetMsg(ResultCode.DATA_NOT_EXIST.getResultMsg());
            return resp;
        }
        
        return new EditSaleInfoResp();
    }
    
}
