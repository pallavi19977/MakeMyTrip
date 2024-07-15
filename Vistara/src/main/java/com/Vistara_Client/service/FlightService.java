package com.Vistara_Client.service;

import java.util.List;

import com.Vistara_Client.model.Flight;

public interface FlightService {

	public Flight saveFlightData(Flight f);

	public List<Flight> getAllData();

	public List getDataByFromlocation(String flightFrom);

	public List getDataByTolocation(String flightTo);

	public List getDataByFromTo(String flightFrom, String flightTo);

	public List getDataByPrice(String ticketPrice);

	public List getDataByPriceAsc(String ticketPrice);

	public List getDataByPriceDesc(String ticketPrice);

	public List getDataByJourneyDate(String journeyDate);

	public List getDataByTime(String flightTime);

}
