package domain.aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.domain.AircraftRepository;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftRepository repo;

    @GetMapping("/aircraft")
    public List<Aircraft> getAllAircraft() {
        return (List<Aircraft>) repo.findAll();
    }

    @PostMapping("/aircraft")
    public void createAircraft(@RequestBody Aircraft aircraft) {
        repo.save(aircraft);
    }

    @PutMapping("/aircraft/{id}")
    public void updateAircraft(@PathVariable String id, @RequestBody Aircraft aircraft, HttpServletResponse response) {
        Optional<Aircraft> returnValue = repo.findById(Long.parseLong(id));
        Aircraft aircraftToUpdate;

        if (returnValue.isPresent()) {
            aircraftToUpdate = returnValue.get();

            aircraftToUpdate.setModel(aircraft.getModel());
            aircraftToUpdate.setAirlineName(aircraft.getAirlineName());
            aircraftToUpdate.setNumberOfSeats(aircraft.getNumberOfSeats());

            repo.save(aircraftToUpdate);
        } else {
            try {
                response.sendError(404, "Aircraft with id: " + aircraft.getId() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}