package com.flyemritees.producer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flyemritees.producer.Repository.FlightRepository;
import com.flyemritees.producer.model.Flight;
import com.flyemritees.producer.serviceI.FlightServiceI;

@RestController
public class HomeController {
	@Autowired FlightServiceI fs;
	@PostMapping("/save")
	public Flight saveFlight(@RequestBody Flight f) {
		return  fs.saveFlight(f);
	}
	@GetMapping("/getAllFlights")
	public List<Flight> getFlight(){
		List <Flight> flist=fs.getAllFlight();
		return flist;
	}

}
