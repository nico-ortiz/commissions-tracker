package com.goldeng.commissionstracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldeng.commissionstracker.model.Customer;
import com.goldeng.commissionstracker.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		return customerRepository.findByEmail(email).get();
	}

	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Long id, Customer customer) {
		Customer customerUpdated = Customer.builder()
            .customerId(id)
            .firstName(customer.getFirstName())
            .lastName(customer.getLastName())
            .email(customer.getEmail())
            .password(customer.getPassword())
            .address(customer.getAddress())
            .phoneNumber(customer.getPhoneNumber())
            .build();

        return customerRepository.save(customerUpdated);
	}

	@Override
	public Customer deleteCustomerById(Long id) {
        Customer customerDeleted = customerRepository.findById(id).get();
        customerRepository.deleteById(id);
        return customerDeleted;
	}
    
}
