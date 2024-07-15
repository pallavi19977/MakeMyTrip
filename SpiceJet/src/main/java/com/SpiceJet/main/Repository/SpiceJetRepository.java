package com.SpiceJet.main.Repository;

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
	@Query(value="update MakeMyTrip set makemytripflightName=:makemytripflightName where makemytripflightId=makemytripflightId=?1")
	@Transactional
	@Modifying
	public void updateSpiceJetData(int id, @Param ("makemytripflightName")String makemytripflightName, String makemytripflightFrom,
			String makemytripflightTo, String makemytripflightTime, String makemytripjourneyDate,
			double makemytripticketPrice);

	
	public void deleteByFlightId(int makemytripflightId);
}
