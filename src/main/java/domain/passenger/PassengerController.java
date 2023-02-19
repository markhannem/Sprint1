package domain.passenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class PassengerController {
    @Autowired
    private PassengerRepository repo;

    @GetMapping("/passengers")
    public List<Passenger> getAllPassengers() {
        return (List<Passenger>) repo.findAll();
    }

    @PostMapping("/passenger")
    public void createPassenger(@RequestBody Passenger passenger) {
        repo.save(passenger);
    }

    @PutMapping("/passenger/{id}")
    public void updatePassenger(@PathVariable String id, @RequestBody Passenger passenger, HttpServletResponse response) {
        Optional<Passenger> returnValue = repo.findById(Long.parseLong(id));
        Passenger passengerToUpdate;

        if (returnValue.isPresent()) {
            passengerToUpdate = returnValue.get();

            passengerToUpdate.setName(passenger.getName());
            passengerToUpdate.setCity(passenger.getCity());
            passengerToUpdate.setAircraft(passenger.getAircrafts());

            repo.save(passengerToUpdate);
        } else {
            try {
                response.sendError(404, "Passenger with id: " + passenger.getId() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @GetMapping("/passenger/{id}")
    public Passenger getPassengerById(@PathVariable String id) {
        Optional<Passenger> passenger = repo.findById(Long.parseLong(id));
        return passenger.orElse(null);
    }
}