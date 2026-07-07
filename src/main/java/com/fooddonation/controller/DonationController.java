package com.fooddonation.controller;

import com.fooddonation.dto.DonationRequest;
import com.fooddonation.model.Donation;
import com.fooddonation.service.DonationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/donations")
@CrossOrigin(origins = "*")
public class DonationController {
    private final DonationService service;

    public DonationController(DonationService service) {
        this.service = service;
    }

    // ✅ Create a new donation
    @PostMapping
    public ResponseEntity<Donation> createDonation(@RequestBody DonationRequest request) {
        Donation donation = service.createDonation(request);
        return new ResponseEntity<>(donation, HttpStatus.CREATED);
    }

    // ✅ Get all donations
    @GetMapping
    public ResponseEntity<List<Donation>> getAllDonations() {
        return ResponseEntity.ok(service.getAllDonations());
    }

    // ✅ Get donation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Donation> getDonationById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getDonationById(id));
    }

    // ✅ Delete donation
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteDonation(@PathVariable Long id) {
        service.deleteDonation(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Donation deleted successfully!");
        return ResponseEntity.ok(response);
    }

    // ✅ Get donations by location
    @GetMapping("/location/{location}")
    public ResponseEntity<List<Donation>> getDonationsByLocation(@PathVariable String location) {
        return ResponseEntity.ok(service.getDonationsByLocation(location));
    }

    // ✅ Get available donations only
    @GetMapping("/available")
    public ResponseEntity<List<Donation>> getAvailableDonations() {
        return ResponseEntity.ok(service.getAvailableDonations());
    }

    // ✅ Get donations by location and status
    @GetMapping("/search")
    public ResponseEntity<List<Donation>> searchDonations(
            @RequestParam String location,
            @RequestParam(required = false) String status) {
        if (status != null && !status.isEmpty()) {
            return ResponseEntity.ok(service.getDonationsByLocationAndStatus(location, status));
        }
        return ResponseEntity.ok(service.getDonationsByLocation(location));
    }

    // ✅ Claim a donation - FIXED!
    @PutMapping("/{id}/claim")
    public ResponseEntity<Donation> claimDonation(@PathVariable Long id) {
        Donation donation = service.claimDonation(id);
        return ResponseEntity.ok(donation);
    }

    // ✅ Update donation status
    @PutMapping("/{id}/status")
    public ResponseEntity<Donation> updateStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        Donation donation = service.updateDonationStatus(id, status);
        return ResponseEntity.ok(donation);
    }

    // ✅ Get nearby donations (matching feature)
    @GetMapping("/nearby")
    public ResponseEntity<List<Donation>> getNearbyDonations(
            @RequestParam String location,
            @RequestParam(defaultValue = "10") int radius) {
        return ResponseEntity.ok(service.findNearbyDonations(location, radius));
    }

    // ✅ Get statistics - FIXED!
    @GetMapping("/stats")
    public ResponseEntity<Map<String, Object>> getStats() {
        Map<String, Object> stats = new HashMap<>();
        stats.put("totalDonations", service.getTotalDonations());
        stats.put("availableDonations", service.getAvailableDonations().size());
        stats.put("expiredDonations", service.getExpiredDonations().size());
        return ResponseEntity.ok(stats);
    }
}