package com.indigo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.indigo.model.Flight;
import com.indigo.servicei.FlightServiceI;

@RestController
public class HomeController 
{
	private @Autowired FlightServiceI fsi;
	
	@PostMapping("/postFlight")
	public String regFlightData(@RequestBody Flight f)
	{
		fsi.regFlightInfo(f);
		return "Flight details saved successfully!";
	}
	
	@GetMapping("/getFlights")
	public Iterable<Flight> getAllFlightsData()
	{
		Iterable<Flight> flightList=fsi.getAllFlightsInfo();
		return flightList;
	}
	
	@GetMapping("/getFlightById/{flightId}")
	public Flight getSingleFlightById(@PathVariable int flightId)
	{
		Flight fl=fsi.getSingleFlightInfoById(flightId);
		return fl;
	}
	
	@GetMapping("/getFlightsByName/{flightName}")
	public List<Flight> getAllFlightsByName(@PathVariable String flightName)
	{
		List<Flight> flightList=fsi.getAllFlightsInfoByName(flightName);
		return flightList;
	}
	
	@GetMapping("/getFlightsByFromTo/{flightFrom}/{flightTo}")
	public List<Flight> getAllFlightsByFromTo(@PathVariable String flightFrom, @PathVariable String flightTo)
	{
		List<Flight> flightList=fsi.getAllFlightsInfoByFromTo(flightFrom, flightTo);
		return flightList;
	}
	
	@GetMapping("/getFlightsByDate/{journeyDate}")
	public List<Flight> getAllFlightsByDate(@PathVariable String journeyDate)
	{
		List<Flight> flightList=fsi.getAllFlightsInfoByDate(journeyDate);
		return flightList;
	}
	
	@PutMapping("/updateFlight/{flightId}")
	public String updateFlight(@PathVariable int flightId, @RequestBody Flight f)
	{
		fsi.updateFlightInfo(flightId, f);
		return "Data updated successfully!";
	}
	
	@DeleteMapping("/deleteFlight/{flightId}")
	public String deleteFlight(@PathVariable int flightId)
	{
		fsi.deleteFlightInfo(flightId);
		return "Flight data deleted successfully!!!!";
	}
	
	@PatchMapping("/modifyFlightTime/{flightId}")
	public String modifyFlightTime(@PathVariable int flightId, @RequestBody Flight f)
	{
		fsi.modifyFlightTime(flightId, f);
		return "Flight timing has been modified!";
	}
	
	
}
