package com.example.demoapp.controller;

import com.example.demoapp.entity.Customer;
import com.example.demoapp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/customer")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customer/{id}")
    public String getCustomerById(@PathVariable Long id){
        if(customerService.getCustomerById(id)==null)
            return String.valueOf(new NullPointerException("There is no customer!"));
        return String.valueOf(customerService.getCustomerById(id));
    }

    @PostMapping("/customer")
    public String createCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return "Saved successfully!"+customer.toString();
    }

    @PutMapping("/customer")
    public String updateCustomer(@RequestBody Customer customer){
        customerService.update(customer);
        return "Customer is updated!"+customer.toString();
    }

    @PutMapping("/customer/{id}")
    public String updateCustomer(@PathVariable Long id, @RequestBody Customer customer){
        customerService.update(customer, id);
        return "Customer is Successfully UPDATED!";
    }

    @DeleteMapping("/customer/{id}")
    public String deleteCustomer(@PathVariable Long id){
        if(customerService.getCustomerById(id)==null)
            return String.valueOf(new NullPointerException("This id not found "+id));
        else customerService.delete(id);
        return "Deleted Successfully!..";
    }
}
