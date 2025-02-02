package com.spring.example.repository;

import com.spring.example.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

     Customer findCustomerByContactData(String contactData);
}
