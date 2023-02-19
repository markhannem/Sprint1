package domain.airport;

import domain.Entity;
import domain.city.City;
import jakarta.persistence.*;

@Entity
@Table(name = "Airport")
public class Airport {
    @Id
    @SequenceGenerator(name = "airport_sequence", sequenceName = "airport_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "airport_sequence")
    private long id;

    @Column(name = "airport_name")
    private String name;

    @Column(name = "airport_code")
    private String code;

    @ManyToOne
    private City city;

    public Airport() {
    }

    public Airport(String jfk, String newYork, String usa) {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCity(String valueOf) {
    }
}
