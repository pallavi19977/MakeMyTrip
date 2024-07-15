package com.airIndia.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.airIndia.model.Flight;
import com.airIndia.service.FService;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class FController {
	@Autowired 
	private FService fs;
	
	@PostMapping("/regFlightData")
	public String regSTData(@RequestBody Flight f)
	{
		Flight fl=fs.saveFData(f);
		return " Flight Data Registered successfully.......!!";
	}
	@GetMapping("/getAllFData")
	public List getFData()
	{
		List al=fs.getFData();
		return al;
	}
	@GetMapping("/getAllByFNm/{flightName}")
	public List getAllByFName(@PathVariable String flightName)
	{
		List al=fs.getAllByFName(flightName);
		return al;
	}
	@GetMapping("/getByFNmFrmTo/{flightName}/{flightFrom}/{flightTo}")
	public List getFNameFrTo(@PathVariable String flightName,@PathVariable String flightFrom,@PathVariable String flightTo)
	{
		List al=fs.getFNameFrTo(flightName,flightFrom,flightTo);
		return al;
	}
	@GetMapping("/getAllBydate/{journeyDate}")
	public List getByFDate(@PathVariable String journeyDate)
	{
		List al=fs.getByBsDate(journeyDate);
		return al;
	}
	@PutMapping("/updateFData/{flightId}")
	public ResponseEntity<String> update_st_Data(@PathVariable int flightId,
			                                    @RequestBody Flight f)
	{
		fs.update_fl_Data(flightId,f);
		return new ResponseEntity<String> ("DataUpdated..",HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteSingleData/{flightId}")
	public String deleteData(@PathVariable("flightId")int flightId)
	{
		fs.deleteIdData(flightId);
		return "Deleted SuccessFully....";
		
	}


	


}
