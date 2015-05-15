package com.easymvc.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Enumeration;

/**
 * ResourceUtil
 * 
 * @author 唐延波
 * @date 2015-5-12
 * 
 */
public class ResourceUtil {

	public static InputStream getResourceAsStream(String name) {
		return Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(name);
	}

	public static URL getResource(String name) {
		return Thread.currentThread().getContextClassLoader().getResource(name);
	}
	
	/**
	 * 获取目录下的所有URL资源
	 * @author 唐延波
	 * @date 2015-5-13
	 * @param dir
	 * @return
	 * @throws IOException
	 */
	public static Enumeration<URL> getResources(String dir) throws IOException {
		Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(dir);
		return resources;
	}

	public static void close(OutputStream... outputStreams) {
		for (OutputStream outputStream : outputStreams) {
			if (outputStream != null) {
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void close(InputStream... inputStreams) {
		for (InputStream inputStream : inputStreams) {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
