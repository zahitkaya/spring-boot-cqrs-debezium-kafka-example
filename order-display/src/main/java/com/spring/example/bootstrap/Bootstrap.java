package com.spring.example.bootstrap;

import com.spring.example.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Bootstrap implements ApplicationRunner {

    private final CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(customerRepository.findAll().toString());
    }
}
