package com.example.demoapp.service;

import com.example.demoapp.entity.Customer;
import com.example.demoapp.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void update(Customer newCustomer, Long id) {
        Customer oldCustomer = customerRepository.getCustomerById(id);
        if(oldCustomer.getId() != null){
            if(newCustomer.getFirstName() == null)
                newCustomer.setFirstName(oldCustomer.getFirstName());

            if(newCustomer.getLastName() == null)
                newCustomer.setLastName(oldCustomer.getLastName());

            if(newCustomer.getEmail() == null)
                newCustomer.setEmail(oldCustomer.getEmail());
            customerRepository.save(newCustomer);
        }
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.getCustomerById(id);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}
