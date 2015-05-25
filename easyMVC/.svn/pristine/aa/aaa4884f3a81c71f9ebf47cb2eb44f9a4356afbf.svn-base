package com.easymvc.config;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.easymvc.annotation.RequestMapping;
import com.easymvc.beans.BeanFactory;
import com.easymvc.exception.ConfigInitException;
import com.easymvc.util.ResourceUtil;
import com.easymvc.util.XMLUtil;

/**
 * 
 * 配置管理器
 * ControllerMap
 * @author 唐延波
 * @date 2015-5-12
 */
public class ConfigManager {
	
	private static Logger log = LoggerFactory.getLogger(ConfigManager.class);
	
	private static final ConfigManager configManager = new ConfigManager();
	
	private final Map<String,String> constantMap = new HashMap<String,String>();
	
	private static final String MVC_SERVLET_FILE = "mvc-servlet.xml";
	
	private Set<Class<?>> classSet = new HashSet<Class<?>>();
	
	private ConfigManager(){
		
	}
	
	/**
	 * 获取常量
	 * @author 唐延波
	 * @date 2015-5-15
	 * @param key
	 * @return
	 */
	public String getConstant(String key){
		return constantMap.get(key);
	}
	
	/**
	 * 容器初始化
	 * @author 唐延波
	 * @date 2015-5-15
	 */
	public void init(){
		try {
			initConfig();
			initControllerMap();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 获取自身实例
	 * @author 唐延波
	 * @date 2015-5-13
	 * @return
	 */
	public static ConfigManager getInstance(){
		return configManager;
	}
	
	/**
	 * 初始化配置
	 * @author 唐延波
	 * @date 2015-5-13
	 */
	private void initConfig(){
		try {
			Document document = XMLUtil.getDocument(MVC_SERVLET_FILE);
			Element root = document.getRootElement();			
			scanControllerAnnotation(root);	
			initConstants(root);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new ConfigInitException("扫描@Controller注解失败",e);
		}
	}
	
	/**
	 * 初始化常量配置
	 * @author 唐延波
	 * @date 2015-5-15
	 */
	@SuppressWarnings("unchecked")
	private void initConstants(Element root){
		List<Element> elements = root.elements("constant");
		for(Element element : elements){
			String name = element.attributeValue("name");
			String value = element.getText();
			constantMap.put(name, value);
		}
	}
	
	/**
	 * 完成注解Controller的类加载
	 * @author 唐延波
	 * @throws Exception 
	 * @date 2015-5-15
	 */
	@SuppressWarnings("unchecked")
	private void scanControllerAnnotation(Element root) throws Exception{
		List<Element> elements = root.elements("scan");
		for(Element element : elements){
			String basePackage = element.attributeValue("base-package");
			String basePackagePath = basePackage.replace(".", "/");
			basePackagePath += "/";
			URL url = ResourceUtil.getResource(basePackagePath);
			String filePath = URLDecoder.decode(url.getFile(), "UTF-8"); 
			File packageDir = new File(filePath);
			File[] files = packageDir.listFiles();
			for(File file : files){
				//java类文件 去掉后面的.class 只留下类名  
                String className = file.getName().substring(0,file.getName().length() - 6);
                Class<?> classObj = Thread.currentThread().getContextClassLoader().loadClass(basePackage + "." + className);	               
                classSet.add(classObj);
			}
		}
	}
	
	/**
	 * mvc-servlet.xml文件初始化
	 * @author 唐延波
	 * @date 2015-5-12
	 */
	private void initControllerMap() {
		try {
			for (Class<?> classObj : classSet) {
				Method[] methods = classObj.getMethods();
				Object controller = classObj.newInstance();
				for(Method method : methods){
					RequestMapping annotation = method.getAnnotation(RequestMapping.class);
					if(annotation == null){
						continue;
					}
					String name = annotation.value()[0];					
					ControllerMethod controllerMethod = new ControllerMethod();
					controllerMethod.setName(name);
					controllerMethod.setMethod(method);
					controllerMethod.setController(controller);
					BeanFactory.getInstance().putBean(name, controllerMethod);
				}				
			}

		} catch (Exception e) {
			throw new ConfigInitException("初始化mvc-servlet文件失败", e);
		}
	}
	
	public static void main(String[] args) {
		ConfigManager.getInstance().init();	
		Map<String, Object> beanMap = BeanFactory.getInstance().beanMap;
		for(String key : beanMap.keySet()){
			Object value = beanMap.get(key);
			System.out.println(key);
			System.out.println(value);
		}
		
	}
}
