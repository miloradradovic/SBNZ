package com.example.SBNZ.service;

import com.example.SBNZ.model.training.CurrentFact;
import com.example.SBNZ.model.training.Exercise;
import com.example.SBNZ.model.training.cep.CEPInput;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SBNZ.model.training.InputDataTraining;
import com.example.SBNZ.model.training.Training;

import java.util.List;

@Service
public class TrainingService {

    private final KieContainer kieContainer;

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    public TrainingService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public List<Training> getTraining(InputDataTraining input) {
        input.setExerciseList(exerciseService.findAll());
        KieSession kieSession = kieContainer.newKieSession("trainingSession");
        CurrentFact currentFact = new CurrentFact(2);
        kieSession.insert(input);
        kieSession.insert(currentFact);
        kieSession.getAgenda().getAgendaGroup("Ruleflow1").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();
        return input.getTraining();
    }

    public void doCEP(List<CEPInput> input) {
        KieSession kieSession = kieContainer.newKieSession("cepKsession");
        for (CEPInput cep : input) {
            kieSession.insert(cep);
            kieSession.fireAllRules();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        kieSession.dispose();
    }
}
