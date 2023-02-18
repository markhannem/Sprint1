package rest.domain;

import domain.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengersRepository extends JpaRepository<Passengers, Long> {
}