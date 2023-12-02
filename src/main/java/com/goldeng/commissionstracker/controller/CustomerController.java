package com.goldeng.commissionstracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goldeng.commissionstracker.model.Customer;
import com.goldeng.commissionstracker.service.ICustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    @Autowired
    private ICustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<Customer>(customerService.createCustomer(customer), HttpStatus.CREATED);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long customerId) {
        return new ResponseEntity<Customer>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }

    @GetMapping("?email=customerEmail")
    public ResponseEntity<Customer> getCustomerByEmail(@RequestParam String customerEmail) {
        return new ResponseEntity<Customer>(customerService.getCustomerByEmail(customerEmail), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<Customer>> getCustomers() {
        return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long customerId) {
        return new ResponseEntity<Customer>(customerService.deleteCustomerById(customerId), HttpStatus.ACCEPTED);
    }
}
