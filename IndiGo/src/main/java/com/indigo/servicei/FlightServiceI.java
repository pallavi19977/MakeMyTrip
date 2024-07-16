package com.indigo.servicei;

import com.indigo.model.Flight;

public interface FlightServiceI 
{
	public Flight regFlightInfo(Flight f);
	public Iterable<Flight> getAllFlightsInfo();
	public String updateFlightInfo(int flightId, Flight f);
	public String deleteFlightInfo(int flightId);
	public String modifyFlightTime(int flightId, Flight f);
	
}
