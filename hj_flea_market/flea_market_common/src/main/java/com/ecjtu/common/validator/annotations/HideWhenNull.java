package com.ecjtu.common.validator.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * IResponse对象中加上该注解的字段为null时则不返回
 * <功能详细描述>
 * 
 * @author  longguofei
 * @version  [版本号, 2017年11月10日]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface HideWhenNull
{
    
}
