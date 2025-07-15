package com.shipping.ugps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shipping.ugps.models.PackageDetails;

@Repository
public interface PackageDetailsRepository extends JpaRepository<PackageDetails, Long> {
	
}