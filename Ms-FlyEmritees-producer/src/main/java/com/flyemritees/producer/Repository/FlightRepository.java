package com.flyemritees.producer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.flyemritees.producer.model.Flight;

public interface FlightRepository extends JpaRepository<Flight,Integer> {

}
