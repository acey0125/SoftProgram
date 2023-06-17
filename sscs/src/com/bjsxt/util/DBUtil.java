package com.bjsxt.util;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * JDBC�Ĺ�����
 * 
 * @author Administrator
 * 
 */
public class DBUtil {

	private static Connection conn = null;
	private static PreparedStatement pstmt = null;
	private static  ResultSet  rs=null;
	
	/**
	 * ����һ������
	 * @return
	 */
	public static Connection getConnection() {		
		try {
			
			Class.forName("org.logicalcobwebs.proxool.ProxoolDriver");
			
			conn = DriverManager.getConnection("proxool.test");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	/**
	 * �ر����ݿ���Դ
	 * @param rs
	 * @param stmt
	 * @param conn
	 */
	public static void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ִ��insert��update��delete ����DML����
	 * @param sql
	 * @param prams
	 * @return
	 */
	public static int executeUpdate(String sql, Object[] prams) {
		
		conn = getConnection();
		int n = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < prams.length; i++) {
				pstmt.setObject(i + 1, prams[i]);
			}
			n = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	/**
	 * ִ�в�ѯ�����ص�Resultset����
	 **/
	
	public static ResultSet executeQuery (String sql, Object[] prams) {
		
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < prams.length; i++) {
				pstmt.setObject(i + 1, prams[i]);
			}
			
			    rs = pstmt.executeQuery();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}	
}
