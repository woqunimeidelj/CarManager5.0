package com.hsz.maven.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignOnFilter implements Filter {
	private FilterConfig config;

	/**
	 * nonProtectedUris 存贮不需要权限处理的URL
	 */
	private HashMap nonProtectedUris = new HashMap();

	/**
	 * init方法在tomcat启动、程序加载时执行
	 */
	public void init(FilterConfig config) {
		this.config = config;
		String uri = config.getInitParameter("non-protected.uri");
		StringTokenizer tok = new StringTokenizer(uri, ",");

		while (tok.hasMoreTokens()) {
			String url = tok.nextToken();
			nonProtectedUris.put(url, url);
		}
	}

	/**
	 * doFilter 每次.jspa的URL请求时执行，与web.xml配置文件有关
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		if (uri.startsWith("/")) {
			uri = uri.substring(1);
		}
		int i = uri.indexOf("/");

		if (i >= 0) {
			uri = uri.substring(i + 1);
		}

		if (!isNonProtected(uri)) // 如果配置文件属性non-protected.uri（不处理uri地址）中不包含请求uri,则执行下面判继
		{
			if (!getPermission(req)) // 权限不够时执行
			{
				config.getServletContext().getRequestDispatcher("权限不够.jsp").forward(request, response);
				return;
			}
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
		nonProtectedUris.clear();
	}

	private boolean getPermission(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session == null) {
			return false;
		}
		//登录成功将userId保存到session中
		String user_id = session.getAttribute("user_id").toString();
		String uri = request.getRequestURI();
		int lastSlashPos = uri.lastIndexOf("/");
		String action = uri.substring(lastSlashPos + 1);

		try {
			return UserManager.getInstance().getGroupPermission(user_id, action);
		} catch (Exception e) {
			return false;
		}
	}

	private boolean isNonProtected(String uri) {
		return (nonProtectedUris.get(uri) != null);
	}

}