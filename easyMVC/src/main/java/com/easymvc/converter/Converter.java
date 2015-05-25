package com.easymvc.converter;

/**
 * 类型转换器
 * @author 唐延波
 * @date 2015-5-19
 */
public interface Converter{

	/**
	 * 类型转换
	 * @author 唐延波
	 * @date 2015-5-19
	 * @param param
	 * @return
	 */
	public Object convert(String param);
}
