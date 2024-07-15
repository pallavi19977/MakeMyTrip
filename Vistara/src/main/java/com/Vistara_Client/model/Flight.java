package com.Vistara_Client.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	  private int flightId;
	  private String flightName;
	  private String flightFrom;
	  private String flightTo;
	  private double ticketPrice;
	  private String journeyDate;
	  private String flightTime;
	  
}
