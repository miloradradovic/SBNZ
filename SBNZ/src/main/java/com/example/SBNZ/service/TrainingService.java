package com.example.SBNZ.service;

import com.example.SBNZ.model.training.Exercise;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SBNZ.model.training.InputDataTraining;
import com.example.SBNZ.model.training.Training;

@Service
public class TrainingService {

    private final KieContainer kieContainer;

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    public TrainingService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Training getTraining(InputDataTraining input) {
        input.setExerciseList(exerciseService.findAll());
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(input);
        kieSession.getAgenda().getAgendaGroup("Ruleflow1").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();
        return input.getTraining();
    }
}
