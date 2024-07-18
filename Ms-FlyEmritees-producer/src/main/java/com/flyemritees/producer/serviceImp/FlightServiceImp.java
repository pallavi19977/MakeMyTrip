package com.flyemritees.producer.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flyemritees.producer.Repository.FlightRepository;
import com.flyemritees.producer.model.Flight;
import com.flyemritees.producer.serviceI.FlightServiceI;
@Service
public class FlightServiceImp  implements FlightServiceI{
@Autowired FlightRepository fr;
	@Override
	public Flight saveFlight(Flight f) {
		return fr.save(f);
	}
	@Override
	public List<Flight> getAllFlight() {
		return fr.findAll();
	}

}
