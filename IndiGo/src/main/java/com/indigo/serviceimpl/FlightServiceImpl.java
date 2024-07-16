package com.indigo.serviceimpl;

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