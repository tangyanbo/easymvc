package com.easymvc.business;

import java.lang.reflect.Method;

/**
 * method entry
 * @author 唐延波
 * @date 2015-5-19
 */
public class MethodEntry {

	/**
	 * Method所属对象
	 */
	private Object ownerObj;

	/**
	 * method
	 */
	private Method method;

	public Object getOwnerObj() {
		return ownerObj;
	}

	public void setOwnerObj(Object ownerObj) {
		this.ownerObj = ownerObj;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

}
