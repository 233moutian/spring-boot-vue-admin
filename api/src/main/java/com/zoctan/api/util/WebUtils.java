package com.zoctan.api.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * <对Page对像进行转换>
 *
 */
public class WebUtils extends org.springframework.web.util.WebUtils {

	private static Logger logger = LoggerFactory.getLogger(WebUtils.class);

	/**AJAX请求头的名称*/
	public static final String X_REQUESTED_WITH = "X-Requested-With";

	/**AJAX请求头对应的值*/
	public static final String XML_HTTPREQUEST = "XMLHttpRequest";

	/**也就是HTTP的请求端真实的IP， 只有在通过了HTTP代理或者负载均衡服务器时才会添加该项。它不是RFC中定义的标准请求头信息*/
	public static final String X_FORWARDED_FOR = "X-Forwarded-For";

	// nginx服务代理
	public static final String x_REAL_IP = "X-Real-IP";

	/**客户端使用代理时的IP地址 */
	public static final String PROXY_CLIENT_IP = "Proxy-Client-IP";

	/**客户端使用代理时的IP地址*/
	public static final String WL_PROXY_CLIENT_IP = "WL-Proxy-Client-IP";

	/**是代理服务器发送的HTTP头。如果是“超级匿名代理”，则返回none值。同样，REMOTE_ADDR也会被替换为这个代理服务器的IP。*/
	public static final String HTTP_CLIENT_IP = "HTTP_CLIENT_IP";

	/**客户端代理地址*/
	public static final String HTTP_X_FORWARDED_FOR = "HTTP_X_FORWARDED_FOR";

	/**
	 *  判断当前请求是否是AJAX请求
	 *  
	 *	@param request - 当前请求
	 *	@return boolean	是AJAX请求返回true
	 *	@throws IllegalArgumentException 当request为null时抛出
	 */
	public static boolean isAjaxRequest(HttpServletRequest request) {
		AssertUtils.notNull(request, "The http servlet request not should be null!");
		String header = request.getHeader(X_REQUESTED_WITH);
		return (StringHelper.isNotBlank(header) && XML_HTTPREQUEST.equals(header)) ? true : false;
	}

	/**
	 *  根据名称获取当前Servlet请求中的Attribute
	 *	
	 *	@param request	当前Servlet请求
	 *	@param name		名称
	 *	@return O  the value of the request attribute, or null if not found
	 * 	@throws IllegalArgumentException 当request为null时抛出
	 */
	@SuppressWarnings("unchecked")
	public static <O> O getRequestAttribute(HttpServletRequest request, String name) {
		Assert.notNull(request, "request not should be null when you get parameter");
		Object value = request.getAttribute(name);
		return (value != null) ? (O) value : null;
	}

	/**
	 * 	Set attribute到当前请求中，当value为null时，将会清除请求中的attribute
	 *
	 *	@param request - 当前请求
	 *	@param name - attribute的名称
	 *	@param value - attribute
	 * 	@throws IllegalArgumentException 当request为null时抛出
	 */
	public static void setRequestAttribute(HttpServletRequest request, String name, Object value) {
		Assert.notNull(request, "request not should be null when you get parameter");
		if (value != null) {
			request.setAttribute(name, value);
		} else if (request != null) {
			request.removeAttribute(name);
		}
	}

	/**
	 * 	获取SessionID
	 *
	 *	@param request - 当前请求
	 *	@return String the session id, or null if none
	 *	@throws IllegalArgumentException 当request为null时抛出
	 */
	public static String getSessionId(HttpServletRequest request) {
		Assert.notNull(request, "request not should be null when you get parameter");
		return WebUtils.getSessionId(request);
	}
/*

	*/
/**
	 * 	从Session中获得某个对象
	 *
	 *	@param request - 当前请求
	 *	@param name - 参数名
	 *	@return O 可能为null
	 *	@throws IllegalArgumentException 当request为null时抛出
	 *//*

	@SuppressWarnings("unchecked")
	public static <O> O getSessionAttribute(HttpServletRequest request, String name) {
		Assert.notNull(request, "request not should be null when you get parameter");
		Object object = request.getSession().getAttribute(name);
		return (object != null) ? (O) object : null;
	}
*/

	/**
	 * 
	 * 	Set一个对象到Session中 如果value为null, Session不为null,将会删除Session中的attribute。
	 *
	 *	@param request - 当前请求
	 *	@param name - 名称
	 *	@param value - 对象
	 *	@throws IllegalArgumentException 当request为null时抛出
	 */
	public static void setSessionAttribute(HttpServletRequest request, String name, Object value) {
		Assert.notNull(request, "request not should be null when you get parameter");
		WebUtils.setSessionAttribute(request, name, value);
	}

	/**
	 * 	删除Session中某个属性
	 *
	 *	@param request	当前请求
	 *	@param name		属性名称
	 * 	@throws IllegalArgumentException 当request为null时抛出
	 */
	public static void removeSessionAttribute(HttpServletRequest request, String name) {
		Assert.notNull(request, "request not should be null when you get parameter");
		HttpSession session = request.getSession();
		if (session != null) {
			session.removeAttribute(name);
		}
	}

