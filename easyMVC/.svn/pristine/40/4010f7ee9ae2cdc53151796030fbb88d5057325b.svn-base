package com.easymvc.ui;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 唐延波
 * @date 2015-5-14
 */
public class ModelMap extends LinkedHashMap<String, Object> implements Model{

	private static final long serialVersionUID = 5469789953645751041L;

	@Override
	public Model addAttribute(String attributeName, Object attributeValue) {
		put(attributeName, attributeValue);
		return this;
	}

	@Override
	public Map<String, Object> asMap() {
		return this;
	}

	

	
}
