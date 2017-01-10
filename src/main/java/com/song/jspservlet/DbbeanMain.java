package com.song.jspservlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class DbbeanMain {

	public static Map<String, String> processMain(){
		Map<String, String> mapResult = new HashMap<String, String>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = c3p0Connection.getInstance().getConnection();
			
			String sql = "SELECT * FROM tb_user WHERE MOBILE = ? ";
			ps = c3p0Connection.getInstance().setStatement(conn, sql);
			
			ps = c3p0Connection.getInstance().setStatementParameters(ps, new Object[]{"18201721679"});
			
			rs = c3p0Connection.getInstance().createQuery(ps);
			
			//处理结果集
			while(rs.next()){
				Object name = rs.getObject(4);
				Object mobile = rs.getObject(5);
				Object password = rs.getObject(11);
				
				mapResult.put("name", name.toString());
				mapResult.put("mobile", mobile.toString());
				mapResult.put("password", password.toString());
				
				System.out.println("Name:"+name+",Mobile:"+mobile+",password:"+password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//回收资源
//			c3p0Connection.getInstance().closeConnection(conn, rs, ps);
		}
		return mapResult;
	}
}
