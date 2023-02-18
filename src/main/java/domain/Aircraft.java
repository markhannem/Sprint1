package domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;

    private String airlineName;

    private String NumberOfSeats;

    public Aircraft(long id, String model, String airlineName, String NumberOfSeats) {
        this.id = id;
        this.model = model;
        this.airlineName = airlineName;
        this.NumberOfSeats = NumberOfSeats;
    }

    public Aircraft() {
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

    public void setNumberOfSeats(String NumberOfSeats) {
        this.NumberOfSeats = NumberOfSeats;
    }

    public long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getNumberOfSeats() {
        return NumberOfSeats;
    }


}
