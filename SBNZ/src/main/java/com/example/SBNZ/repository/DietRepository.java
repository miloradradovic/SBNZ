package com.example.SBNZ.repository;

import com.example.SBNZ.model.diet.Diet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DietRepository extends JpaRepository<Diet, Integer> {
}
