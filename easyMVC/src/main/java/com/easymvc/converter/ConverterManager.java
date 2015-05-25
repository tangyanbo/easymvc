package com.easymvc.converter;

import java.util.ArrayList;
import java.util.List;

import com.easymvc.exception.DataTypeNotSupportException;

/**
 * @author 唐延波
 * @date 2015-5-19
 */
public class ConverterManager {
	
	private static final ConverterManager converterManager = new ConverterManager();
	
	public static ConverterManager getInstance(){
		return converterManager;
	} 
	

	/**
	 * 使用策略模式
	 * 类型转换
	 * @author 唐延波
	 * @date 2015-5-19
	 * @param param
	 * @param type
	 * @return
	 */
	public Object convert(String params,Class<?> type){
		if(type.getName().equals("java.lang.Long")
				||type.getName().equals("long")){
			LongConverter converter = new LongConverter();
			return converter.convert(params);
		}else if(type.getName().equals("java.lang.String")){
			StringConverter converter = new StringConverter();
			return converter.convert(params);
		}else if(type.getName().equals("java.lang.Integer")
				||type.getName().equals("int")){
			IntegerConverter converter = new IntegerConverter();
			return converter.convert(params);
		}else if(type.getName().equals("java.util.Date")){
			DateConverter converter = new DateConverter();
			return converter.convert(params);
		}else if(type.getName().equals("java.lang.Double")||
				type.getName().equals("double")){
			DoubleConverter convert = new DoubleConverter();
			return convert.convert(params);
		}else if(type.getName().equals("java.lang.Short")||
				type.getName().equals("short")){
			ShortConverter convert = new ShortConverter();
			return convert.convert(params);
		}else if(type.getName().equals("char")||
				type.getName().equals("java.lang.Character")){
			CharConverter convert = new CharConverter();
			return convert.convert(params);
		}
		else{
			throw new DataTypeNotSupportException("不支持的类型:"+type.getName());
		}
	}
	
	public static void main(String[] args) {
		String[] aa = new String[10];
		List<String> bb = new ArrayList<String>();
		
	}
}
