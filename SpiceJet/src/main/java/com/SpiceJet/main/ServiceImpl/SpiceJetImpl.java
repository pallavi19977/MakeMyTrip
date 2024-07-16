package com.SpiceJet.main.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpiceJet.main.Repository.SpiceJetRepository;
import com.SpiceJet.main.ServiceI.SpiceJetServiceI;
import com.SpiceJet.main.model.Flight;

@Service
public class SpiceJetImpl implements SpiceJetServiceI
{
	@Autowired
	private SpiceJetRepository sr;

	@Override
	public Flight saveFlightData(Flight fr) 
	{
		Flight fly=sr.save(fr);
		return fly;
	}

	@Override
	public List getFlightData() 
	{
		List<Flight> fly=sr.findAll();
		return fly;
	}

	@Override
	public List getAllByFlightName(String flightName) {
		List al=sr.getAllByFlightName(flightName);
		return al;
	}

	@Override
	public List getByFlightNameFromTo(String flightName, String flightFrom, String flightTo) 
	{
		List al=sr.getByFlightNameFromTo(flightName,flightFrom,flightTo);
		return al;
	}

	@Override
	public List getByFlightDate(String journeyDate) 
	{
		List<Flight>fly=sr.getByFlightDate(journeyDate);
		return fly.stream().sorted((f1,f2)->f1.getJourneyDate().compareTo(f2.getJourneyDate())).toList();
	}

	@Override
	public void updateFlightData(int flightId, Flight fr) {
		Optional<Flight>ofl=sr.findById(flightId);
		if(ofl.isPresent())
		{
			sr.save(fr);
			
		}
		else 
		{
			throw new RuntimeException("User with id: " +flightId+ " flightId Not Present");
		}
	}

	@Override
	public void deleteIdData(int flightId) 
	{
		sr.deleteById(flightId);
		
	}

	

	
	
	
}
