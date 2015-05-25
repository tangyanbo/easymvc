package com.easymvc.config;

import java.util.HashMap;
import java.util.Map;

/**
 * PathTree
 * 
 * @author 唐延波
 * @date 2015-5-21
 */
public class PathTree {

	/**
	 * 当前路径
	 */
	private String path;

	/**
	 * 是否叶子节点
	 */
	private boolean isLeaf;

	/**
	 * 子节点
	 */
	private Map<String, PathTree> children = new HashMap<String, PathTree>();

	/**
	 * ControllerMethod
	 */
	private ControllerMethod controllerMethod;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public Map<String, PathTree> getChildren() {
		return children;
	}

	public void setChildren(Map<String, PathTree> children) {
		this.children = children;
	}

	public ControllerMethod getControllerMethod() {
		return controllerMethod;
	}

	public void setControllerMethod(ControllerMethod controllerMethod) {
		this.controllerMethod = controllerMethod;
	}

}
