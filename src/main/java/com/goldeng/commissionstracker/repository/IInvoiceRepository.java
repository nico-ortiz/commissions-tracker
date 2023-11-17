package com.goldeng.commissionstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldeng.commissionstracker.model.Invoice;

@Repository
public interface IInvoiceRepository extends JpaRepository<Invoice, Long>{
    
}