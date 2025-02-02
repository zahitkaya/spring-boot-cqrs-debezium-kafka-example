package com.spring.example.controller;

import com.spring.example.document.Order;
import com.spring.example.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrdersController {

    private final SearchService<Order> searchService;

    @GetMapping("/search")
    public List<Order> search(@RequestParam String key, @RequestParam String value) throws IOException {
        return searchService.searchCustomerByFieldValue(key, value, "orders",Order.class);
    }
}
