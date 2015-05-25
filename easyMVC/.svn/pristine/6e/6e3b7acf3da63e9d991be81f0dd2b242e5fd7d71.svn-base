package com.easymvc.converter;

import com.easymvc.exception.ConvertException;
import com.easymvc.util.StringUtil;

/**
 * ShortConverter
 * @author 唐延波
 * @date 2015-5-19
 */
public class ShortConverter implements Converter{
	
	@Override
	public Object convert(String param) {
		if(StringUtil.isEmpty(param)){
			return null;
		}
		try {
			Short result = Short.parseShort(param);
			return result;
		} catch (NumberFormatException e) {
			throw new ConvertException(e.getMessage(),e);
		}
	}

}
