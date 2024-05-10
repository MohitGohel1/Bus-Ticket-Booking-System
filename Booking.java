package com.mohit;

public class Booking {

	int cusid;
	int busid;
	int booked_set;
	int fare;
	String status;
	public Booking() {
		
	}
	public Booking(int cusid, int busid, int booked_set, int fare) {
		this.cusid = cusid;
		this.busid = busid;
		this.booked_set = booked_set;
		this.fare = fare;
		this.status="nc";
	}
	
	public Booking(int cusid, int busid, int booked_set, int fare,String status) {
		this.cusid = cusid;
		this.busid = busid;
		this.booked_set = booked_set;
		this.fare = fare;
		this.status=status;
	}
	public int getCusid() {
		return cusid;
	}
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	public int getBusid() {
		return busid;
	}
	public void setBusid(int busid) {
		this.busid = busid;
	}
	public int getBooked_set() {
		return booked_set;
	}
	public void setBooked_set(int booked_set) {
		this.booked_set = booked_set;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
