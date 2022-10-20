package com.sist.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.vo.RegisterBean;

public class RegisterMgr {
	private final String JDBC_DRRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private final String USER = "c##madang";
	private final String PASS= "madang";
	
	public RegisterMgr() {
		try {
			Class.forName(JDBC_DRRIVER);
		}catch (Exception e) {
			System.out.println("JDBC DRIVER Exception" + e);
		}
	}
	
	public ArrayList<RegisterBean> getRegisterList(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<RegisterBean> list = new ArrayList<>();
		
		
		
		return list;
	}
}
