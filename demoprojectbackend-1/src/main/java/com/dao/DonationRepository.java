package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Donations;

public interface DonationRepository extends JpaRepository<Donations, Integer> {

}
