package tw.cafe.springbucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.cafe.springbucks.model.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
