package com.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.constant.JdbcConstant;
import com.mohit.Booking;

public class BookingDAO {

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
	
	public boolean addBooking(Booking b) {
		Connection con=getConnection();
		String query="insert into booking(cusid,busid,booked_set,fare) values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, b.getCusid());
			ps.setInt(2, b.getBusid());
			ps.setInt(3, b.getBooked_set());
			ps.setInt(4, b.getFare());
//			ps.setString(5,"nc");
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Booking> getBooking(int cusid){
		List<Booking> list=new ArrayList<>();
		Connection con=getConnection();
		String query="select * from booking where cusid=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, cusid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Booking(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean cancelTicket(int busid,int cusid,int seatnumber) {
		Connection con=getConnection();
		String query="delete from booking where cusid=? and busid=? and booked_set=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,cusid);
			ps.setInt(2,busid);
			ps.setInt(3,seatnumber);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}
	
	public List<Booking> getAllBooking(){
		List<Booking> list=new ArrayList<>();
		Connection con=getConnection();
		String query="select * from booking";
		try {
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(query);
			while(rs.next()) {
				list.add(new Booking(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean confirmTicket(int busid,int cusid,int seatnumber) {
		Connection con=getConnection();
		String query="update booking set status=? where cusid=? and busid=? and booked_set=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,"c");
			ps.setInt(2,cusid);
			ps.setInt(3,busid);
			ps.setInt(4,seatnumber);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false;
	}
}
