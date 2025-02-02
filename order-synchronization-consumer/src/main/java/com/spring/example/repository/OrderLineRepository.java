package com.spring.example.repository;

import com.spring.example.document.Customer;
import com.spring.example.document.OrderLine;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OrderLineRepository extends ElasticsearchRepository<OrderLine, Long> {
}
