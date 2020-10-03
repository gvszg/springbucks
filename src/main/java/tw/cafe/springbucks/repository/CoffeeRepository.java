package tw.cafe.springbucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.cafe.springbucks.model.Coffee;

import java.util.Optional;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    Optional<Coffee> findOneByName(String name);
}
