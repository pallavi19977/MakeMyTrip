package com.airIndia.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airIndia.model.Flight;
import com.airIndia.repository.FRepository;
import com.airIndia.service.FService;

import java.util.Optional;

@Service
public class FServiceImpl implements FService{

	@Autowired
	private FRepository fr;
	@Override
	public Flight saveFData(Flight f) {
		Flight db_flight=fr.save(f);
		return db_flight;
	}
	@Override
	public List<Flight> getFData()
	{
		List<Flight> fl=fr.findAll();
		return fl;
	}
	@Override
	public List getAllByFName(String flightName) {
		List lt=fr.getByFName(flightName);
		return lt;

	}
	@Override
	public List getFNameFrTo(String flightName, String flightFrom, String flightTo) {
		List al=fr.getByNmFrmTo(flightName,flightFrom,flightTo);
		return al;

	}
	@Override
	public List getByBsDate(String journeyDate) {
		List<Flight>fl=fr.getByDate(journeyDate);
		return fl.stream().sorted((f1,f2)->f1.getJourneyDate().compareTo(f2.getJourneyDate())).toList();

	}
	@Override
	public void update_fl_Data(int flightId, Flight f) {
		Optional<Flight>ofl=fr.findById(flightId);
		if(ofl.isPresent())
		{
			fr.save(f);
			
		}else 
		{
			throw new RuntimeException("User with id: " +flightId+ " isn't present");
		}
	}
	@Override
	public void deleteIdData(int flightId) {
		fr.deleteById(flightId);
}
	

}
