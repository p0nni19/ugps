package com.shipping.ugps.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shipping.ugps.models.KycDetails;

public interface KycDetailsRepository extends JpaRepository<KycDetails, Long> {
    KycDetails findByUserId(Long userId);
}
