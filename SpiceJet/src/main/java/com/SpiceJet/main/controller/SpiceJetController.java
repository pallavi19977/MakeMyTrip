package com.SpiceJet.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpiceJet.main.ServiceI.SpiceJetServiceI;
import com.SpiceJet.main.model.Flight;

@RestController
public class SpiceJetController 
{
	@Autowired
	private SpiceJetServiceI ss;
	
	@PostMapping("/SaveFlightData")
	public String SaveFlightData(@RequestBody Flight fr)
	{
		Flight fly=ss.saveFlightData(fr);
		return "Save Flight Data Successfully";
	}
	@GetMapping("/getAllFlightData")
	public List getFlightData()
	{
		List al=ss.getFlightData();
		return al;
	}
	@GetMapping("/getAllByFlightName/{flightName}")
	public List getAllByFlightName(@PathVariable String flightName)
	{
		List al=ss.getAllByFlightName(flightName);
		return al;
	}
	
	@GetMapping("/getByFlightNameFromTo/{flightName}/{flightFrom}/{flightTo}")
	public List getByFlightNameFromTo(@PathVariable String flightName,@PathVariable String flightFrom,@PathVariable String flightTo)
	{
		List al=ss.getByFlightNameFromTo(flightName,flightFrom,flightTo);
		return al;
	}
	@GetMapping("/getAllBydate/{journeyDate}")
	public List getByFlightDate(@PathVariable String journeyDate)
	{
		List al=ss.getByFlightDate(journeyDate);
		return al;
	}
	@PutMapping("/updateFlightData/{flightId}")
	public ResponseEntity<String> updateFlightData(@PathVariable int flightId,@RequestBody Flight fr)
	{
		ss.updateFlightData(flightId,fr);
		return new ResponseEntity<String> ("Data Updated",HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteSingleData/{flightId}")
	public String deleteData(@PathVariable("flightId")int flightId)
	{
		ss.deleteIdData(flightId);
		return "Data Deleted";
		
	}
}
