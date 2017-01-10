package com.song.jspservlet;

import java.io.PrintStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//如果JSP页面第一次收到请求，先编译JSP文件，生成对应的Servlet；如果该JSP页面已有对应的Servlet，则根据请求动态生成标准的HTML页面，每次都会根据请求动态生成HTML文档
//JSP必须生成Servlet才能执行；每个JSP页面的第一个访问者较慢，因为必须等待JSP编译成Servlet；JSP页面输送到客户端的是标准HTML页面

//在标准的MVC模式中，Servlet仅作为控制器使用，对于遵循MVC模式的Java EE应用而言，JSP仅作为表现层技术
//所有用户请求都发送给Servlet，Servlet调用Model来处理用户请求，并调用JSP来呈现处理结果；或者Servlet直接调用JSP将应用的状态数据呈现给用户

//Servlet通常称为服务器端小程序，是运行在服务器端的程序，用于处理及响应客户端的请求;Servlet对于所有请求的响应都是完全一样的，只需重写service方法即可响应客户端的所有请求

//Servlet必须继承HttpServlet类
@SuppressWarnings("serial")
public class FirstServlet extends HttpServlet {

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("--------FirstServlet destroy方法--------");
	}

	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("--------FirstServlet init方法--------");
	}

	// 客户端的响应方法，使用该方法可以响应客户端所有类型的请求
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		System.out.println("--------FirstServlet service方法--------");
		// 设置解码方式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charSet=UTF-8");
		// 获取name的请求参数值
		String name = request.getParameter("name");
		// 获取gender的请求参数值
		String gender = request.getParameter("gender");
		// 获取color的请求参数值
		String[] color = request.getParameterValues("color");
		// 获取country的请求参数值
		String national = request.getParameter("country");
		// 获取页面输出流
		PrintStream out = new PrintStream(response.getOutputStream());
		// 输出HTML页面标签
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet测试</title>");
		out.println("</head>");
		out.println("<body>");
		// 输出请求参数的值：name
		out.println("您的名字：" + name + "<hr/>");
		// 输出请求参数的值：gender
		out.println("您的性别：" + gender + "<hr/>");
		// 输出请求参数的值：color
		out.println("您喜欢的颜色：");
		for (String c : color) {
			out.println(c + " ");
		}
		out.println("<hr/>");
		out.println("您喜欢的颜色：");
		// 输出请求参数的值：national
		out.println("您来自的国家：" + national + "<hr/>");
		out.println("</body>");
		out.println("</html>");
	}
}
