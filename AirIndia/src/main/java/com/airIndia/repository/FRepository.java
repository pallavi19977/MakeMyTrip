package com.airIndia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airIndia.model.Flight;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface FRepository extends JpaRepository<Flight, Integer>{

	@Query(name="getByFName",value="from Flight where flightName=?1")
	List getByFName(String flightName);

	@Query(name="getByNmFrmTo",value="from Flight where flightName=?1 and flightFrom=?2 and flightTo=?3")
	List getByNmFrmTo(String flightName, String flightFrom, String flightTo);

	@Query(name="getByDate",value="from Flight where journeyDate=?1")
	List<Flight> getByDate(String journeyDate);

	public void deleteByFlightId(int flightId);
}