	/**
	 * 	删除Session中的所有属性
	 * 
	 *	@param request	当前请求
	 *	@throws IllegalArgumentException 当request为null时抛出
	 */
	@SuppressWarnings("unchecked")
	public static void removeSessionAllAttribute(HttpServletRequest request) {
		Assert.notNull(request, "request not should be null when you get parameter");
		HttpSession session = request.getSession();
		if (session != null) {
			Enumeration<String> attributeNames = session.getAttributeNames();
			while (attributeNames.hasMoreElements()) {
				String attributeName = attributeNames.nextElement();
				session.removeAttribute(attributeName);
			}
		}
	}

	/**
	 * 
	 *  <描述这个方法的作用 >
	 *
	 *	@param
	 *	@return
	 *		Map<String,Object>
	 *	
	 *	@see
	 *
	 * 	@throws 
	 *		
	 *
	 */
	public static <T> Map<String, Object> ListToJson(List<T> source) {
		Map<String, Object> hs = new HashMap<String, Object>();
		hs.put("totalCount", source.size());
		hs.put("content", source);
		return hs;
	}



	/**
	 * 
	 *  <对page对像进行解析 >
	 *
	 *	@param page
	 *	@return
	 *		Map<String,Object>
	 *	
	 *	@see
	 *
	 * 	@throws 
	 *		
	 *
	 */
	public static <T> Map<String, Object> PageToJson(Page<T> page) {
		Map<String, Object> hs = new HashMap<String, Object>();
		//总纪录行数
		hs.put("totalRows", page.getTotalPages());
		hs.put("page", page.getNumber());
		hs.put("size", page.getSize());
	
		Map<String, Object> hst = new HashMap<String, Object>();
		hst.put("jsonRst",hs);
		return hst;
	}

	/**
	 * 
	 *  <获取Request中的数据 >
	 *
	 *	@param request
	 *	@param paramName
	 *	@param defaultValue
	 *	@return
	 *		String
	 *	
	 *	@see
	 *
	 * 	@throws 
	 *		
	 *
	 */
	public static String getDefParam(HttpServletRequest request, String paramName, String defaultValue) {

		if (request.getParameter(paramName) != null) {
			return request.getParameter(paramName);
		}
		return defaultValue;
	}

	/**
	 * 
	 *  <获取Request中的Integer的数据 >
	 *
	 *	@param request
	 *	@param paramName
	 *	@param defaultValue
	 *	@return
	 *		Integer
	 *	
	 *	@see
	 *
	 * 	@throws 
	 *		
	 *
	 */
	public static Integer getDefParam(HttpServletRequest request, String paramName, Integer defaultValue) {
		if (request.getParameter(paramName) != null) {
			return Integer.valueOf(request.getParameter(paramName));
		}
		return defaultValue;
	}

	//	public static
	/**
					 * 
					 *  <获取EXTJS的默认分页 >
					 *
					 *	@param request
					 *	@return
					 *		Pageable
					 *	
					 *	@see
					 *
					 * 	@throws 
					 *		
					 *
					 */
	public static Pageable getExtPageable(HttpServletRequest request) {
		int limit = getDefParam(request, "size", 10);
		//当前页数
		int page =getDefParam(request, "page", 1);
		//分页的排序字段
		String sort_File = getDefParam(request, "sort", "id");
		//分页的排序方式
		String direction = getDefParam(request, "dir", "ASC");

		return new PageRequest((page - 1), limit, new Sort(direction.equalsIgnoreCase("asc") ? Direction.ASC
				: Direction.DESC, sort_File));
	}
	
	public static Pageable getExtPageable(HttpServletRequest request, String sortfile, String sort) {
		int limit = getDefParam(request, "size", 10);
		//当前页数
		int page =getDefParam(request, "page", 1);
		//分页的排序字段
		String sort_File = getDefParam(request, "sort", sortfile);
		//分页的排序方式
		String direction = getDefParam(request, "dir", sort);

		return new PageRequest((page - 1), limit, new Sort(direction.equalsIgnoreCase("asc") ? Direction.ASC
				: Direction.DESC, sort_File));
	}
	
	/**
	 * 得到当前客户的IP地址
	 * @param request
	 * @return
	 */
	public static String getRemoteIp(HttpServletRequest request)
	{
		String ip = null;

		//X-Forwarded-For：Squid 服务代理
		String ipAddresses = request.getHeader(X_FORWARDED_FOR);

		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			//Proxy-Client-IP：apache 服务代理
			ipAddresses = request.getHeader(PROXY_CLIENT_IP);
		}

		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			//WL-Proxy-Client-IP：weblogic 服务代理
			ipAddresses = request.getHeader(WL_PROXY_CLIENT_IP);
		}

		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			//HTTP_CLIENT_IP：有些代理服务器
			ipAddresses = request.getHeader(HTTP_CLIENT_IP);
		}

		if (ipAddresses == null || ipAddresses.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			//X-Real-IP：nginx服务代理
			ipAddresses = request.getHeader(x_REAL_IP);
		}

		//有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
		if (ipAddresses != null && ipAddresses.length() != 0) {
			ip = ipAddresses.split(",")[0];
		}

		//还是不能获取到，最后再通过request.getRemoteAddr();获取
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ipAddresses)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
	/**
	 * 
	 *  <描述这个方法的作用 >
	 *
	 *	@param request
	 *	@param fromBeanClass
	 *	@return
	 *		Object
	 *	
	 *	@see
	 *
	 * 	@throws 
	 *		
	 *
	 */
	public static Object getVoFromRequest(HttpServletRequest request, Class<?> fromBeanClass) {
		fromBeanClass.getMethods();
		return null;
	}

}
