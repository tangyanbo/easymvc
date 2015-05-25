package com.easymvc.beans;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanFactory
 * 存放所有的单例controller
 * @author 唐延波
 * @date 2015-5-13
 */
public class BeanFactory {	

	private static BeanFactory beanFactory = new BeanFactory();
	
	public Map<String,Object> beanMap = new HashMap<String,Object>();
	
	private BeanFactory(){}
	
	public static BeanFactory getInstance(){
		return beanFactory;
	}
	
	public void putBean(String beanName,Object bean){
		beanMap.put(beanName, bean);
	}
	
	public <Bean> Bean getBean(String beanName,Class<Bean> beanClass){
		return (Bean)beanMap.get(beanName);
	}
}
