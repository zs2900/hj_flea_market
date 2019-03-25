package com.ecjtu.common.validator.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 非List类型的校验注解
 * <功能详细描述>
 * 
 * @author  longguofei
 * @version  [版本号, 2017年10月19日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.ANNOTATION_TYPE,
    java.lang.annotation.ElementType.FIELD})
public @interface Param
{
    /**
     * 是否可以为空
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    boolean canBlank();
    
    /**
     * 正则
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    String regex() default "";
    
    /**
     * 默认值
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    String defValue() default "";
    
    /**
     * 最小长度
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    int minLength() default -1;
    
    /**
     * 最大允许长度
     * <功能详细描述>
     * @see [类、类#方法、类#成员]
     */
    int maxLength() default -1;
}