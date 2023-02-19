package rest.domain;


import domain.airport.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportsRepository extends JpaRepository<Airport, Long> {
}