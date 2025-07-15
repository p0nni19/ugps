package com.shipping.ugps.request;

import java.time.LocalDate;

public class PackageDetailsRequest {
	
    private double fromLat;
    private double fromLong;
    private double toLat;
    private double toLong;
    private String fromAddress;
    private String toAddress;
    private String fromZipCode;
    private String toZipCode;
    private LocalDate deliveryDate;
    private String status;

	public double getFromLat() {
		return fromLat;
	}

	public void setFromLat(double fromLat) {
		this.fromLat = fromLat;
	}

	public double getFromLong() {
		return fromLong;
	}

	public void setFromLong(double fromLong) {
		this.fromLong = fromLong;
	}

	public double getToLat() {
		return toLat;
	}

	public void setToLat(double toLat) {
		this.toLat = toLat;
	}

	public double getToLong() {
		return toLong;
	}

	public void setToLong(double toLong) {
		this.toLong = toLong;
	}

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getFromZipCode() {
		return fromZipCode;
	}

	public void setFromZipCode(String fromZipCode) {
		this.fromZipCode = fromZipCode;
	}

	public String getToZipCode() {
		return toZipCode;
	}

	public void setToZipCode(String toZipCode) {
		this.toZipCode = toZipCode;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}