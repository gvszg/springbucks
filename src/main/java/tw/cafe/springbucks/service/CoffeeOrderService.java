package tw.cafe.springbucks.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tw.cafe.springbucks.model.Coffee;
import tw.cafe.springbucks.model.CoffeeOrder;
import tw.cafe.springbucks.model.OrderState;
import tw.cafe.springbucks.repository.CoffeeOrderRepository;

import java.util.ArrayList;
import java.util.Arrays;

@Slf4j
@Service
@Transactional
public class CoffeeOrderService {
    @Autowired
    private CoffeeOrderRepository coffeeOrderRepository;

    public CoffeeOrder createOrder(String customer, Coffee...coffees) {
        CoffeeOrder coffeeOrder = new CoffeeOrder();
        coffeeOrder.setCustomer(customer);
        coffeeOrder.setItems(new ArrayList<>(Arrays.asList(coffees)));
        coffeeOrder.setState(OrderState.INIT);
        coffeeOrderRepository.save(coffeeOrder);
        log.info("New Order: {}", coffeeOrder);
        return coffeeOrder;
    }

    public boolean updateState(CoffeeOrder coffeeOrder, OrderState state) {
        if (state.compareTo(coffeeOrder.getState()) <= 0) {
            log.warn("Wrong State Order: {}, {}", state, coffeeOrder.getState());
            return false;
        }

        coffeeOrder.setState(state);
        coffeeOrderRepository.save(coffeeOrder);
        log.info("Updated Order: {}", coffeeOrder);
        return true;
    }
}
