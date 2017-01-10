package com.song.jspservlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class c3p0Connection {
	
	private static c3p0Connection c3p0;
	
	private ComboPooledDataSource cpds;
	
	static{
		c3p0 = new c3p0Connection();
	}
	
	public c3p0Connection() {
		//加载连接池配置文件
		cpds = new ComboPooledDataSource();
	}

	public static c3p0Connection getInstance(){
		return c3p0;
	}

	//获取一个连接
	public Connection getConnection() {
		Connection connInner = null;
		try {
			connInner = cpds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connInner;
	}
	
	//调用prepareStatement()方法创建statement对象
	public PreparedStatement setStatement(Connection connParameter,String sql){
		PreparedStatement ps = null;
		try {
			ps = connParameter.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	//设置sql参数值
	public PreparedStatement setStatementParameters(PreparedStatement ps,Object... values) {
		try {
			if (null != values) {
				for (int i = 1; i <= values.length; i++) {
					ps.setObject(i, values[i - 1]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps;
	}
	
	//执行查询
	public ResultSet createQuery(PreparedStatement ps){
		ResultSet rs = null;
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//关闭连接
	public void closeConnection(Connection conn,ResultSet rs,PreparedStatement ps){
		try {
			if(null != rs){
				rs.close();
			}
			
			if(null != ps){
				ps.close();
			}
			
			if(null != conn){
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
