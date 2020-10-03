package tw.cafe.springbucks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tw.cafe.springbucks.model.Coffee;
import tw.cafe.springbucks.model.CoffeeOrder;
import tw.cafe.springbucks.model.OrderState;
import tw.cafe.springbucks.repository.CoffeeRepository;
import tw.cafe.springbucks.service.CoffeeOrderService;
import tw.cafe.springbucks.service.CoffeeService;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Optional;

@Slf4j
@SpringBootApplication
public class SpringbucksApplication implements CommandLineRunner {
	@Autowired
	private CoffeeRepository coffeeRepository;
	@Autowired
	private CoffeeService coffeeService;
	@Autowired
	private CoffeeOrderService coffeeOrderService;

	public static void main(String[] args) {
		SpringApplication.run(SpringbucksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    log.info("All Coffee: {}", coffeeRepository.findAll());

	    Optional<Coffee> latte = coffeeService.findOneCoffee("Latte");
	    if (latte.isPresent()) {
			CoffeeOrder order = coffeeOrderService.createOrder("CC", latte.get());
			log.info("Update INIT to PAID: {}", coffeeOrderService.updateState(order, OrderState.PAID));
			log.info("Update PAID to INIT: {}", coffeeOrderService.updateState(order, OrderState.INIT));
		}
	}
}
