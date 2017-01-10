package com.song.jspservlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//在web.xml中配置该servlet
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String errMsg = "";
		RequestDispatcher rd;

		//页面获取参数
		String username = request.getParameter("username");
		String password = request.getParameter("pass");

		Map<String, String> mapResult = new HashMap<String, String>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//数据库操作
			c3p0Connection c3p0 = c3p0Connection.getInstance();
			conn = c3p0.getConnection();
			
			String sql = "SELECT * FROM tb_user WHERE MOBILE = ? ";
			ps = c3p0.setStatement(conn, sql);
			
			ps = c3p0.setStatementParameters(ps, new Object[]{"18201721679"});
			
			rs = c3p0.createQuery(ps);
			
			//处理结果集
			while(rs.next()){
				Object name = rs.getObject(4);
				Object mobile = rs.getObject(5);
				Object passwordDB = rs.getObject(11);
				
				mapResult.put("name", name.toString());
				mapResult.put("mobile", mobile.toString());
				mapResult.put("passwordDB", passwordDB.toString());
				
				System.out.println("Name:"+name+",Mobile:"+mobile+",passwordDB:"+passwordDB);
			}
			
			if(!mapResult.isEmpty()){
				if(MD5Util.validate(mapResult.get("passwordDB"), password)){
					
					HttpSession session = request.getSession(true);
					session.setAttribute("name", username);
					rd = request.getRequestDispatcher("/welcome.jsp");
					rd.forward(request, response);
				}else{
					errMsg = "密码错误，请重新输入";
				}
			}else{
				errMsg = "用户名不存在，请先注册";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//回收资源
			c3p0Connection.getInstance().closeConnection(conn, rs, ps);
		}
		
		if(null != errMsg && !errMsg.equals("")){
			rd = request.getRequestDispatcher("/login.jsp");
			request.setAttribute("err", errMsg);
			rd.forward(request, response);
		}
	}
}
