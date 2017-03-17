package com.hsz.maven.filter;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 过滤器工具类
 * @author scxh
 *
 */
public class SignOnFilter1 implements Filter {

	private FilterConfig config;
	
	// 存储不需要过滤的Url
	private HashMap nonProtectedUris = new HashMap();
	
	private boolean isNoprotected(String uri) {
	
		return (nonProtectedUris.get(uri) != null);

	}
	/**
	 * 1.初始化:init方法在tomcat启动、程序加载时执行
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.config = config;
		// non-protected.uri  不需要过滤的请求，web-xml里配置

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
	}

	@Override
	public void destroy() {
		
	}

}
