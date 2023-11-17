package com.goldeng.commissionstracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldeng.commissionstracker.model.Package;

@Repository
public interface IPackageRepository extends JpaRepository<Package, Long>{
    
}