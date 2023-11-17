package com.goldeng.commissionstracker.service;

import java.util.List;

import com.goldeng.commissionstracker.model.Package;

public interface IPackageService {
    public Package createPackage(Package pcg);   

    public Package getPackageById(Long id);

    public List<Package> getPackages();

    public Package updatePackage();

    public Package deletePackage(Long id);
}
