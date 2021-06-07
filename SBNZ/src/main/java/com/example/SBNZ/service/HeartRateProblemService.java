package com.example.SBNZ.service;

import com.example.SBNZ.model.training.HeartRateProblem;
import com.example.SBNZ.repository.HeartRateProblemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HeartRateProblemService {

    @Autowired
    private HeartRateProblemRepository heartRateProblemRepository;

    public HeartRateProblem saveOne(HeartRateProblem heartRateProblem) {
        return heartRateProblemRepository.save(heartRateProblem);
    }
}
