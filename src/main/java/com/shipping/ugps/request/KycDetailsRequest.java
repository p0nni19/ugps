package com.shipping.ugps.request;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class KycDetailsRequest {

    @NotBlank
    private String fullName;

    @NotNull
    private LocalDate dob;

    @Pattern(regexp = "\\d{4}", message = "SSN must be 4 digits")
    private String ssnLast4;

    @NotBlank
    private String streetAddress;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotBlank
    @Pattern(regexp = "\\d{5}", message = "ZIP must be 5 digits")
    private String zip;

    @NotNull
    private Long userId;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getSsnLast4() {
		return ssnLast4;
	}

	public void setSsnLast4(String ssnLast4) {
		this.ssnLast4 = ssnLast4;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}