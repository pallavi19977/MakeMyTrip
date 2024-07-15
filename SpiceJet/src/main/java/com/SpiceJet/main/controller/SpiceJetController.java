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
	private SpiceJetServiceI ms;
	
	@PostMapping("/SaveSpiceJetInfo")
	public Flight SaveKarveNagar(@RequestBody Flight mt )
	{
		Flight mmt=ms.SaveSpiceJetInfo(mt);
		return mmt;
	}
	@GetMapping("/getSpiceJetData")
	public List getSpiceJetData()
	{
		List al=ms.getSpiceJetData();
		return al;
	}
	@PutMapping("/updateflightData/{flightId}")
	public ResponseEntity<String> updateData(@PathVariable int Id,
			                                    @RequestBody Flight myt)
	{
		ms.updateData(Id,myt);
		return new ResponseEntity<String> ("DataUpdated..",HttpStatus.OK);
		
	}
	@DeleteMapping("/deleteSingleData/{flightId}")
	public String deleteData(@PathVariable("makemytripflightId")int makemytripflightId)
	{
		ms.deleteData(makemytripflightId);
		return "Deleted Successfully....";
		
	}

}
