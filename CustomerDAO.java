package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.constant.JdbcConstant;
import com.mohit.Customer;

public class CustomerDAO {

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection(JdbcConstant.url,JdbcConstant.username,JdbcConstant.password);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  null;
	}
	
	public boolean addCustomer(Customer c) {
		Connection con=getConnection();
		String query="insert into customer(firstName,lastName,address,mobile,userName,password) values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, c.getFirstName());
			ps.setString(2, c.getLastName());
			ps.setString(3, c.getAddress());
			ps.setLong(4, c.getMobile());
			ps.setString(5, c.getUserName());
			ps.setString(6, c.getPassword());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean validateCustomer(String userName,String password) {
		Connection con=getConnection();
		String query="select * from customer where userName=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean getUserNames(String userName){
		Connection con=getConnection();
		String query="select userName from customer where userName=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,userName);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean getMobileNumbers(long mobile){
		Connection con=getConnection();
		String query="select mobile from customer where mobile=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setLong(1,mobile);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int getId(String userName) {
		Connection con=getConnection();
		String query="select id from customer where userName=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,userName);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public Customer getCustomer(int id) {
		Connection con=getConnection();
		String query="Select * from customer where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getLong(5),rs.getString(6),rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
