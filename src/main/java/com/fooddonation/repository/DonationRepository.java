package com.fooddonation.repository;

import com.fooddonation.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
    List<Donation> findByLocation(String location);
    List<Donation> findByFoodType(String foodType);
    List<Donation> findByStatus(String status);
    List<Donation> findByLocationAndStatus(String location, String status);
    List<Donation> findByExpiryDateBefore(LocalDate date);
    List<Donation> findByExpiryDateAfter(LocalDate date);
}