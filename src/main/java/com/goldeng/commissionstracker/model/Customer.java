package com.goldeng.commissionstracker.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    
    @Column(unique = true)
    private String email;
    
    @Column(nullable = false)
    private String password;
    
    private String address;
    
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    private List<Commission> commissions;

    public boolean addCommission(Commission c) {
        return this.commissions.add(c);
    }

    public boolean removeCommission(Commission c) {
        return this.commissions.remove(c);
    }
}