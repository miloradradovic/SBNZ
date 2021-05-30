package com.example.SBNZ.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SBNZ.model.diet.Meal;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
	
	
}
