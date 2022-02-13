package com.example.demoapp.service;

import com.example.demoapp.entity.Customer;

import java.util.List;

public interface CustomerService {

    void save(Customer customer);
    void update(Customer customer);
    void update(Customer customer,Long id);
    List<Customer> getCustomers();
    Customer getCustomerById(Long id);
    void delete(Long id);

}
