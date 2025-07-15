package com.shipping.ugps.response;

public class PackageResponse {
	
	private Long packageId;
	private double fromLat;
	private double toLat;
	private double fromLong;
	private double toLong;
	private String addressA;
	private String addressB;
	private double distanceInMiles;
	private double estCost;
	private String status;
	
	
	public PackageResponse(Long packageId, double fromLat, double fromLong, double toLat, double toLong,
			String addressA, String addressB, double distanceInMiles, double estCost, String status) {
		super();
		this.packageId = packageId;
		this.fromLat = fromLat;
		this.toLat = toLat;
		this.fromLong = fromLong;
		this.toLong = toLong;
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
	
	public double getFromLat() {
		return fromLat;
	}

	public void setFromLat(double fromLat) {
		this.fromLat = fromLat;
	}

	public double getToLat() {
		return toLat;
	}

	public void setToLat(double toLat) {
		this.toLat = toLat;
	}

	public double getFromLong() {
		return fromLong;
	}

	public void setFromLong(double fromLong) {
		this.fromLong = fromLong;
	}

	public double getToLong() {
		return toLong;
	}

	public void setToLong(double toLong) {
		this.toLong = toLong;
	}
}
