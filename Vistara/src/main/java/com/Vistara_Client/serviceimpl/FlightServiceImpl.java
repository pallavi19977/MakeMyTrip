package com.Vistara_Client.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vistara_Client.model.Flight;
import com.Vistara_Client.repository.FlightRepository;
import com.Vistara_Client.service.FlightService;

@Service
public class FlightServiceImpl implements FlightService{

	@Autowired private FlightRepository fr;
	
	@Override
	public Flight saveFlightData(Flight f)
	{
		
		return fr.save(f);
	}

	@Override
	public List<Flight> getAllData() 
	{
	
		return fr.findAll();
	}

	@Override
	public List getDataByFromlocation(String flightFrom)
	{
		List lt = fr.getDataByFromlocation(flightFrom);
		return lt;
	}

	@Override
	public List getDataByTolocation(String flightTo) 
	{
		List lt = fr.getDataByFromTolocation(flightTo);
		return lt;
	}

	@Override
	public List getDataByFromTo(String flightFrom, String flightTo) 
	{
		List lt = fr.getDataByFromTo(flightFrom,flightTo);
		return lt;
	}

	@Override
	public List getDataByPrice(String ticketPrice)
	{
		List lt = fr.getDataByPrice(ticketPrice);
		return lt;
	}

	@Override
	public List getDataByPriceAsc(String ticketPrice) 
	{
		List<Flight> asclt = fr.findAll();
		return asclt.stream().sorted((a,b)->(int)a.getTicketPrice()-(int)b.getTicketPrice()).toList();		
	}

	@Override
	public List getDataByPriceDesc(String ticketPrice)
	{
		List<Flight> asclt = fr.findAll();
		return asclt.stream().sorted((a,b)->(int)b.getTicketPrice()-(int)a.getTicketPrice()).toList();		
	}

	@Override
	public List getDataByJourneyDate(String journeyDate)
	{
		List lt = fr.getDataByJourneyData(journeyDate);
		return lt;
	}

	@Override
	public List getDataByTime(String flightTime)
	{
		List lt = fr.getDataByTime(flightTime);
		return lt;
	}

}
