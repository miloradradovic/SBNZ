package com.example.SBNZ.service;

import com.example.SBNZ.model.training.Exercise;
import com.example.SBNZ.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    ExerciseRepository exerciseRepository;

    public List<Exercise> findAll() {
        return exerciseRepository.findAll();
    }
}