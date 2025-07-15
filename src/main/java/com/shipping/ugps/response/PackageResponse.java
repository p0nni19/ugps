package com.shipping.ugps.response;

public class PackageResponse {
	
	private Long packageId;
	private String addressA;
	private String addressB;
	private double distanceInMiles;
	private double estCost;
	private String status;
	
	public PackageResponse(Long packageId, String addressA, String addressB, double distanceInMiles, double estCost, String status) {
		super();
		this.packageId = packageId;
		this.addressA = addressA;
		this.addressB = addressB;
		this.distanceInMiles = distanceInMiles;
		this.estCost = estCost;
		this.status = status;
	}
	
	public Long getPackageId() {
		return packageId;
	}
	
	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}
	
	public String getAddressA() {
		return addressA;
	}
	
	public void setAddressA(String addressA) {
		this.addressA = addressA;
	}
	
	public String getAddressB() {
		return addressB;
	}
	
	public void setAddressB(String addressB) {
		this.addressB = addressB;
	}
	
	public double getDistanceInMiles() {
		return distanceInMiles;
	}
	
	public void setDistanceInMiles(double distanceInMiles) {
		this.distanceInMiles = distanceInMiles;
	}
	
	public double getEstCost() {
		return estCost;
	}
	
	public void setEstCost(double estCost) {
		this.estCost = estCost;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
