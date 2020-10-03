package tw.cafe.springbucks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.cafe.springbucks.model.CoffeeOrder;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
