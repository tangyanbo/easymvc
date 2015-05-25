package com.easymvc.converter;

import com.easymvc.exception.ConvertException;
import com.easymvc.util.StringUtil;

/**
 * LongConverter
 * @author 唐延波
 * @date 2015-5-19
 */
public class LongConverter implements Converter{
	
	@Override
	public Object convert(String param) {
		if(StringUtil.isEmpty(param)){
			return null;
		}
		try {
			Long result = Long.parseLong(param);
			return result;
		} catch (NumberFormatException e) {
			throw new ConvertException(e.getMessage(),e);
		}
	}

}
