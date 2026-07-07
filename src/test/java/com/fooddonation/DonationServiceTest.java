package com.fooddonation;

import com.fooddonation.dto.DonationRequest;
import com.fooddonation.model.Donation;
import com.fooddonation.repository.DonationRepository;
import com.fooddonation.service.DonationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DonationServiceTest {

    @MockBean
    private DonationRepository repository;

    @Autowired
    private DonationService service;

    @Test
    public void testCreateDonation() {
        DonationRequest request = new DonationRequest();
        request.setFoodType("Rice");
        request.setQuantity(50);
        request.setLocation("Mumbai");
        request.setDonorName("Hotel Taj");
        request.setDonorPhone("9876543210");
        request.setExpiryDate(LocalDate.now().plusDays(3));

        Donation donation = new Donation();
        donation.setId(1L);
        donation.setFoodType("Rice");
        donation.setQuantity(50);
        donation.setLocation("Mumbai");
        donation.setDonorName("Hotel Taj");
        donation.setStatus("AVAILABLE");

        when(repository.save(any(Donation.class))).thenReturn(donation);

        Donation result = service.createDonation(request);
        assertNotNull(result);
        assertEquals("Rice", result.getFoodType());
        assertEquals(50, result.getQuantity());
        assertEquals("AVAILABLE", result.getStatus());
    }

    @Test
    public void testGetAllDonations() {
        Donation donation1 = new Donation();
        donation1.setId(1L);
        donation1.setFoodType("Rice");

        Donation donation2 = new Donation();
        donation2.setId(2L);
        donation2.setFoodType("Vegetables");

        when(repository.findAll()).thenReturn(Arrays.asList(donation1, donation2));

        List<Donation> results = service.getAllDonations();
        assertEquals(2, results.size());
    }

    @Test
    public void testGetDonationById() {
        Donation donation = new Donation();
        donation.setId(1L);
        donation.setFoodType("Rice");

        when(repository.findById(1L)).thenReturn(Optional.of(donation));

        Donation result = service.getDonationById(1L);
        assertNotNull(result);
        assertEquals("Rice", result.getFoodType());
    }

    @Test
    public void testDeleteDonation() {
        Long id = 1L;
        doNothing().when(repository).deleteById(id);
        service.deleteDonation(id);
        verify(repository, times(1)).deleteById(id);
    }

    @Test
    public void testClaimDonation() {
        Donation donation = new Donation();
        donation.setId(1L);
        donation.setStatus("AVAILABLE");

        when(repository.findById(1L)).thenReturn(Optional.of(donation));
        when(repository.save(any(Donation.class))).thenReturn(donation);

        Donation result = service.claimDonation(1L);
        assertEquals("CLAIMED", result.getStatus());
    }

    @Test
    public void testGetAvailableDonations() {
        Donation donation = new Donation();
        donation.setStatus("AVAILABLE");

        when(repository.findByStatus("AVAILABLE")).thenReturn(Arrays.asList(donation));

        List<Donation> results = service.getAvailableDonations();
        assertEquals(1, results.size());
        assertEquals("AVAILABLE", results.get(0).getStatus());
    }
}