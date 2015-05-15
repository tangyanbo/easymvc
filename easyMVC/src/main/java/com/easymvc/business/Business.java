package com.easymvc.business;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.easymvc.beans.BeanFactory;
import com.easymvc.config.ConfigManager;
import com.easymvc.config.ControllerMethod;
import com.easymvc.ui.ModelMap;

/**
 * @author 唐延波
 * @date 2015-5-12
 * 
 */
public class Business {
	
	private static final String MODEL = "com.easymvc.ui.Model";
	
	private static final String REQUEST = "javax.servlet.http.HttpServletRequest";
	
	private static final String RESPONSE = "javax.servlet.http.HttpServletResponse";

	private static Logger log = LoggerFactory.getLogger(Business.class);

	private HttpServletRequest request;

	private HttpServletResponse response;
	
	/**
	 * 请求的servletPath
	 */
	private String servletPath;
	
	/**
	 * 请求的参数
	 */
	private Map<String, String[]> parameterMap;
		
	/**
	 * 请求对应的controller
	 */
	private Object controller;
	
	/**
	 * 请求对应的method
	 */
	private Method method;

	public Business(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
		servletPath = request.getServletPath();
		this.init();
	}
	
	/**
	 * 初始化
	 * @author 唐延波
	 * @date 2015-5-13
	 */
	private void init(){		
		try {
			//设置编码
			String charsetEncoding = ConfigManager.getInstance().getConstant("charsetEncoding");
			request.setCharacterEncoding(charsetEncoding);
			//获取客户端传的参数
			parameterMap = request.getParameterMap();
			//根据请求的url获取controllerMethod
			ControllerMethod controllerMethod = BeanFactory.getInstance()
					.getBean(servletPath, ControllerMethod.class);
			controller = controllerMethod.getController();
			method = controllerMethod.getMethod();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	

	/**
	 * 入口
	 * @author 唐延波
	 * @date 2015-5-14
	 */
	public void process() {
		try {
			ClassObjectEntry customerParamEntry = null;
			ClassObjectEntry modelEntry = null;
			// 将客户端参数设置到controller接收参数对象里面去
			Class<?>[] parameterTypes = method.getParameterTypes();
			//参数对象数组
			Object[] args = new Object[parameterTypes.length];
			for(int i=0;i<parameterTypes.length;i++){
				Class<?> parameterType = parameterTypes[i];
				if(parameterType.getName().equals(MODEL)){
					//设置model
					modelEntry = new ClassObjectEntry(); 
					modelEntry.setClassType(parameterType);
					modelEntry.setObject(ModelMap.class.newInstance());		
					args[i] = modelEntry.getObject();
				}else if(parameterType.getName().equals(REQUEST)){
					args[i] = this.request;
				}else if(parameterType.getName().equals(RESPONSE)){
					args[i] = this.response;
				}else{		
					Object paramObj = parameterType.newInstance();
					customerParamEntry = new ClassObjectEntry();
					customerParamEntry.setClassType(parameterType);
					customerParamEntry.setObject(paramObj);
					paramObj = wrapParameters(customerParamEntry);
					args[i] = paramObj;
				}
			}
			Object returnObj = method.invoke(controller, args);
			setAttribute(modelEntry);
			forward(returnObj);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 设置对象到request中
	 * @author 唐延波
	 * @date 2015-5-14
	 * @param paramType
	 * @param paramObj
	 * @return
	 * @throws Exception
	 */
	private void setAttribute(ClassObjectEntry modelEntry)
			throws Exception {
		Class<?> paramType = modelEntry.getClassType();
		Object paramObj = modelEntry.getObject();
		Method method = paramType.getMethod("asMap");
		Map<String, Object> map = (Map<String, Object>) method.invoke(paramObj);
		for(String key : map.keySet()){
			Object value = map.get(key);
			request.setAttribute(key, value);
		}
	}
	
	/**
	 * 渲染jsp
	 * @author 唐延波
	 * @date 2015-5-14
	 * @param returnObj
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void forward(Object returnObj) throws ServletException, IOException{
		if(returnObj instanceof String){
			String forward = (String)returnObj;
			forward += ".jsp";
			request.getRequestDispatcher(forward).forward(request, response);
		}
	}

	/**
	 * 将客户端参数设置到controller接收参数对象里面去
	 * @author 唐延波
	 * @date 2015-5-13
	 * @param method
	 * @throws Exception
	 */
	private Object wrapParameters(ClassObjectEntry customerParamEntry) throws Exception {
		Class<?> paramType = customerParamEntry.getClassType();
		Object paramObj = customerParamEntry.getObject();
		//自定义对象参数对象
		Method[] methods = paramType.getMethods();
		for(Method meth : methods){
			String fullName = meth.getName();
			if(fullName.startsWith("set")){				
				String key = fullName.replace("set", "");
				String firstLetter = key.substring(0,1);
				String leftStr = key.substring(1);
				String firstLetterLower = firstLetter.toLowerCase();
				String fileName = firstLetterLower + leftStr;
				String[] values = parameterMap.get(fileName);
				if(values != null){
					meth.invoke(paramObj, values);
				}				
			}
		}
		return paramObj;
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> class1 = Class.forName("com.easymvc.ui.Model");
		Class<?> declaringClass = class1.getDeclaringClass();
		System.out.println(class1.getName());
	}

}
