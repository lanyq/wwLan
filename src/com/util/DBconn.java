package com.util;

import java.sql.*;

import org.apache.log4j.Logger;

import com.thread.TokenThread;

public class DBconn {
	private static Logger log = Logger.getLogger(DBconn.class);
	/*static String url = "jdbc:mysql://localhost:3306/test?useunicuee=true& characterEncoding=utf8"; 
	static String username = "root"; 
	static String password = "root"; */
	static String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	static String username = "ncrb"; 
	static String password = "password"; 
	static String driverType="oracle.jdbc.driver.OracleDriver";
	// static String driverType="com.mysql.jdbc.Driver";
	static Connection  conn = null;
	static ResultSet rs = null;
	static PreparedStatement ps =null;
	public static void init(){
		try {
			Class.forName(driverType);
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			System.out.println("init [SQL驱动程序初始化失败！]");
			e.printStackTrace();
		}
	}
	public static int addUpdDel(String sql){
		System.out.println(sql);
		log.info("打印sql语句:"+sql);
		int i = 0;
		try {
			PreparedStatement ps =  conn.prepareStatement(sql);
			i =  ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql数据库增删改异常");
			e.printStackTrace();
		}
		
		return i;
	}
	public static ResultSet selectSql(String sql){
		try {
			ps =  conn.prepareStatement(sql);
			rs =  ps.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("sql数据库查询异常");
			e.printStackTrace();
		}
		return rs;
	}
	public static void closeConn(){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("sql数据库关闭异常");
			e.printStackTrace();
		}
	}
}
