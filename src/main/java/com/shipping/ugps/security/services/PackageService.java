package com.shipping.ugps.security.services;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipping.ugps.models.PackageDetails;
import com.shipping.ugps.repository.PackageDetailsRepository;
import com.shipping.ugps.request.LocationRequest;
import com.shipping.ugps.request.PackageDetailsRequest;
import com.shipping.ugps.response.PackageResponse;

@Service
public class PackageService {
	
	@Autowired
    private PackageDetailsRepository packageRepo;

    private static final double EARTH_RADIUS_MILES = 3958.8;

	public List<PackageResponse> findNearbyPackages(LocationRequest location) {
		List<PackageDetails> allPackages = packageRepo.findAll();

		return allPackages.stream().map(pkg -> {
			double distance = calculateDistance(location.getLat(), location.getLongi(), pkg.getFromLat(), pkg.getFromLong());

			if (distance <= 5) {
				double cost = calculateDistanceCost(distance);
				return new PackageResponse(pkg.getPackageId(), pkg.getFromAddress(), pkg.getToAddress(), distance, cost, pkg.getStatus());
			} else {
				return null;
			}
		}).filter(Objects::nonNull).collect(Collectors.toList());
	}

	private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {//Haversine dist calc
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);

		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dLon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));
		return EARTH_RADIUS_MILES * c;
	}

	private double calculateDistanceCost(double distanceMiles) {
	    double baseFare = 5.0; // flat fee in USD
	    double ratePerMile = 2.0; // cost per mile
	    return baseFare + (distanceMiles * ratePerMile);
	}
	
	public PackageDetails addPackage(PackageDetailsRequest request) {
	    PackageDetails pkg = new PackageDetails();
	    pkg.setFromLat(request.getFromLat());
	    pkg.setFromLong(request.getFromLong());
	    pkg.setToLat(request.getToLat());
	    pkg.setToLong(request.getToLong());

	    pkg.setFromAddress(request.getFromAddress());
	    pkg.setToAddress(request.getToAddress());

	    pkg.setFromZipCode(request.getFromZipCode());
	    pkg.setToZipCode(request.getToZipCode());

	    pkg.setDeliveryDate(request.getDeliveryDate());
	    pkg.setStatus(request.getStatus());

	    pkg.setDeliveryTimeinHours(1.0);

	    return packageRepo.save(pkg);
	}
}