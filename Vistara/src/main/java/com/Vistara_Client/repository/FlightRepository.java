package com.Vistara_Client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Vistara_Client.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{

	@Query(value="from Flight where flightFrom=:flightFrom")
	public List getDataByFromlocation(String flightFrom);

	@Query(value="from Flight where flightTo=:flightTo")
	public List getDataByFromTolocation(String flightTo);

	@Query(value="from Flight where flightFrom=:flightFrom and flightTo=:flightTo")
	public List getDataByFromTo(String flightFrom, String flightTo);

	@Query(value="from Flight where ticketPrice=:ticketPrice")
	public List getDataByPrice(String ticketPrice);

	@Query(value="from Flight where journeyDate=:journeyDate")
	public List getDataByJourneyData(String journeyDate);

	@Query(value="from Flight where flightTime=:flightTime")
	public List getDataByTime(String flightTime);

}
