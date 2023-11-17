package com.goldeng.commissionstracker.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Commission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commissionId;

    @Column(nullable = false)
    private String description;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
    private Date date;

    private Double price;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String destinationName;

    @Column(nullable = false)
    private String destinationPhoneNumber;

    @Enumerated(EnumType.STRING)
    private Status commissionStatus;

    private String visitingHours;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "commission")
    private List<Package> packages;

    public boolean addPackage(Package p) {
        return this.packages.add(p);
    }

    public boolean removePackage(Package p) {
        return this.packages.remove(p);
    }
}