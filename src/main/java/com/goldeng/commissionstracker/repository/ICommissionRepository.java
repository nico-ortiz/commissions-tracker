package com.goldeng.commissionstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldeng.commissionstracker.model.Commission;

@Repository
public interface ICommissionRepository extends JpaRepository<Commission, Long> {
    
}