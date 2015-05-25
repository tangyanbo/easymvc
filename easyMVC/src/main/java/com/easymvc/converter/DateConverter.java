package com.easymvc.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

import com.easymvc.exception.ConvertException;
import com.easymvc.util.StringUtil;

/**
 * DateConverter
 * @author 唐延波
 * @date 2015-5-19
 */
public class DateConverter implements Converter {	

	@Override
	public Object convert(final String param) {	
		if(StringUtil.isEmpty(param)){
			return null;
		}
		DateFormat f = DateFormat.getDateInstance();		
		try {
			Date date = f.parse(param);
			return date;
		} catch (ParseException e) {
			throw new ConvertException(e.getMessage(),e);
		}	
	}
}
