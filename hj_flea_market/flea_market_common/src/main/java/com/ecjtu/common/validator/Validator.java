/*
 * 文 件 名:  Validator.java
 * 版    权:  Huawei Technologies Co., Ltd. Copyright YYYY-YYYY,  All rights reserved
 * 描    述:  <描述>
 * 修 改 人:  ZhongYi
 * 修改时间:  2019年3月8日
 * 跟踪单号:  <跟踪单号>
 * 修改单号:  <修改单号>
 * 修改内容:  <修改内容>
 */
package com.ecjtu.common.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ecjtu.common.constants.NumberKeys;
import com.ecjtu.common.enums.ResultCode;
import com.ecjtu.common.exception.InnerException;
import com.ecjtu.common.exception.ValidateException;
import com.ecjtu.common.util.ReflectUtil;
import com.ecjtu.common.validator.annotations.ArrayParam;
import com.ecjtu.common.validator.annotations.Param;
import com.ecjtu.common.validator.handler.Handler;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2019年3月8日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public final class Validator
{
    /**
     * 具体校验实现的包路径
     */
    private static final String HANDLER_PACKAGE_PATH = "com.ecjtu.common.validator.handler.";
    
    /**
     * 具体校验实现类的后缀
     */
    private static final String SUFFIX = "Handler";
    
    private static final int GET_SET_LEN = NumberKeys.NUM_3;
    
    /**
     * 定义一个静态私有变量
     */
    private static final Validator INSTANCE = new Validator();
    
    private static Logger logger = LoggerFactory.getLogger(Validator.class);
    
    private static Set<String> annoNames;
    
    /**
     * <默认构造函数>私有
     */
    private Validator()
    {
    }
    
    /**
     * 实例化
     * 
     * @return Validator
     * @see [类、类#方法、类#成员]
     */
    public static Validator getInstance()
    {
        return INSTANCE;
    }
    
    static
    {
        annoNames = new HashSet<String>();
        annoNames.add(Param.class.getName());
        annoNames.add(ArrayParam.class.getName());
    }
    
    /**
     * 校验参数方法
     * <一句话功能简述>
     * <功能详细描述>
     * @param clazz 类
     * @param bean 对象
     * @throws ValidateException 校验异常
     * @throws InnerException 内部异常
     * @see [类、类#方法、类#成员]
     */
    public void validate(Class<?> clazz, IValidatable bean)
        throws ValidateException, InnerException
    {
        if (null == bean)
        {
            throw new ValidateException(ResultCode.INVALID_PARAM.getResultCode(),
                ResultCode.INVALID_PARAM.getResultMsg(), "校验的实体对象为空");
        }
        // 获取字段注解配置
        Map<String, Annotation> fieldAnnotation = new HashMap<String, Annotation>();
        List<Method> getters = ReflectUtil.getMethods(clazz);
        for (Method method : getters)
        {
            String fieldName = method.getName().substring(GET_SET_LEN);
            fieldName = fieldName.substring(0, 1).toLowerCase(Locale.US) + fieldName.substring(1);
            Annotation[] annotations = method.getAnnotations();
            if (null == annotations || annotations.length == 0)
            {
                continue;
            }
            for (Annotation annotation : annotations)
            {
                String annoName = annotation.annotationType().getName();
                if (annoNames.contains(annoName))
                {
                    fieldAnnotation.put(fieldName, annotation);
                }
            }
        }
        
        try
        {
            // 校验
            for (Map.Entry<String, Annotation> entry : fieldAnnotation.entrySet())
            {
                String fieldName = entry.getKey();
                Object fieldValue = ReflectUtil.getValue(bean, fieldName);
                Annotation annotation = entry.getValue();
                
                String annoName = annotation.annotationType().getSimpleName();
                String handlerClassName = HANDLER_PACKAGE_PATH + annoName + SUFFIX;
                // 实例化校验器
                Handler handler = (Handler)Class.forName(handlerClassName).newInstance();
                handler.execute(annotation, fieldName, fieldValue, bean);
            }
        }
        catch (IllegalAccessException | InstantiationException | ClassNotFoundException e)
        {
            logger.error("实例化Handler失败");
            throw new InnerException(ResultCode.INNER_ERROR.getResultCode(), ResultCode.INNER_ERROR.getResultMsg(), e);
        }
    }
}
