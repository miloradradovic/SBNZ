package com.example.SBNZ.service;

import com.example.SBNZ.model.Person;
import com.example.SBNZ.model.training.CurrentFact;
import com.example.SBNZ.model.training.Exercise;
import com.example.SBNZ.model.training.cep.CEPInput;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.SBNZ.model.training.InputDataTraining;
import com.example.SBNZ.model.training.Training;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private KieService kieService;

    @Autowired
    private ExerciseService exerciseService;

    public List<Training> getTraining(InputDataTraining input) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person) authentication.getPrincipal();
        String username = person.getUsername();
        List<Exercise> exercises = exerciseService.findAll();
        KieSession kieSession = kieService.getKieSession(username);
        kieSession.insert(input);
        for (Exercise exercise : exercises) {
            kieSession.insert(exercise);
        }
        kieSession.getAgenda().getAgendaGroup("Ruleflow1").setFocus();
        kieSession.fireAllRules();
        kieService.clearWorkingMemory(username);
        return input.getTraining();
    }


    public void doCEP(List<CEPInput> input) {
        KieSession kieSession = kieService.generateCEPSession();
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
