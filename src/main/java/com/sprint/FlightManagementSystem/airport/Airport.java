package com.sprint.FlightManagementSystem.airport;

import com.sprint.FlightManagementSystem.city.City;
import jakarta.persistence.*;

@Entity
public class Airport {
    @Id
    @SequenceGenerator(name = "airport_sequence", sequenceName = "airport_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "airport_sequence")
    private Long id;
    private String name;
    private String code;

    public Airport() {
    }

    @ManyToOne
    private City city;



    public void setId(Long id) {
        this.id = id;
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
    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }

}

