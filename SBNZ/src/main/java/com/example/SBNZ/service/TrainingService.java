package com.example.SBNZ.service;

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
    public TrainingService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Training tryRules(InputDataTraining inputData) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(inputData);
        kieSession.fireAllRules();
        kieSession.dispose();
        return inputData.getTraining();
    }
}
