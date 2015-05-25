package com.easymvc.util;

/**
 * StringUtil
 * @author 唐延波
 * @date 2015-5-20
 */
public class StringUtil {

	/**
	 * 判断数组是否为空
	 * {null}或{""}皆返回true
	 * @author 唐延波
	 * @date 2015-5-20
	 * @param args
	 * @return
	 */
	public static boolean isEmpty(String[] args){
		if(args == null){
			return true;
		}
		if(args.length == 1){
			if(args[0]==null||args[0].equals("")){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 判断字符串是否为空
	 * null或""皆为空
	 * @author 唐延波
	 * @date 2015-5-21
	 * @param args
	 * @return
	 */
	public static boolean isEmpty(String args){
		if(args == null){
			return true;
		}
		return args.isEmpty();
	}
	
	public static void main(String[] args) {
		String[] a = {null};
		System.out.println(StringUtil.isEmpty(a));
	}
}
