package com.spring.example.bootstrap;

import com.spring.example.entity.Customer;
import com.spring.example.entity.Order;
import com.spring.example.entity.OrderLine;
import com.spring.example.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bootstrap implements ApplicationRunner {

    private final OrderLineRepository orderLineRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for(int i = 0; i<100; i++){
            OrderLine orderLine = OrderLine.builder()
                    .quantity(i)
                    .orderId(Order.builder()
                            .name("order-" + i)
                            .customerId(Customer.builder()
                                    .contactData("555555"+i)
                                    .name("name-" + i).build()).build()).build();
            orderLineRepository.save(orderLine);
        }

    }
}
