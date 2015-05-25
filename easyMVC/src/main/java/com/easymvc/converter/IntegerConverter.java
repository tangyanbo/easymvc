package com.easymvc.converter;

import com.easymvc.exception.ConvertException;
import com.easymvc.util.StringUtil;

/**
 * IntegerConverter
 * @author 唐延波
 * @date 2015-5-19
 */
public class IntegerConverter implements Converter{
	
	@Override
	public Object convert(String param) {
		if(StringUtil.isEmpty(param)){
			return null;
		}
		try {
			Integer result = Integer.parseInt(param);
			return result;
		} catch (NumberFormatException e) {
			throw new ConvertException(e.getMessage(),e);
		}		
	}

}
