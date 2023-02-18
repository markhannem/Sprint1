package rest.domain;


import domain.Airports;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportsRepository extends JpaRepository<Airports, Long> {
}