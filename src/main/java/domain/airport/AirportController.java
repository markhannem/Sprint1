package domain.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AirportController {
    @Autowired
    private AirportRepository repo;

    @GetMapping("/airports")
    public List<Airport> getAllAirports() {
        return (List<Airport>) repo.findAll();
    }

    @PostMapping("/airport")
    public void createAirport(@RequestBody Airport airport) {
        repo.save(airport);
    }

    @PutMapping("/airport/{id}")
    public void updateAirport(@PathVariable String id, @RequestBody Airport airport, HttpServletResponse response) {
        Optional<Airport> returnValue = repo.findById(Long.parseLong(id));
        Airport airportToUpdate;

        if (returnValue.isPresent()) {
            airportToUpdate = returnValue.get();

            airportToUpdate.setName(airport.getName());
            airportToUpdate.setCode(airport.getCode());

            repo.save(airportToUpdate);
        } else {
            try {
                response.sendError(404, "Airport with id: " + airport.getId() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}