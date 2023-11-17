package com.goldeng.commissionstracker.service;

import java.util.Date;
import java.util.List;

import com.goldeng.commissionstracker.model.Commission;

public interface ICommissionService {
    
    public Commission createCommission(Commission commission);

    public Commission getCommissionById(Long id);

    public List<Commission> getCommissions();

    public Commission updateCommission(Long id, Commission commission);

    public Commission deleteCommission(Long id);

    public List<Commission> getCommissionsFromADate(Date date);
}
