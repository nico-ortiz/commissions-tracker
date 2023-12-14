package com.goldeng.commissionstracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldeng.commissionstracker.dto.CustomerRequest;
import com.goldeng.commissionstracker.exception.IdNotFoundException;
import com.goldeng.commissionstracker.model.Customer;
import com.goldeng.commissionstracker.repository.ICustomerRepository;
import com.goldeng.commissionstracker.validators.ObjectsValidator;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

	@Autowired
	private ObjectsValidator<CustomerRequest> customerValidator;

	@Override
	public Customer createCustomer(CustomerRequest customerDTO) {
		customerValidator.validate(customerDTO);
		Customer newCustomer = new Customer(customerDTO);
		return customerRepository.save(newCustomer);
	}

	@Override 
	public Customer getCustomerById(Long customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new IdNotFoundException("Usuario con id:" + customerId + " no encontrado."));
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		return customerRepository.findCustomerByEmail(email).orElse(null);
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
		Customer customerDeleted = this.getCustomerById(id);
        customerRepository.deleteById(id);
        return customerDeleted;
	}   
}