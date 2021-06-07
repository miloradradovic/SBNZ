package com.example.SBNZ.repository;

import com.example.SBNZ.model.training.HeartRateProblem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeartRateProblemRepository extends JpaRepository<HeartRateProblem, Integer> {
}
