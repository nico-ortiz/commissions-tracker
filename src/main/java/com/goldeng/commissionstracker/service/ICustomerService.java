package com.goldeng.commissionstracker.service;

import java.util.List;

import com.goldeng.commissionstracker.model.Customer;

public interface ICustomerService {
    
    public Customer createCustomer(Customer customer);

    public Customer getCustomerByEmail(String email);

    public List<Customer> getCustomers();

    public Customer updateCustomer(Long id, Customer customer);

    public Customer deleteCustomerById(Long id);
}
