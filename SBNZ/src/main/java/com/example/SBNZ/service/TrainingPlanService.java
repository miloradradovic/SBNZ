package com.example.SBNZ.service;

import com.example.SBNZ.model.Person;
import com.example.SBNZ.model.training.TrainingPlan;
import com.example.SBNZ.repository.TrainingPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TrainingPlanService {

    @Autowired
    TrainingPlanRepository trainingPlanRepository;

    @Autowired
    UserService userService;

    @Transactional
    public TrainingPlan save(TrainingPlan trainingPlan) {
        return trainingPlanRepository.saveAndFlush(trainingPlan);
    }

    public List<TrainingPlan> findAll() {
        return trainingPlanRepository.findAll();
    }

    public TrainingPlan findByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person) authentication.getPrincipal();
        return userService.findByUsername(person.getUsername()).getTrainingPlan();
    }
}
