package com.flyemritees.producer.serviceI;

import java.util.List;

import com.flyemritees.producer.model.Flight;

public interface FlightServiceI {

public 	Flight saveFlight(Flight f);

public List<Flight> getAllFlight();

}
