package com.zoctan.api.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;


/**
 * 
 * String帮助类
 * 
 */
public class StringHelper extends org.springframework.util.StringUtils {
	private static Logger logger = LoggerFactory.getLogger(StringHelper.class);
	/**
	 * The empty String <code>""</code>.
	 */
	public static final String EMPTY = "";

	/**
	 * 
	 *  <对String的字符进行分隔>
	 *
	 *	@param str
	 *	@param SeparatorChar
	 *	@return
	 *		String
	 *	
	 *	@see
	 *
	 * 	@throws 
	 *		
	 *
	 */
	public static String separatorToString(String str, String SeparatorChar) {
		AssertUtils.notEmpty(str, "The str not should be empty or null!");
		AssertUtils.notEmpty(SeparatorChar, "The regex not should be empty or null!");

		StringBuffer bf = new StringBuffer();
		bf.append(SeparatorChar);

		for (int i = 0; i < str.length(); i++) {
			bf.append(str.substring(i, i + 1));
			bf.append(SeparatorChar);
		}
		//		bf.append(SeparatorChar);
		return bf.toString();
	}

	/**
	 * 将首字母大写
	 * 
	 * @param str
	 * @return String 返回首字母大写后的字符串
	 */
	public static String capitalize(String str) {
		if (StringHelper.hasLength(str)) {
			StringBuffer wrod = new StringBuffer();

			str = wrod.append(str.substring(0, 1).toUpperCase()).append(str.substring(1)).toString();
		}
		return str;
	}

	/**
	 * 将首字母小写
	 * 
	 * @param str
	 * @return String 返回首字母小写的字符串
	 */
	public static String firstLetterLowercase(String str) {
		if (StringHelper.hasLength(str)) {
			StringBuffer wrod = new StringBuffer();
			str = wrod.append(str.substring(0, 1).toLowerCase()).append(str.substring(1)).toString();
		}
		return str;
	}

	/**
	 * 
	 * 通过正则表达式检查某个字符串是否满足某种格式
	 * 
	 * @param str
	 *            - 字符串，不能为空或null
	 * @param regex
	 *            - 正则表达式，不能为空或null
	 * @return boolean 满足正则表达式规定格式时返回true
	 * @throw IllegalArgumentException 当str或regex为空时抛出。
	 */
	public static boolean rightFormat(String str, String regex) {
		AssertUtils.notEmpty(str, "The str not should be empty or null!");
		AssertUtils.notEmpty(regex, "The regex not should be empty or null!");

		Pattern pattern = Pattern.compile(regex);
		return pattern.matcher(str).matches();
	}

	/**
	 * @see StringUtils#isBlank(String)
	 */
	public static boolean isBlank(String str) {
		return StringUtils.isBlank(str);
	}

	/**
	 * @see StringUtils#isNotBlank(String)
	 */
	public static boolean isNotBlank(String str) {
		return StringUtils.isNotBlank(str);
	}

	/**
	 * @see StringUtils#trimToEmpty(String)
	 */
	public static String trimToEmpty(String str) {
		return StringUtils.trimToEmpty(str);
	}

	

	/**
	 * @see StringUtils#removeEndIgnoreCase(String, String)
	 * */
	public static String removeEndIgnoreCase(String str, String remove) {
		return StringUtils.removeEndIgnoreCase(str, remove);
	}

	/**
	 * @see StringUtils#removeEnd(String, String)
	 * */
	public static String removeEnd(String str, String remove) {
		return StringUtils.removeEnd(str, remove);
	}

	/**
	 * @see StringUtils#removeStart(String, String)
	 * */
	public static String removeStart(String str, String remove) {
		return StringUtils.removeStart(str, remove);
	}

	/**
	 * @see StringUtils#removeStartIgnoreCase(String, String)
	 * */
	public static String removeStartIgnoreCase(String str, String remove) {
		return StringUtils.removeStartIgnoreCase(str, remove);
	}

	/**
	 * @see StringUtils#remove(String, String)
	 * */
	public static String remove(String str, String remove) {
		return StringUtils.remove(str, remove);
	}

	/**
	 * @see StringUtils#endsWithIgnoreCase(String, String)
	 * */
	public static boolean equalsIgnoreCase(String str1, String str2) {
		return StringUtils.equalsIgnoreCase(str1, str2);
	}

	/**
	 * @see StringUtils#equals(String, String)
	 */
	public static boolean equals(String str1, String str2) {
		return StringUtils.equals(str1, str2);
	}

	/**
	 * @see StringUtils#indexOf(String, String)
	 * */
	public static int indexOf(String str, String searchStr) {
		return StringUtils.indexOf(str, searchStr);
	}

	
	/**
	 * @see StringUtils#defaultString(String)
	 * */
	public static String defaultString(String str) {
		return str == null ? EMPTY : str;
	}

	/**
	 * @see StringUtils#defaultString(String, String)
	 */
	public static String defaultString(String str, String defaultStr) {
		return str == null ? defaultStr : str;
	}

	/**
	 * @see StringUtils#defaultIfBlank(String, String)
	 */
	public static String defaultIfBlank(String str, String defaultStr) {
		return StringUtils.isBlank(str) ? defaultStr : str;
	}

	/**
	 * @see StringUtils#defaultIfEmpty(String, String)
	 */
	public static String defaultIfEmpty(String str, String defaultStr) {
		return StringUtils.isEmpty(str) ? defaultStr : str;
	}

	/**
	 * @see StringUtils#reverse(String)
	 */
	public static String reverse(String str) {
		if (str == null) {
			return null;
		}
		return new StrBuilder(str).reverse().toString();
	}

	public static void main(String args[]) {

	}
}
