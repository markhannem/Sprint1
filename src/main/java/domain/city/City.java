package domain.city;

import domain.Entity;
import domain.airport.Airport;
import domain.passenger.Passenger;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Cities")
public class City {

    @Id
    @SequenceGenerator(name = "city_sequence", sequenceName = "city_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "city_sequence")
    private Long id;

    @Column(name = "city_name")
    private String name;

    @Column(name = "state")
    private String state;

    @Column(name = "population")
    private int population;

    @OneToMany(mappedBy = "city")
    private List<Airport> airports;

    @OneToMany(mappedBy = "city")
    private List<Passenger> passengers;

    public City() {
        airports = new ArrayList<>();
    }

    public City(String name, String state, int population) {
        this.name = name;
        this.state = state;
        this.population = population;
        airports = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void addAirport(Airport airport) {
        airport.setCity(String.valueOf(this));
        airports.add(airport);
    }

    public void removeAirport(Airport airport) {
        airports.remove(airport);
        airport.setCity(null);
    }

}