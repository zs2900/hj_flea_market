package com.ecjtu.common.validator.handler;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.controller.request.IRequest;
import com.ecjtu.common.enums.ResultCode;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.exception.ValidateException;
import com.ecjtu.common.validator.IValidatable;
import com.ecjtu.common.validator.Validator;
import com.ecjtu.common.validator.annotations.ArrayParam;

/**
 * 注解ArrayParam对应的处理类
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class ArrayParamHandler implements Handler
{
    private static Logger logger = LoggerFactory.getLogger(ArrayParamHandler.class);
    
    /**
     * 校验异常内容的日志格式  ： param=所有参数的值|具体异常消息
     */
    private static final String LOG_PARAM = "param=";
    
    /**
     * 校验异常内容的日志格式  ： param=所有参数的值|具体异常消息
     */
    private static final String LOG_SEPERATE = "|";
    
    @Override
    public void execute(Annotation annotation, String fieldName, Object fieldValue, IValidatable bean)
        throws ValidateException, InnerException
    {
        // 将参数体转为String，用于记录校验失败日志
        String paramStr = JSONObject.toJSONString(bean);
        
        ArrayParam arrayParamAnno = (ArrayParam)annotation;
        // 为空校验
        boolean canBlank = arrayParamAnno.canBlank();
        if (!canBlank && null == fieldValue)
        {
            throw new ValidateException(ResultCode.INVALID_PARAM.getResultCode(),
                ResultCode.INVALID_PARAM.getResultMsg(), LOG_PARAM + paramStr + LOG_SEPERATE + fieldName + "不能为空");
        }
        
        // 如果允许为空，且刚好为空，则跳过其他校验
        if (null == fieldValue)
        {
            return;
        }
        Field field = null;
        ParameterizedType pt = null;
        try
        {
            field = bean.getClass().getDeclaredField(fieldName);
            // 默认假设为String数组
            Class<?> itemClazz = String.class;
            try
            {
                pt = (ParameterizedType)field.getGenericType();
                itemClazz = (Class<?>)pt.getActualTypeArguments()[0];
            }
            catch (Exception e)
            {
                logger.info(fieldName + "是非封装类型数组");
            }
            
            List<?> list = JSONArray.parseArray(JSON.toJSONString(fieldValue), itemClazz);
            // 解析得到的数组为空
            if (!canBlank && CollectionUtils.isEmpty(list))
            {
                throw new ValidateException(ResultCode.INVALID_PARAM.getResultCode(),
                    ResultCode.INVALID_PARAM.getResultMsg(), LOG_PARAM + paramStr + LOG_SEPERATE + fieldName + "不能为空");
            }
            // 如果允许为空，且刚好为空，则跳过其他校验
            if (CollectionUtils.isEmpty(list))
            {
                return;
            }
            // 最大长度校验
            int maxLen = arrayParamAnno.maxLength();
            if (maxLen != -1 && list.size() > maxLen)
            {
                throw new ValidateException(ResultCode.INVALID_PARAM.getResultCode(),
                    ResultCode.INVALID_PARAM.getResultMsg(),
                    LOG_PARAM + paramStr + LOG_SEPERATE + fieldName + "超过最大长度");
            }
            // 单个元素校验
            checkItem(fieldName, arrayParamAnno, itemClazz, list, paramStr);
        }
        catch (NoSuchFieldException | SecurityException e)
        {
            logger.error("反射field异常");
            throw new InnerException(ResultCode.INNER_ERROR.getResultCode(), ResultCode.INNER_ERROR.getResultMsg(), e);
        }
    }
    
    /**
     * 集合中元素的校验
     * <功能详细描述>
     * @param fieldName 属性名
     * @param arrayParamAnno 集合注解
     * @param itemClazz 元素类
     * @param list 数据
     * @param paramStr 请求参数体
     * @throws InnerException 
     * @see [类、类#方法、类#成员]
     */
    private void checkItem(String fieldName, ArrayParam arrayParamAnno, Class<?> itemClazz, List<?> list,
        String paramStr)
        throws InnerException
    {
        boolean canItemBlank = arrayParamAnno.canItemBlank();
        for (Object object : list)
        {
            // 单个元素为空校验
            if (!canItemBlank && (null == object || StringUtils.isEmpty(String.valueOf(object))))
            {
                throw new ValidateException(ResultCode.INVALID_PARAM.getResultCode(),
                    ResultCode.INVALID_PARAM.getResultMsg(),
                    LOG_PARAM + paramStr + LOG_SEPERATE + fieldName + "某个元素为空");
            }
            // 如果允许为空，且刚好为空，则跳过其他校验，继续下一个元素校验
            if (null == object)
            {
                continue;
            }
            
            // 业务封装类，递归校验封装类对象
            if (IRequest.class.isAssignableFrom(itemClazz))
            {
                IRequest itemObj = (IRequest)JSON.parseObject(JSON.toJSONString(object), itemClazz);
                Validator.getInstance().validate(itemClazz, itemObj);
            }
            // 基础数据类型，继续itemRegex校验项
            else
            {
                String itemRegex = arrayParamAnno.itemRegex();
                if (!StringUtils.isEmpty(itemRegex))
                {
                    Pattern pattern = Pattern.compile(itemRegex);
                    Matcher matcher = pattern.matcher(String.valueOf(object));
                    if (!matcher.matches())
                    {
                        throw new ValidateException(ResultCode.INVALID_PARAM.getResultCode(),
                            ResultCode.INVALID_PARAM.getResultMsg(),
                            LOG_PARAM + paramStr + LOG_SEPERATE + fieldName + "某个元素格式不正确");
                    }
                }
            }
        }
    }
}
