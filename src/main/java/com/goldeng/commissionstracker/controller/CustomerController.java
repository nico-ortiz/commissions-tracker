package com.goldeng.commissionstracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goldeng.commissionstracker.model.Customer;
import com.goldeng.commissionstracker.service.ICustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
    @Autowired
    private ICustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }
}
