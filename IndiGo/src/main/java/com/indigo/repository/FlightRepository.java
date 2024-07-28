package com.indigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.indigo.model.Flight;

import jakarta.transaction.Transactional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> 
{
	
	@Query(name = "getByflightName", value = "from Flight where flightName=?1")
	public List<Flight> getByflightName(String flightName);
	
	@Query(name = "getByFromTo", value = "from Flight where flightFrom=?1 and flightTo=?2")
	public List<Flight> getByFromTo(String flightFrom, String flightTo);
	
	@Query(name = "getByjourneyDate", value = "from Flight where journeyDate=?1")
	public List<Flight> getByjourneyDate(String journeyDate);

	@Transactional
	@Modifying
	@Query(name = "updateByflightId", value = "update Flight set flightName=?1, flightFrom=?2, "
			+ "flightTo=?3, ticketPrice=?4, journeyDate=?5, flightTime=?6 where flightId=?7")
	public void updateByflightId(String flightName, String flightFrom, String flightTo, 
			double ticketPrice, String journeyDate, String flightTime, int flightId);
	
	@Transactional
	@Modifying
	@Query(name = "deleteByflightId", value = "delete from Flight where flightId=?1")
	public void deleteByflightId(int flightId);
	
	@Transactional
	@Modifying
	@Query(name = "modifyflightTime", value = "update Flight set flightTime=?1 where flightId=?2")
	public void modifyflightTime(String flightTime, int flightId);
	
}
