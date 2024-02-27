package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Expenditures;

public interface ExpenditureRepository extends JpaRepository<Expenditures, Integer> {

}
