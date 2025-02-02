package com.spring.example.service;

import com.spring.example.entity.Customer;
import com.spring.example.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService implements CrudService<Customer> {

    private final CustomerRepository customerRepository;

    @Override
    public Customer getById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer entity) {
        return customerRepository.save(entity);
    }

    @Override
    public Customer update(Long id, Customer entity) {
        entity.setId(id);
        return save(entity);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
