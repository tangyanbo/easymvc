package com.easymvc.business;

import java.util.HashMap;
import java.util.Map;

/**
 * ObjTree
 * 
 * @author 唐延波
 * @date 2015-5-19
 */
public class ObjTree {

	/**
	 * 父亲节点
	 */
	private Object parent;

	/**
	 * 自身
	 */
	private Object self;

	/**
	 * 自定义对象属性集合
	 */
	private Map<String, ObjTree> fields = new HashMap<String, ObjTree>();

	/**
	 * set方法集合
	 */
	private Map<String, MethodEntry> setMethodMap = new HashMap<String, MethodEntry>();

	/**
	 * get方法集合
	 */
	private Map<String, MethodEntry> getMethodMap = new HashMap<String, MethodEntry>();

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

	public Object getSelf() {
		return self;
	}

	public void setSelf(Object self) {
		this.self = self;
	}

	public Map<String, MethodEntry> getSetMethodMap() {
		return setMethodMap;
	}

	public void setSetMethodMap(Map<String, MethodEntry> setMethodMap) {
		this.setMethodMap = setMethodMap;
	}

	public Map<String, MethodEntry> getGetMethodMap() {
		return getMethodMap;
	}

	public void setGetMethodMap(Map<String, MethodEntry> getMethodMap) {
		this.getMethodMap = getMethodMap;
	}

	public Map<String, ObjTree> getFields() {
		return fields;
	}

	public void setFields(Map<String, ObjTree> fields) {
		this.fields = fields;
	}

}
