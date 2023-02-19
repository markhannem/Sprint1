package domain.passenger;

import domain.city.City;
import domain.aircraft.Aircraft;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Passengers")
public class Passenger {

    @Id
    @SequenceGenerator(name = "passenger_sequence", sequenceName = "passenger_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "passenger_sequence")
    private Long id;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "City_id")
    private City city;

    @ManyToMany(mappedBy = "passengers")
    private List<Aircraft> aircraft;

    public Passenger(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public Passenger(String name, City city) {
        this.name = name;
        this.city = city;
    }

    public Passenger(String john, String doe, String s) {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public String getName() {
        return name;
    }

    public City getCity() {
        return city;
    }

    public List<Aircraft> getAircrafts() {
        return aircraft;
    }
}