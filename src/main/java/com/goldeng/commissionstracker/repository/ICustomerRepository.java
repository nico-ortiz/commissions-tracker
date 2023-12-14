package com.goldeng.commissionstracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldeng.commissionstracker.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    
    Optional<Customer> findCustomerByEmail(String email);
}