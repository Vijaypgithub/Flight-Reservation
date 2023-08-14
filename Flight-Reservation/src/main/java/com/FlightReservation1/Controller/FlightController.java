package com.FlightReservation1.Controller;


import com.FlightReservation1.Entity.Flight;
import com.FlightReservation1.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

   //http://localhost:8080/flights
    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight addedFlight = flightService.addFlight(flight);
        return new ResponseEntity<>(addedFlight, HttpStatus.CREATED);
    }

    //http://localhost:8080/flights
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.getAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }


    //http://localhost:8080/flights/search?leavingFrom=___&goingTo=___&departureDate=___&arrivalDate=___
    @GetMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(@RequestParam("leavingFrom") String leavingFrom,
                                                      @RequestParam("goingTo") String goingTo,
                                                      @RequestParam("departureDate") String departureDate,
                                                      @RequestParam("arrivalDate") String arrivalDate) {
        LocalDate departure = LocalDate.parse(departureDate);
        LocalDate arrival = LocalDate.parse(arrivalDate);
        List<Flight> flights = flightService.getFlightsByCriteria(leavingFrom, goingTo, departure, arrival);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
}
