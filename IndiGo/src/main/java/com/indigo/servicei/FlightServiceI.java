package com.indigo.servicei;

import java.util.List;

import com.indigo.model.Flight;

public interface FlightServiceI 
{
	public Flight regFlightInfo(Flight f);
	public Iterable<Flight> getAllFlightsInfo();
	public Flight getSingleFlightInfoById(int flightId);
	public List<Flight> getAllFlightsInfoByName(String flightName);
	public List<Flight> getAllFlightsInfoByFromTo(String flightFrom, String flightTo);
	public List<Flight> getAllFlightsInfoByDate(String journeyDate);
	public String updateFlightInfo(int flightId, Flight f);
	public String deleteFlightInfo(int flightId);
	public String modifyFlightTime(int flightId, Flight f);
	
}
