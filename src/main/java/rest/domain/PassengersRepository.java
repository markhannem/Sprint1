package rest.domain;

import domain.passenger.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengersRepository extends JpaRepository<Passenger, Long> {
}