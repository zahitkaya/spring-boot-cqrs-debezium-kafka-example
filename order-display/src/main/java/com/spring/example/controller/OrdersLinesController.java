package com.spring.example.controller;

import com.spring.example.document.OrderLine;
import com.spring.example.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order-lines")
public class OrdersLinesController {

    private final SearchService<OrderLine> searchService;

    @GetMapping("/search")
    public List<OrderLine> search(@RequestParam String key, @RequestParam String value) throws IOException {
        return searchService.searchCustomerByFieldValue(key, value, "order_lines",OrderLine.class);
    }
}
