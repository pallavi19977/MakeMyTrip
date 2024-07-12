package com.cjc.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cjc.main.model.Flight;
import jakarta.transaction.Transactional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> 
{

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
