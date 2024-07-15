package com.Vistara_Client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Vistara_Client.model.Flight;
import com.Vistara_Client.service.FlightService;

@RestController
public class HomeController {

	@Autowired private FlightService fsi;
	
	@PostMapping("/saveFlightData")
	public Flight saveFlightData(@RequestBody Flight f)
	{
		Flight ft = fsi.saveFlightData(f);
		return ft;
	}
	
	@GetMapping("/getFlightData")
	public ResponseEntity<List<Flight>> getAllData()
	{
	    List<Flight> st = fsi.getAllData();
		return new ResponseEntity<List<Flight>> (st,HttpStatus.OK);
	    	
	}
	
	@GetMapping("getDataByFrom/{flightFrom}")
	public List getDataByFromlocation(@PathVariable String flightFrom)
	{
		List lt = fsi.getDataByFromlocation(flightFrom);
		return lt;
	}
	
	@GetMapping("getDataByTo/{flightTo}")
	public List getDataByTolocation(@PathVariable String flightTo)
	{
		List lt = fsi.getDataByTolocation(flightTo);
		return lt;
	}
	
    @GetMapping("/getDataFromTo/{flightFrom}/{flightTo}")
    public List getDataByFromTo(@PathVariable String flightFrom,@PathVariable String flightTo)
    {
    	List lt = fsi.getDataByFromTo(flightFrom,flightTo);
    	return lt;
    }
    
    @GetMapping("getDataByPrice/{ticketPrice}")
	public List getDataByPrice(@PathVariable String ticketPrice)
	{
		List lt = fsi.getDataByPrice(ticketPrice);
		return lt;
	}
    
	@GetMapping("/getDataByPriceAsc/{ticketPrice}")
	public List getDataByPriceAsc(@PathVariable String ticketPrice)
	{
		List lt = fsi.getDataByPriceAsc(ticketPrice);
		return lt;
	}
	
	@GetMapping("/getDataByPriceDesc/{ticketPrice}")
	public List getDataByPriceDesc(@PathVariable String ticketPrice)
	{
		List lt = fsi.getDataByPriceDesc(ticketPrice);
		return lt;
	}
	
	@GetMapping("/getDataByJourneyDate/{journeyDate}")
	public List getDataByJourneyDate(@PathVariable String journeyDate)
	{
		List lt = fsi.getDataByJourneyDate(journeyDate);
		return lt;
	}
	
	@GetMapping("/getDataByTime/{flightTime}")
	public List getDataByTime(@PathVariable String flightTime)
	{
		List lt = fsi.getDataByTime(flightTime);
		return lt;
	}
	

}
