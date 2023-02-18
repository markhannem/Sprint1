package controller;

import domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.domain.CityRepository;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @PostMapping
    public City createCity(@RequestBody City city) {
        return cityRepository.save(city);
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("City not found with id " + id));
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable Long id, @RequestBody City cityRequest) {
        return cityRepository.findById(id)
                .map(city -> {
                    city.setName(cityRequest.getName());
                    city.setState(cityRequest.getState());
                    city.setPopulation(cityRequest.getPopulation());
                    return cityRepository.save(city);
                }).orElseThrow(() -> new ResourceNotFoundException("City not found with id " + id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable Long id) {
        return cityRepository.findById(id)
                .map(city -> {
                    cityRepository.delete(city);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("City not found with id " + id));
    }
}