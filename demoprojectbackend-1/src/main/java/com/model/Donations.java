package com.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Donations { 
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int donation_id;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id")
   	@JsonBackReference
    private Users user;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "ngo_id")
    private Ngos ngos;

    @Column(name = "amount")
    private int amount;

    @Column(name = "donation_date")
    private LocalDateTime donationDate;

}
