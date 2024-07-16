package com.SpiceJet.main.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SpiceJet.main.model.Flight;

import jakarta.transaction.Transactional;

@Repository
public interface SpiceJetRepository extends JpaRepository<Flight, Integer>
{
	@Query(name="getAllByFlightName",value="from Flight where flightName=?1")
	List getAllByFlightName(String flightName);

	@Query(name="getByFlightNameFromTo",value="from Flight where flightName=?1 and flightFrom=?2 and flightTo=?3")
	List getByFlightNameFromTo(String flightName, String flightFrom, String flightTo);

	@Query(name="getByFlightDate",value="from Flight where journeyDate=?1")
	List<Flight> getByFlightDate(String journeyDate);

	

	
}
