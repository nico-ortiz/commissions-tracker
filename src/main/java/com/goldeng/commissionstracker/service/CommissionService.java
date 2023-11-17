package com.goldeng.commissionstracker.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.goldeng.commissionstracker.model.Commission;
import com.goldeng.commissionstracker.repository.ICommissionRepository;

public class CommissionService implements ICommissionService{

    private  ICommissionRepository commissionRepository;

	@Override
	public Commission createCommission(Commission commission) {
        return commissionRepository.save(commission);
	}

	@Override
	public Commission getCommissionById(Long id) {
        return commissionRepository.findById(id).get();
	}

	@Override
	public List<Commission> getCommissions() {
        return commissionRepository.findAll();
	}

	@Override
	public Commission updateCommission(Long id, Commission commission) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateCommission'");
	}

	@Override
	public Commission deleteCommission(Long id) {
        Commission commissionDeleted = getCommissionById(id);
        commissionRepository.deleteById(id);
        return commissionDeleted;
	}

	@Override
	public List<Commission> getCommissionsFromADate(Date date) {
        List<Commission> commissions = getCommissions();
        return commissions.stream().filter(commission -> 
            commission.getDate().compareTo(date) == 0)
            .collect(Collectors.toList());
	}
    
}
