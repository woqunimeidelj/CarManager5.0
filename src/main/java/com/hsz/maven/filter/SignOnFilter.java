package com.hsz.maven.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
	 * 1.nonProtectedUris 存贮不需要权限处理的URL
	 */
	private HashMap nonProtectedUris = new HashMap();

	/**
	 * 2.init方法在tomcat启动、程序加载时执行
	 */
	public void init(FilterConfig config) {
		this.config = config;
		
		// non-protected.uri  不需要过滤的请求，web-xml里配置
		String uri = config.getInitParameter("non-protected.uri");
		// 以，分割不过滤的每一个请求
		StringTokenizer tok = new StringTokenizer(uri, ",");
		
		while (tok.hasMoreTokens()) {
			String url = tok.nextToken();
			nonProtectedUris.put(url, url);
		}
	}
	

	/**
	 * 3.doFilter执行过滤 每次.do的URL请求时执行，与web.xml配置文件有关
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		String uri = req.getRequestURI(); // 获取uri地址
		
		if (uri.startsWith("/")) {//如果uri以/开头，则去掉/
			uri = uri.substring(1);
		}
		int i = uri.indexOf("/");//第一次出现/的下标

		if (i >= 0) {//假如uri包含/
			uri = uri.substring(i + 1);//从第一次出现/的后开始	切割
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

	// 过滤完成后执行销毁
	public void destroy() {
			
		nonProtectedUris.clear();
	}
	
	// 给用户赋予权限
	private boolean getPermission(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session == null) {
			return false;
		}
		// 登录成功将userId保存到session中
		String user_id = session.getAttribute("user_id").toString();
		String uri = request.getRequestURI();
		int lastSlashPos = uri.lastIndexOf("/");
		if (lastSlashPos==uri.length()-1) {//如果uri以/结尾，则去掉/
			uri = uri.substring(0,lastSlashPos);
		}
		String action="";
		int i=uri.lastIndexOf("/");//最后"/"的下标
		if(i >= 0){//uri包含"/"
			int j=uri.lastIndexOf("/",i);//取倒数第二个"/"下标
			if(j>=0){//假如存在第二"/"
				action=uri.substring(j);//以倒数第二个"/"切割		
				}
			action=uri.substring(i);//以倒数第一个"/"切割	
		}
		try {
			// 判断用户是否具有权限
			return UserManager.getInstance().getGroupPermission(user_id, action);
		} catch (Exception e) {
			return false;
		}
	}

	private boolean isNonProtected(String uri) {
		return (nonProtectedUris.get(uri) != null);
	}
	/**
	 * 将字符串切割为字符串List
	 * @param str
	 * @param delim
	 * @return
	 */
	private List<String> getListByString(String str, String delim){
		List<String> strLists=null;
		for(;;){
			int i=str.lastIndexOf(delim);
			if(i>=0){
				String item=str.substring(i);
				strLists.add(item);
			}else{
				break;
			}
		}	
		return strLists;	
	}
}