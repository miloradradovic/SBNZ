package com.example.SBNZ.service;

import com.example.SBNZ.model.training.CurrentFact;
import com.example.SBNZ.model.training.Exercise;
import com.example.SBNZ.model.training.cep.CEPInput;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SBNZ.model.training.InputDataTraining;
import com.example.SBNZ.model.training.Training;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TrainingService {

    private final KieContainer kieContainer;
    private KieSession kieSession;

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    public TrainingService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public List<Training> getTraining(InputDataTraining input) {
        List<Exercise> exercises = exerciseService.findAll();
        if (kieSession == null) {
            kieSession = kieContainer.newKieSession("trainingSession");
        }
        kieSession.insert(input);
        for (Exercise exercise : exercises) {
            kieSession.insert(exercise);
        }
        kieSession.getAgenda().getAgendaGroup("Ruleflow1").setFocus();
        kieSession.fireAllRules();
        Collection<FactHandle> handlers = kieSession.getFactHandles();
        for (FactHandle handle: handlers) {
            kieSession.delete(handle);
        }
        // kieSession.dispose(); dispose radi samo kad se korisnik izloguje
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
