package com.FlightReservation1.Repo;

import com.FlightReservation1.Entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findByLeavingFromAndGoingToAndDepartureDateAndArrivalDate(String leavingFrom, String goingTo,
                                                                           LocalDate departureDate, LocalDate arrivalDate);
}
