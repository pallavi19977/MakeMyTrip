package com.SpiceJet.main.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class Flight 
{
	@Id
	
	private int flightId;
	private String flightName;
	private String flightFrom;
	private String flightTo;
	private double ticketPrice;
	private String journeyDate;
	private String flightTime;
}
