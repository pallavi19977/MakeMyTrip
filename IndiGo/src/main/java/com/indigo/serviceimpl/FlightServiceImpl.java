package com.indigo.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indigo.model.Flight;
import com.indigo.repository.FlightRepository;
import com.indigo.servicei.FlightServiceI;

import jakarta.transaction.Transactional;

@Service
public class FlightServiceImpl implements FlightServiceI {

	@Autowired
	private FlightRepository fr;

	//create
	@Override
	public Flight regFlightInfo(Flight f) {
		Flight fl = fr.save(f);
		return fl;
	}

	//read
	@Override
	public Iterable<Flight> getAllFlightsInfo() {
		return fr.findAll();
	}
	
	// Get flight by flightId
	@Override
	public Flight getSingleFlightInfoById(int flightId) {
		Optional<Flight> flightOp = fr.findById(flightId);
		Flight fl = flightOp.get();
		return fl;
	}
	
	@Override
	public List<Flight> getAllFlightsInfoByName(String flightName) 
	{
		List<Flight> flightList = fr.getByflightName(flightName);
		return flightList.stream().sorted((b1, b2) -> b1.getFlightName().compareTo(b2.getFlightName())).toList();
	}
	
	// Get flight list by flight From and to
	@Override
	public List<Flight> getAllFlightsInfoByFromTo(String flightFrom, String flightTo) {
		List<Flight> flightList = fr.getByFromTo(flightFrom, flightTo);
		return flightList.stream().toList();
	}
	
	// Get flight list by journey date
	@Override
	public List<Flight> getAllFlightsInfoByDate(String journeyDate)
	{
		List<Flight> flightList = fr.getByjourneyDate(journeyDate);
		return flightList.stream().sorted((b1, b2) -> b1.getJourneyDate().compareTo(b2.getJourneyDate())).toList();
	}

	//update
	@Override
	public String updateFlightInfo(int flightId, Flight b) {
		Optional<Flight> opFlight = fr.findById(flightId);
		if (opFlight.isPresent()) {
			fr.updateByflightId(b.getFlightName(), b.getFlightFrom(), b.getFlightTo(), 
					b.getTicketPrice(), b.getJourneyDate(), b.getFlightTime(), flightId);
			return "Data updated successfully";
		} else {
			throw new RuntimeException("User with id: " + flightId + " is not present");
		}
	}

	//delete
	@Transactional
	@Override
	public String deleteFlightInfo(int flightId) {
		Optional<Flight> opFlight = fr.findById(flightId);
		if (opFlight.isPresent()) {
			fr.deleteByflightId(flightId);
			return "Data deleted successfully";
		} else {
			throw new RuntimeException("User with id: " + flightId + " is not present");
		}
	}

	//modifying only flight take off time
	@Override
	public String modifyFlightTime(int flightId, Flight f) {
		Optional<Flight> FlightOp = fr.findById(flightId);
		if (FlightOp.isPresent()) {
			fr.modifyflightTime(f.getFlightTime(), flightId);
			return "Flight timing changed successfully";
		} else {
			throw new RuntimeException("User with id: " + flightId + " is not present");
		}
	}
}