package com.FlightReservation1.Service;

import com.FlightReservation1.Entity.Flight;
import com.FlightReservation1.Repo.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public List<Flight> getFlightsByCriteria(String leavingFrom, String goingTo,
                                             LocalDate departureDate, LocalDate arrivalDate) {
        return flightRepository.findByLeavingFromAndGoingToAndDepartureDateAndArrivalDate(leavingFrom, goingTo,
                departureDate, arrivalDate);
    }
}
