package domain.aircraft;

import domain.Entity;
import domain.airport.Airport;
import domain.passenger.Passenger;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name = "Aircraft")
public class Aircraft {

    @Id
    @SequenceGenerator(name = "aircraft_sequence", sequenceName = "aircraft_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "aircraft_sequence")
    private Long id;

    @Column(name = "Model")
    private String model;

    @Column(name = "AirlineName")
    private String airlineName;

    @Column(name = "NumberOfSeats")
    private int numberOfSeats;

    @ManyToMany(mappedBy = "aircraft")
    private Set<Passenger> passengers;

    @ManyToMany
    @JoinTable(name = "Aircraft_Airports",
            joinColumns = @JoinColumn(name = "Aircraft_Id"),
            inverseJoinColumns = @JoinColumn(name = "Airport_Id"))
    private Set<Airport> airports;

    public Aircraft() {
    }

    public Aircraft(String model, String airlineName, int numberOfSeats) {
        this.model = model;
        this.airlineName = airlineName;
        this.numberOfSeats = numberOfSeats;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Set<Airport> getAirports() {
        return airports;
    }

    public void setAirports(Set<Airport> airports) {
        this.airports = airports;
    }
}