package com.song.jspservlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//创建Filter必须实现Filter接口：
//init:完成Filter的初始化
//doFilter:实现过滤功能，该方法就是对每个请求及响应增加的额外处理
//destroy:销毁Filter前，用于完成某些资源的回收

//Filter对用户请求进行预处理，接着将请求交给Servlet进行处理并生成响应，最后Filter再对服务器响应进行后处理
public class LogFilter implements Filter {

	private FilterConfig config;// 用于访问Filter的配置信息

	// 销毁方法
	@Override
	public void destroy() {
		this.config = null;
		System.out.println("--------LogFilter destroy方法--------");
	}

	// 过滤的核心方法
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException,
			ServletException {

		System.out.println("--------LogFilter doFilter方法--------");

		// 用于对用户请求进行预处理
		ServletContext context = this.config.getServletContext();// 获取ServletContext对象,用于记录日志
		long before = System.currentTimeMillis();

		System.out.println("Start Filter---");
		HttpServletRequest hrequest = (HttpServletRequest) arg0;// 转换为HttpServletRequest请求

		System.out.println("Filter已经截获到用户请求的地址:" + hrequest.getServletPath());// 输出提示信息

		arg2.doFilter(arg0, arg1);// Filter只是链式处理,请求依然放行到目的地址

		// 用于对服务器响应执行后处理
		long after = System.currentTimeMillis();
		System.out.println("--------LogFilter doFilter方法--------");
		System.out.println("过滤结束");
		System.out.println("请求被定位到:" + hrequest.getRequestURI() + " 所花的时间为: " + (after - before));
	}

	// 初始化方法 应用启动时会调用以完成Filter的初始化
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		this.config = arg0;
		System.out.println("--------LogFilter init方法--------");
	}

}
