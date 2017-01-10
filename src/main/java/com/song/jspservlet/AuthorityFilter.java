package com.song.jspservlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthorityFilter implements Filter {

	private FilterConfig config;

	@Override
	public void destroy() {
		this.config = null;
		System.out.println("--------AuthorityFilter destroy方法--------");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
			ServletException {

		System.out.println("--------AuthorityFilter doFilter方法--------");

		// 获取Filter的配置参数
		String encoding = config.getInitParameter("encoding");
		String loginPage = config.getInitParameter("loginPage");
		String proLogin = config.getInitParameter("proLogin");

		// 设置request编码用的字符集
		arg0.setCharacterEncoding(encoding);
		HttpServletRequest requ = (HttpServletRequest) arg0;
		HttpSession session = requ.getSession(true);

		// 获取客户请求的页面
		String requestPath = requ.getServletPath();

		if (session.getAttribute("user") == null && !requestPath.endsWith(loginPage) && !requestPath.endsWith(proLogin)) {
			// forward到登录界面
			arg0.setAttribute("tip", "您还没有登录");
			arg0.getRequestDispatcher(loginPage).forward(arg0, arg1);
		}
		else {
			// 放行请求
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
		System.out.println("--------AuthorityFilter init方法--------");
	}

}
