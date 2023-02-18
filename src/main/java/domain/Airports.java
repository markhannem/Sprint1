package domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Airports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String city;
    private String country;
    private String iataCode;
    private String type;


    public Airports(long id, String name, String city, String country, String iataCode, String type, String source) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
        this.iataCode = iataCode;

        this.type = type;

    }

    public Airports() {
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getIataCode() {
        return iataCode;
    }

    public String getType() {
        return type;
    }


}