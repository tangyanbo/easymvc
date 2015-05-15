package com.easymvc.util;

import java.io.File;
import java.io.InputStream;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * XMLUtil
 * @author 唐延波
 * @date 2015-5-12
 *
 */
public class XMLUtil {

	public static Document getDocument(InputStream xmlIs)
			throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(xmlIs);
		return document;
	}

	public static Document getDocument(String xml)
			throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(ResourceUtil.getResourceAsStream(xml));
		return document;
	}
	
	public static Document getDocument(File file) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		return document;
	}
	
	public static String getAttrValue(String enumerationName,Element element){
		Attribute attr = element.attribute(enumerationName);
		return attr.getValue();
	}

}
