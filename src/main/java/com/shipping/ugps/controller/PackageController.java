package com.shipping.ugps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shipping.ugps.models.PackageDetails;
import com.shipping.ugps.request.LocationRequest;
import com.shipping.ugps.request.PackageDetailsRequest;
import com.shipping.ugps.response.PackageResponse;
import com.shipping.ugps.security.services.PackageService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/packages")
public class PackageController {
	
	@Autowired
    PackageService packageService;
	
	@PostMapping
	public ResponseEntity<PackageDetails> addPackage(@RequestBody PackageDetailsRequest request) {
	    PackageDetails saved = packageService.addPackage(request);
	    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
	}

    @PostMapping("/nearby")
    public ResponseEntity<List<PackageResponse>> getNearbyPackages(@RequestBody LocationRequest location) {
        List<PackageResponse> nearbyPackages = packageService.findNearbyPackages(location);
        return ResponseEntity.ok(nearbyPackages);
    }
}