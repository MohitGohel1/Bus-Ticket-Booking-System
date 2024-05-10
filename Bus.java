package com.mohit;

import java.time.LocalDate;

public class Bus {

	int id;
	String name;
	String source;
	String destination;
	String type;
	LocalDate departure;
	LocalDate arrival;
	int totalseats;
	int availableseats;
	int fare;
	
	public Bus() {
		
	}

	public Bus(int id, String name, String source, String destination, String type, LocalDate departure,
			LocalDate arrival, int totalseats, int availableseats, int fare) {
		this.id = id;
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.type = type;
		this.departure = departure;
		this.arrival = arrival;
		this.totalseats = totalseats;
		this.availableseats = availableseats;
		this.fare = fare;
	}
	
	public Bus(String name, String source, String destination, String type, LocalDate departure,
			LocalDate arrival, int totalseats, int availableseats, int fare) {
		this.id = id;
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.type = type;
		this.departure = departure;
		this.arrival = arrival;
		this.totalseats = totalseats;
		this.availableseats = availableseats;
		this.fare = fare;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public LocalDate getDeparture() {
		return departure;
	}

	public void setDeparture(LocalDate departure) {
		this.departure = departure;
	}

	public LocalDate getArrival() {
		return arrival;
	}

	public void setArrival(LocalDate arrival) {
		this.arrival = arrival;
	}

	public int getTotalseats() {
		return totalseats;
	}

	public void setTotalseats(int totalseats) {
		this.totalseats = totalseats;
	}

	public int getAvailableseats() {
		return availableseats;
	}

	public void setAvailableseats(int availableseats) {
		this.availableseats = availableseats;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}
	
	
}
