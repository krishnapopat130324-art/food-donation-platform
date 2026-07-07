package com.fooddonation.service;

import com.fooddonation.dto.DonationRequest;
import com.fooddonation.model.Donation;
import com.fooddonation.repository.DonationRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class DonationService {
    private final DonationRepository repository;

    public DonationService(DonationRepository repository) {
        this.repository = repository;
    }

    public Donation createDonation(DonationRequest request) {
        Donation donation = new Donation();
        donation.setFoodType(request.getFoodType());
        donation.setQuantity(request.getQuantity());
        donation.setLocation(request.getLocation());
        donation.setDonorName(request.getDonorName());
        donation.setDonorPhone(request.getDonorPhone());
        donation.setDescription(request.getDescription());
        donation.setExpiryDate(request.getExpiryDate());
        donation.setStatus("AVAILABLE");
        return repository.save(donation);
    }

    public List<Donation> getAllDonations() {
        return repository.findAll();
    }

    public Donation getDonationById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Donation not found with id: " + id));
    }

    public void deleteDonation(Long id) {
        repository.deleteById(id);
    }

    public List<Donation> getDonationsByLocation(String location) {
        return repository.findByLocation(location);
    }

    public List<Donation> getAvailableDonations() {
        return repository.findByStatus("AVAILABLE");
    }

    public List<Donation> getDonationsByLocationAndStatus(String location, String status) {
        return repository.findByLocationAndStatus(location, status);
    }

    public Donation updateDonationStatus(Long id, String status) {
        Donation donation = getDonationById(id);
        donation.setStatus(status);
        return repository.save(donation);
    }

    public Donation claimDonation(Long id) {
        Donation donation = getDonationById(id);
        if (!donation.getStatus().equals("AVAILABLE")) {
            throw new RuntimeException("Donation is not available for claiming");
        }
        donation.setStatus("CLAIMED");
        return repository.save(donation);
    }

    public List<Donation> findNearbyDonations(String userLocation, int radius) {
        return repository.findByLocationAndStatus(userLocation, "AVAILABLE");
    }

    public long getTotalDonations() {
        return repository.count();
    }

    public List<Donation> getExpiredDonations() {
        return repository.findByExpiryDateBefore(LocalDate.now());
    }
}