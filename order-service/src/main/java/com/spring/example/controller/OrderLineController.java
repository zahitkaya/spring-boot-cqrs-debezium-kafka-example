package com.spring.example.controller;

import com.spring.example.entity.OrderLine;
import com.spring.example.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orderLine")
@RequiredArgsConstructor
public class OrderLineController {
    
    private final OrderLineService orderLineService;

    @GetMapping("/get/{id}")
    public OrderLine get(@PathVariable Long id) {
        return orderLineService.getById(id);
    }

    @PostMapping("/save")
    public OrderLine save(@RequestBody OrderLine orderLine) {
        return orderLineService.save(orderLine);
    }

    @PutMapping("/update/{id}")
    public OrderLine update(@PathVariable Long id, @RequestBody OrderLine orderLine) {
        return orderLineService.update(id, orderLine);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        orderLineService.delete(id);
    }
}
