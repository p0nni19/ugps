package com.shipping.ugps.controller;

import com.shipping.ugps.models.*;
import com.shipping.ugps.repository.*;
import com.shipping.ugps.request.*;
import com.shipping.ugps.response.MessageResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/kyc")
public class KycController {

    @Autowired
    private KycDetailsRepository kycRepo;

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/submit")
    public ResponseEntity<?> submitKyc(@RequestBody KycDetailsRequest request) {
        User user = userRepo.findById(request.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));

        KycDetails kyc = new KycDetails();
        kyc.setUser(user);
        kyc.setFullName(request.getFullName());
        kyc.setDob(request.getDob());
        kyc.setSsnLast4(request.getSsnLast4());
        kyc.setStreetAddress(request.getStreetAddress());
        kyc.setCity(request.getCity());
        kyc.setState(request.getState());
        kyc.setZip(request.getZip());

        kycRepo.save(kyc);

        return ResponseEntity.ok(new MessageResponse("KYC details submitted successfully."));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getKycDetails(@PathVariable Long userId) {
        KycDetails kyc = kycRepo.findByUserId(userId);
        if (kyc == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(kyc);
    }
}
