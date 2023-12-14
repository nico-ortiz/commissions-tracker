package com.goldeng.commissionstracker.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.goldeng.commissionstracker.dto.CustomerRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@JsonIgnoreProperties(value = {"commissions"})
public class Customer {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    private String address;
    
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<Commission> commissions;

    public Customer(CustomerRequest customerRequest) {
        this.firstName = customerRequest.firstName();
        this.lastName = customerRequest.lastName();
        this.email = customerRequest.email();
        this.password = customerRequest.password();
        this.address = customerRequest.address();
        this.phoneNumber = customerRequest.phoneNumber();
    }

    public boolean addCommission(Commission c) {
        return this.commissions.add(c);
    }

    public boolean removeCommission(Commission c) {
        return this.commissions.remove(c);
    }
}