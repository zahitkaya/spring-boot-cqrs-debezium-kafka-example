package com.spring.example.service;

import com.spring.example.entity.Order;
import com.spring.example.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService implements CrudService<Order> {

    private final OrderRepository orderRepository;

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order save(Order entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Order update(Long id, Order entity) {
        entity.setId(id);
        return save(entity);
    }

    @Override
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}
