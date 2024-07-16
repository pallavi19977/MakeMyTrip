package com.SpiceJet.main.ServiceI;

import java.util.List;

import com.SpiceJet.main.model.Flight;

public interface SpiceJetServiceI {

	public Flight saveFlightData(Flight fr);

	public List getFlightData();

	public List getAllByFlightName(String flightName);

	public List getByFlightNameFromTo(String flightName, String flightFrom, String flightTo);

	public List getByFlightDate(String journeyDate);

	public void updateFlightData(int flightId, Flight fr);

	public void deleteIdData(int flightId);

	

	
	

}
