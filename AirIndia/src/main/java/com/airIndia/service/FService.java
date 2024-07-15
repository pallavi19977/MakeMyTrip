package com.airIndia.service;

import java.util.List;

import com.airIndia.model.Flight;

public interface FService {

	public Flight saveFData(Flight f);

	public List getFData();

	public List getAllByFName(String flightName);

	public List getFNameFrTo(String flightName, String flightFrom, String flightTo);

	public List getByBsDate(String journeyDate);

	public void update_fl_Data(int flightId, Flight f);

	public void deleteIdData(int flightId);

}
