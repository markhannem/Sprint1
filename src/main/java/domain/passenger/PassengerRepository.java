package domain.passenger;

import domain.aircraft.Aircraft;
import domain.city.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    List<Passenger> findByCity(City city);
    List<Passenger> findByAircraftsContaining(Aircraft aircraft);
}