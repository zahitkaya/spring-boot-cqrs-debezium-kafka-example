package com.spring.example.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.example.document.Customer;
import com.spring.example.document.Order;
import com.spring.example.document.OrderLine;
import com.spring.example.repository.CustomerRepository;
import com.spring.example.repository.OrderLineRepository;
import com.spring.example.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DebeziumConsumer {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final OrderLineRepository orderLineRepository;
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "debezium-customers.public.customers", groupId = "customer-listener") //debeziumdan gelen eventler
    public void listenCustomer(ConsumerRecord<String, String> record) throws JsonProcessingException {
        log.info("consuming customer");
        Customer customer = objectMapper.readValue(record.value(), Customer.class);
        customerRepository.save(customer);
    }

    @KafkaListener(topics = "debezium-orders.public.orders", groupId = "order-listener") //debeziumdan gelen eventler
    public void listenOrder(ConsumerRecord<String, String> record) throws JsonProcessingException {
        log.info("consuming order");
        Order order = objectMapper.readValue(record.value(), Order.class);
        orderRepository.save(order);
    }

    @KafkaListener(topics = "debezium-order-lines.public.order_lines", groupId = "order-lines-listener") //debeziumdan gelen eventler
    public void listenOrderLines(ConsumerRecord<String, String> record) throws JsonProcessingException {
        log.info("consuming order lines");
        OrderLine order = objectMapper.readValue(record.value(), OrderLine.class);
        orderLineRepository.save(order);
    }
}
