package com.spring.example.service;

public interface CrudService <K>{

    K getById(Long id);
    K save(K entity);
    K update(Long id, K entity);
    void delete(Long id);
}
