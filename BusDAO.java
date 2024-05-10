package com.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.constant.JdbcConstant;
import com.mohit.Bus;

public class BusDAO {
	
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
	
	public boolean addBus(Bus b) {
		Connection con=getConnection();
		String query="insert into bus_details(name,source,destination,type,departure,arrival,totalseats,availableseats,fare) values(?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,b.getName());
			ps.setString(2,b.getSource());
			ps.setString(3,b.getDestination());
			ps.setString(4,b.getType());
			ps.setDate(5, Date.valueOf(b.getDeparture()));
			ps.setDate(6, Date.valueOf(b.getArrival()));
			ps.setInt(7,b.getTotalseats());
			ps.setInt(8, b.getAvailableseats());
			ps.setInt(9, b.getFare());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public List<String> getsource() {
		Connection con=getConnection();
		String query="select source from bus_details";
		List<String> boarding=new ArrayList<>();
		try {
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(query);
			while(rs.next()) {
				boarding.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return boarding;
	}
	
	public List<String> getdestination() {
		Connection con=getConnection();
		String query="select destination from bus_details";
		List<String> destination=new ArrayList<>();
		try {
			Statement s=con.createStatement();
			ResultSet rs=s.executeQuery(query);
			while(rs.next()) {
				destination.add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return destination;
	}
	
	public List<Bus> getBusDetails(String source,String destination){
		Connection con=getConnection();
		List<Bus> list=new ArrayList<>();
		String query="select * from bus_details where source=? and destination=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,source);
			ps.setString(2,destination);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(new Bus(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getDate(7).toLocalDate(),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Integer> getBookedSeats(int busid){
		Connection con=getConnection();
		List<Integer> list=new ArrayList<>();
		String query="select booked_set from booking where busid=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,busid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int getTotalSeats(int busid) {
		Connection con=getConnection();
		String query="select totalseats from bus_details where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, busid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getFare(int id) {
		Connection con=getConnection();
		String query="select fare from bus_details where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public int getAvailableSeats(int busid) {
		Connection con=getConnection();
		String query="select availableseats from bus_details where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, busid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean setAvailableSeats(int busid) {
		Connection con=getConnection();
		int availableSeats=getAvailableSeats(busid)-1;
		String query="update bus_details set availableseats=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, availableSeats);
			ps.setInt(2,busid);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Bus getBus(int id) {
		Connection con=getConnection();
		String query="select * from bus_details where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return new Bus(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6).toLocalDate(),rs.getDate(7).toLocalDate(),rs.getInt(8),rs.getInt(9),rs.getInt(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean setAvailableSeats1(int busid) {
		Connection con=getConnection();
		int availableSeats=getAvailableSeats(busid)+1;
		String query="update bus_details set availableseats=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, availableSeats);
			ps.setInt(2,busid);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
