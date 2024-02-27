package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Donations;
import com.service.DonationsService;

import java.util.List;

@RestController
public class DonationsController {
    @Autowired
    private DonationsService donationService;
    
    @PostMapping("/addDonation")
    public ResponseEntity<Donations> saveDonation(@RequestBody Donations donation) {
    	Donations savedDonation = donationService.saveDonation(donation);
    	return ResponseEntity.status(HttpStatus.CREATED).header("Save", "Donation saved").body(savedDonation);
    }

    @GetMapping("/getDonation/{id}")
    public ResponseEntity<Donations> getDonationById(@PathVariable int id) {
    	Donations donation=donationService.getDonationsById(id);
    	return donation != null
                ?  ResponseEntity.status(HttpStatus.OK).body(donation)
                :  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  
    }
    
    @GetMapping("/getAllDonations")
    public ResponseEntity<List<Donations>> getAllDonations() {
    	List<Donations> donations = donationService.getAllDonations();
        return ResponseEntity.status(HttpStatus.OK).body(donations);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonation(@PathVariable int id) {
    	donationService.deleteDonation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}

