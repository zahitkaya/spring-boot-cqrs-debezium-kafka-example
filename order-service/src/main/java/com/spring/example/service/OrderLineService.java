package com.spring.example.service;

import com.spring.example.entity.OrderLine;
import com.spring.example.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineService implements CrudService<OrderLine>{

    private final OrderLineRepository orderLineRepository;

    @Override
    public OrderLine getById(Long id) {
        return orderLineRepository.findById(id).orElse(null);
    }

    @Override
    public OrderLine save(OrderLine entity) {
        return orderLineRepository.save(entity);
    }

    @Override
    public OrderLine update(Long id, OrderLine entity) {
        entity.setId(id);
        return save(entity);
    }

    @Override
    public void delete(Long id) {
        orderLineRepository.deleteById(id);
    }
}
