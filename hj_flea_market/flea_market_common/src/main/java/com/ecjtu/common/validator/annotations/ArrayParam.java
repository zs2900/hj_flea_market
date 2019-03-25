package com.ecjtu.common.validator.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数组类型 或者 List类型参数校验注解
 * <功能详细描述>
 * 
 * @author  longguofei
 * @version  [版本号, 2017年10月19日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface ArrayParam
{
    /**
     * 是否可以为空
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    boolean canBlank();
    
    /**
     * 最多能有多少个子元素
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    int maxLength();
    
    /**
     * 子元素是否可以为空
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    boolean canItemBlank();
    
    /**
     * 每个子元素的正则规则
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    String itemRegex() default "";
}