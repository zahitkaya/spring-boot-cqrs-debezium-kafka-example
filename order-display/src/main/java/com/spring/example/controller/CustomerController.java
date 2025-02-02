package com.spring.example.controller;

import com.spring.example.document.Customer;
import com.spring.example.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final SearchService<Customer> searchService;

    @GetMapping("/search")
    public List<Customer> search(@RequestParam String key, @RequestParam String value) throws IOException {
        return searchService.searchCustomerByFieldValue(key, value, "customers",Customer.class);
    }
}
