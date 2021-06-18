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

    public Exercise findById(int id) {
        return exerciseRepository.findById(id);
    }

    public Exercise save(Exercise exerciseToSave) {
        if (exerciseRepository.findByName(exerciseToSave.getName()) == null) {
            return exerciseRepository.save(exerciseToSave);
        }
        return null;
    }
}
