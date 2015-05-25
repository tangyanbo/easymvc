package com.easymvc.business;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.easymvc.config.ControllerMethod;

/**
 * ControllerMethodBean
 * 
 * @author 唐延波
 * @date 2015-5-22
 */
public class ControllerMethodBean {

	private Object[] args;

	private ClassObjectEntry modelEntry;

	private Map<String, Object> pathVariableMap = new HashMap<String, Object>();

	private ControllerMethod controllerMethod;
	
	public Object getController() {
		return controllerMethod.getController();
	}
	
	public Method getMethod() {
		return controllerMethod.getMethod();
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	public ClassObjectEntry getModelEntry() {
		return modelEntry;
	}

	public void setModelEntry(ClassObjectEntry modelEntry) {
		this.modelEntry = modelEntry;
	}

	public Map<String, Object> getPathVariableMap() {
		return pathVariableMap;
	}

	public void setPathVariableMap(Map<String, Object> pathVariableMap) {
		this.pathVariableMap = pathVariableMap;
	}

	public ControllerMethod getControllerMethod() {
		return controllerMethod;
	}

	public void setControllerMethod(ControllerMethod controllerMethod) {
		this.controllerMethod = controllerMethod;
	}

}
