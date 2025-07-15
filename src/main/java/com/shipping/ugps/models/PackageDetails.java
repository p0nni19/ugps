package com.shipping.ugps.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PACKAGE")
public class PackageDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PACKAGE ID")
    private Long packageId;
    
    @Column(name = "FROM LAT")
    private double fromLat;
    
    @Column(name = "FROM LONG")
    private double fromLong;
    
    @Column(name = "TO LAT")
    private double toLat;
    
    @Column(name = "TO LONG")
    private double toLong;

    @Column(name = "FROM ADDRESS")
    private String fromAddress;
    
    @Column(name = "TO ADDRESS")
    private String toAddress;

    @Column(name = "FROM ZIPCODE")
    private String fromZipCode;
    
    @Column(name = "TO ZIPCODE")
    private String toZipCode;
    
    @Column(name = "DELIVERY TIME")
    private double deliveryTimeinHours;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DELIVERY DATE")
    private LocalDate deliveryDate;
    
    @Column(name = "STATUS")
    private String status;

	public Long getPackageId() {
		return packageId;
	}

	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}

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

	public double getDeliveryTimeinHours() {
		return deliveryTimeinHours;
	}

	public void setDeliveryTimeinHours(double deliveryTimeinHours) {
		this.deliveryTimeinHours = deliveryTimeinHours;
	}

	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDate localDate) {
		this.deliveryDate = localDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}