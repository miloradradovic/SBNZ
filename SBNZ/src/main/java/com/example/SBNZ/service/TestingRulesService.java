package com.example.SBNZ.service;

import com.example.SBNZ.model.TestRuleModel;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestingRulesService {

    private final KieContainer kieContainer;

    @Autowired
    public TestingRulesService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public TestRuleModel tryRules(TestRuleModel testRuleModel) {
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.insert(testRuleModel);
        kieSession.fireAllRules();
        kieSession.dispose();
        return testRuleModel;
    }
}
