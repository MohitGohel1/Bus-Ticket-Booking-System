package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.constant.JdbcConstant;

public class AdminDAO {

	public boolean adminVerification(String userName,String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(JdbcConstant.url,JdbcConstant.username,JdbcConstant.password);
			String query="select * from admin where username=? and password=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
