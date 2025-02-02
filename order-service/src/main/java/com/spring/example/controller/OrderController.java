package com.spring.example.controller;

import com.spring.example.entity.Order;
import com.spring.example.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    
    private final OrderService orderService;

    @GetMapping("/get/{id}")
    public Order get(@PathVariable Long id) {
        return orderService.getById(id);
    }

    @PostMapping("/save")
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    @PutMapping("/update/{id}")
    public Order update(@PathVariable Long id, @RequestBody Order order) {
        return orderService.update(id, order);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        orderService.delete(id);
    }
}
