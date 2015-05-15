package com.easymvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author 唐延波
 * @date 2015-5-13
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
	
	/**
	 * url name
	 * @author 唐延波
	 * @date 2015-5-13
	 * @return
	 */
	String[] value() default {};
}
