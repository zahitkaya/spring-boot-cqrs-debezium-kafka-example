package com.spring.example.repository;

import com.spring.example.document.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface CustomerRepository extends ElasticsearchRepository<Customer, Long> {
}
