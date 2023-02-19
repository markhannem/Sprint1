package domain.aircraft;

import domain.airport.Airport;
import domain.passenger.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AircraftTest {

    private Aircraft aircraft;

    @BeforeEach
    public void setUp() {
        aircraft = new Aircraft("Boeing 737", "Delta", 200);
    }

    @org.junit.Test
    @Test
    public void testGetId() {
        assertNotNull(aircraft.getId());
    }

    @Test
    public void testGetModel() {
        assertEquals("Boeing 737", aircraft.getModel());
    }

    @Test
    public void testGetAirlineName() {
        assertEquals("Delta", aircraft.getAirlineName());
    }

    @Test
    public void testGetNumberOfSeats() {
        assertEquals(200, aircraft.getNumberOfSeats());
    }

    @Test
    public void testGetPassengers() {
        Passenger passenger1 = new Passenger("John", "Doe", "johndoe@example.com");
        Passenger passenger2 = new Passenger("Jane", "Doe", "janedoe@example.com");

        Set<Passenger> passengers = new HashSet<>();
        passengers.add(passenger1);
        passengers.add(passenger2);

        aircraft.setPassengers(passengers);

        assertEquals(passengers, aircraft.getPassengers());
    }

    @Test
    public void testGetAirports() {
        Airport airport1 = new Airport("JFK", "New York", "USA");
        Airport airport2 = new Airport("LAX", "Los Angeles", "USA");

        Set<Airport> airports = new HashSet<>();
        airports.add(airport1);
        airports.add(airport2);

        aircraft.setAirports(airports);

        assertEquals(airports, aircraft.getAirports());
    }
}