package com.zoctan.api.util;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Collection;
import java.util.Map;

/**
 * 入参检查工具类
 * 主要增加如下功能：
 * <p>
 * <ul>
 * <li>1. 修改类名, 避免与{@link org.springframework.util.Assert}冲突；</li>
 * <li>2. 可抛出指定的{@link RuntimeException}异常类，而不仅只是通用的{@link IllegalArgumentException}</li>
 * </ul>
 * </p>
 */
public abstract class AssertUtils extends Assert {

	/**
	 * 断言布尔表达式为真
	 * 
	 * <pre class="code">
	 * Assert.isTrue(i &gt; 0, &quot;The value must be greater than zero&quot;);
	 * </pre>
	 * 
	 * @param expression
	 *            a boolean expression
	 * @param throwIfAssertFail
	 *            the exception to use if the assertion fails
	 * @throws RuntimeException
	 *             if expression is <code>false</code>
	 */
	public static void isTrue(boolean expression, RuntimeException throwIfAssertFail) {
		if (!expression) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 断言对象为Null
	 * 
	 * <pre class="code">
	 * Assert.isNull(value, runtimeException);
	 * </pre>
	 * 
	 * @param object
	 *            the object to check
	 * @param throwIfAssertFail
	 *            the exception to use if the assertion fails
	 * @throws RuntimeException
	 *             if the given object is not <code>null</code>
	 */
	public static void isNull(Object object, RuntimeException throwIfAssertFail) {
		if (object != null) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 断言对象不为Null
	 * 
	 * <pre class="code">
	 * Assert.notNull(value, runtimeException);
	 * </pre>
	 * 
	 * @param object
	 *            the object to check
	 * @param throwIfAssertFail
	 *            the exception to use if the assertion fails
	 * @throws RuntimeException
	 *             if the given object is <code>null</code>
	 */
	public static void notNull(Object object, RuntimeException throwIfAssertFail) {
		if (object == null) {
			throw throwIfAssertFail;
		}
	}

	// ------------------字符串相关的操作
	/**
	 * 断言字符串既不为Null也不是空字符串
	 * 
	 * <pre class="code">
	 * Assert.hasLength(name, runtimeException);
	 * </pre>
	 * 
	 * @param text
	 *            the String to check
	 * @param throwIfAssertFail
	 *            the exception to use if the assertion fails
	 * @throws RuntimeException
	 *             if the given string is <code>null</code> or is empty
	 * @see StringUtils#hasLength
	 */
	public static void hasLength(String text, RuntimeException throwIfAssertFail) {
		if (!StringUtils.hasLength(text)) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 断言字符串既不为Null并且有非空格的字符
	 * 
	 * <pre class="code">
	 * Assert.hasText(name, runtimeException);
	 * </pre>
	 * 
	 * @param text
	 *            the String to check
	 * @param throwIfAssertFail
	 *            the exception to use if the assertion fails
	 * @throws RuntimeException
	 *             if the given String is <code>null</code> or only contain non-whitespace character
	 * @see StringUtils#hasText
	 */
	public static void hasText(String text, RuntimeException throwIfAssertFail) {
		if (!StringUtils.hasText(text)) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 断言字符串里不包含某子字符串
	 * 
	 * <pre class="code">
	 * Assert.doesNotContain(name, &quot;rod&quot;, runimeException);
	 * </pre>
	 * 
	 * @param textToSearch
	 *            the text to search
	 * @param substring
	 *            the substring to find within the text
	 * @param throwIfAssertFail
	 *            the exception to use if the assertion fails
	 * @throws RuntimeException
	 *             if the given text does contain the given substring
	 * @see StringUtils#hasLength(String)
	 */
	public static void doesNotContain(String textToSearch, String substring, RuntimeException throwIfAssertFail) {
		if (StringUtils.hasLength(textToSearch) && StringUtils.hasLength(substring)
				&& textToSearch.indexOf(substring) != -1) {
			throw throwIfAssertFail;
		}
	}

	// ------------------数组相关的操作

	/**
	 * 断言数组里不包含Null元素
	 * 请注意：如果数组为Null，那将不作判断
	 * 
	 * <pre class="code">
	 * Assert.noNullElements(array, &quot;The array must have non-null elements&quot;);
	 * </pre>
	 * 
	 * @param array
	 *            the array to check
	 * @param throwIfAssertFail
	 *            the exception to use if the assertion fails
	 * @throws RuntimeException
	 *             if the object array contains a <code>null</code> element
	 */
	public static void noNullElements(Object[] array, RuntimeException throwIfAssertFail) {
		if (array != null) {
			for (Object element : array) {
				if (element == null) {
					throw throwIfAssertFail;
				}
			}
		}
	}

	/**
	 * 断言数组既不为Null并且至少有一个元素
	 * 
	 * <pre class="code">
	 * Assert.notEmpty(array, runtimeException);
	 * </pre>
	 * 
	 * @param array
	 *            the array to check
	 * @param throwIfAssertFail
	 *            the exception to use if the assertion fails
	 * @throws RuntimeException
	 *             if the object array is <code>null</code> or has no elements
	 * @see ObjectUtils#isEmpty(Object[])
	 */
	public static void notEmpty(Object[] array, RuntimeException throwIfAssertFail) {
		if (ObjectUtils.isEmpty(array)) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 
	 * 	判断字符串不能为空或null
	 *
	 *	@param str		字符串
	 *	@param message	字符串为空时的信息
	 *
	 * 	@throws 
	 *		IllegalArgumentException	字符串为空或null时抛出
	 *
	 * 	@log
	 *		<YYYY-MM-DD			变更者		变更内容>
	 *		2011-7-13			 唐竹			创建
	 */
	public static void notEmpty(String str, String message) {
		if (!StringHelper.hasLength(str)) {
			throw new IllegalArgumentException(message);
		}
	}

	// ------------------集合相关的操作

	/**
	 * 断言集合既不为Null并且至少有一个元素
	 * 
	 * <pre class="code">
	 * Assert.notEmpty(collection, &quot;Collection must have elements&quot;);
	 * </pre>
	 * 
	 * @param collection
	 *            the collection to check
	 * @param throwIfAssertFail
	 *            the exception to use if the assertion fails
	 * @throws RuntimeException
	 *             if the collection is <code>null</code> or has no elements
	 * @see CollectionUtils#isEmpty(Collection)
	 */
	public static void notEmpty(Collection<?> collection, RuntimeException throwIfAssertFail) {
		if (CollectionUtils.isEmpty(collection)) {
			throw throwIfAssertFail;
		}
	}

	// ------------------Map相关的操作

	/**
	 * 断言Map既不为Null并且至少有一个实体
	 * 
	 * <pre class="code">
	 * Assert.notEmpty(map, runtimeException);
	 * </pre>
	 * 
	 * @param map
	 *            the map to check
	 * @param throwIfAssertFail
	 *            the exception to use if the assertion fails
	 * @throws RuntimeException
	 *             if the map is <code>null</code> or has no entries
	 * @see CollectionUtils#isEmpty(Map)
	 */
	public static void notEmpty(Map<?, ?> map, RuntimeException throwIfAssertFail) {
		if (CollectionUtils.isEmpty(map)) {
			throw throwIfAssertFail;
		}
	}

	// ------------------类型信息相关的操作

	/**
	 * 断言指定的对象是某个类的一个实例
	 * 
	 * <pre class="code">
	 * Assert.instanceOf(Foo.class, foo, runtimeException);
	 * </pre>
	 * 
	 * @param clazz
	 *            the required class
	 * @param obj
	 *            the object to check
	 * @param throwIfAssertFail
	 *            the exception to use if the assertion fails
	 * @throws RuntimeException
	 *             if the object is not an instance of clazz
	 * @see Class#isInstance
	 */
	public static void isInstanceOf(Class<?> clazz, Object obj, RuntimeException throwIfAssertFail) {
		notNull(clazz, "clazz to check against must not be null");
		if (!clazz.isInstance(obj)) {
			throw throwIfAssertFail;
		}
	}

	/**
	 * 断言类之间的继承关系
	 * 
	 * <pre class="code">
	 * Assert.isAssignable(Number.class, myClass, runtimeException);
	 * </pre>
	 * 
	 * @param superType
	 *            the super type to check against
	 * @param subType
	 *            the sub type to check
	 * @param throwIfAssertFail
	 *            the exception to use if the assertion fails
	 * @throws RuntimeException
	 *             if the classes are not assignable
	 * @see Class#isAssignableFrom(Class)
	 */
	public static void isAssignable(Class<?> superType, Class<?> subType, RuntimeException throwIfAssertFail) {
		notNull(superType, "Type to check against must not be null");
		if (subType == null || !superType.isAssignableFrom(subType)) {
			throw throwIfAssertFail;
		}
	}
}
