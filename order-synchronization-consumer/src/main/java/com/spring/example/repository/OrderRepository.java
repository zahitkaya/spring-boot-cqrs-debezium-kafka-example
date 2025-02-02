package com.spring.example.repository;

import com.spring.example.document.Order;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface OrderRepository extends ElasticsearchRepository<Order, Long> {
}
