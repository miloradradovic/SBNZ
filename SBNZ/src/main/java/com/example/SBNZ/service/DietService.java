package com.example.SBNZ.service;

import com.example.SBNZ.model.diet.Diet;
import com.example.SBNZ.model.diet.InputDataDiet;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DietService {

    private final KieContainer kieContainer;

    @Autowired
    public DietService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Diet getDiet(InputDataDiet inputData) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("goal", "not initialized");
        kieSession.insert(inputData);
        kieSession.fireAllRules();
        kieSession.dispose();
        return inputData.getDiet();
    }
}
