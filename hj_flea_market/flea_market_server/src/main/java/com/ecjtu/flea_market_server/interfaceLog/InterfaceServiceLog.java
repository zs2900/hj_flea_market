package com.ecjtu.flea_market_server.interfaceLog;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSONObject;
import com.ecjtu.common.util.IPAddressUtil;
import com.ecjtu.common.validator.annotations.AOPLogAnnotation;
import com.google.common.collect.Lists;

/**
 * <一句话功能简述>
 * <功能详细描述>
 * 
 * @author  ZhongYi
 * @version  [版本号, 2018年11月5日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Aspect
@Component
public class InterfaceServiceLog
{
    
    private static final Logger LOGGER = LoggerFactory.getLogger("Interface.Service.Log");
    
    /**
     * 
     * 日志切入点
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    @Pointcut("execution(public * com.ecjtu.flea_market_server.controller.*Controller.*(..))") //两个..代表所有子目录，最后括号里的两个..代表所有参数
    public void logPointCut()
    {
    }
    
    /**
     * 
     * 切入点前后
     * <功能详细描述>
     * @param pjp 切入的目标方法
     * @return 执行目标方法的返回
     * @throws Throwable 异常
     * @see [类、类#方法、类#成员]
     */
    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint pjp)
        throws Throwable
    {
        String signatureName = pjp.getSignature().getName();
        Class<? extends Object> invokeClass = pjp.getTarget().getClass();
        if (isTagged(invokeClass, signatureName))
        {
            //执行切入点方法
            ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            long startTime = System.currentTimeMillis();
            String starts = simpleDateFormat.format(startTime);
            Object ob = pjp.proceed();
            
            String endTime = simpleDateFormat.format(new Date(System.currentTimeMillis()));
            Long spendTime = System.currentTimeMillis() - startTime;
            LOGGER.info("起始时间: {}  请求地址 : {}  IP: {}  请求接口名称: {}  请求参数 : {}  结束时间: {}  返回值: {}  耗时: {}",
                starts,
                request.getRequestURL().toString(),
                IPAddressUtil.getIpAddress(request),
                pjp.getSignature().getName(),
                Arrays.toString(pjp.getArgs()),
                endTime,
                JSONObject.toJSON(ob),
                spendTime);
            return ob;
        }
        Object ob = pjp.proceed();
        return ob;
    }
    
    //扫描父类是否被打上标签,或者父类中的这个方法是否被打伤标签
    private boolean isTagged(Class invokeClass, String signatureName)
    {
        if (isTaggedInInterfaceOf(invokeClass, signatureName))
        {
            return true;
        }
        if (!invokeClass.equals(Object.class))
        {
            return isTaggedInClassOf(invokeClass, signatureName) ? true
                : isTagged(invokeClass.getSuperclass(), signatureName);
        }
        return false;
    }
    
    //扫描当前类的接口
    private boolean isTaggedInInterfaceOf(Class invokeClass, String signatureName)
    {
        Class[] interfaces = invokeClass.getInterfaces();
        for (Class cas : interfaces)
        {
            return isTaggedInClassOf(cas, signatureName) ? true : isTaggedInInterfaceOf(cas, signatureName);
        }
        return false;
    }
    
    //方法名为signatureName的方法tagged有两种情况:方法本身被taged或者方法所在的类被taged
    private boolean isTaggedInClassOf(Class cas, String signatureName)
    {
        return Lists.newArrayList(cas.getDeclaredMethods())
            .stream()
            .anyMatch(method -> isMethodWithName(method, signatureName) && isMethodTagged(method)
                || isMethodWithName(method, signatureName) && isClassTagged(cas));
    }
    
    private boolean isClassTagged(Class invokeClass)
    {
        return invokeClass.getAnnotation(AOPLogAnnotation.class) != null;
    }
    
    private boolean isMethodTagged(Method method)
    {
        return method.getAnnotation(AOPLogAnnotation.class) != null;
    }
    
    private boolean isMethodWithName(Method method, String name)
    {
        return method.getName().equals(name);
    }
    
}
