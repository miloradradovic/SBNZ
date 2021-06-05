package com.example.SBNZ.service;

import com.example.SBNZ.model.Person;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;

@Service
public class KieService {

    private HashMap<String, KieSession> sessions = new HashMap<>();

    @Autowired
    private KieContainer kieContainer;

    public KieContainer getKieContainer() {
        return kieContainer;
    }

    public KieSession getKieSession(String username) {
        KieSession kieSession = sessions.get(username);
        if (kieSession == null) {
            System.out.println("SESIJA NE POSTOJI");
            kieSession = kieContainer.newKieSession("rulesSession");
            sessions.put(username, kieSession);
        }
        return kieSession;
    }

    public void clearWorkingMemory(String username) {
        KieSession kieSession = sessions.get(username);
        Collection<FactHandle> handlers = kieSession.getFactHandles();
        for (FactHandle handle: handlers) {
            kieSession.delete(handle);
        }
        sessions.put(username, kieSession);
    }

    public KieSession generateCEPSession() {
        return kieContainer.newKieSession("cepKsession");
    }
    
    public KieSession generateQuerySession() {
        return kieContainer.newKieSession("querySession");
    }

    public void removeKieSession(String username) {
        sessions.get(username).dispose();
        sessions.remove(username);
    }
}
