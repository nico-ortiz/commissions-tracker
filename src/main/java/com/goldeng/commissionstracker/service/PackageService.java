package com.goldeng.commissionstracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldeng.commissionstracker.model.Package;
import com.goldeng.commissionstracker.repository.IPackageRepository;

@Service
public class PackageService implements IPackageService {

    @Autowired
    private IPackageRepository packageRepository;

	@Override
	public Package createPackage(Package pcg) {
        return packageRepository.save(pcg); 
	}

	@Override
	public Package getPackageById(Long id) {
		return packageRepository.findById(id).get();
	}

	@Override
	public List<Package> getPackages() {
		return packageRepository.findAll();
	}

	@Override
	public Package updatePackage() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updatePackage'");
	}

	@Override
	public Package deletePackage(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deletePackage'");
	}
    
}
