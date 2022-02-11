package com.example.demoapp.repository;

import com.example.demoapp.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(
            value = "Select * from Customer c where c.id=:theId",
            nativeQuery = true
    )
    Customer getCustomerById(Long theId);

}
