package com.example.SBNZ.service;

import com.example.SBNZ.model.Person;
import com.example.SBNZ.model.User;
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
    private HashMap<String, KieSession> sessionsCEP = new HashMap<>();

    @Autowired
    private KieContainer kieContainer;

    public KieContainer getKieContainer() {
        return kieContainer;
    }

    public KieSession getKieSession(String username, String type) {
        KieSession kieSession = null;
        if (type.equals("basic")) {
            kieSession = sessions.get(username);
            if (kieSession == null) {
                kieSession = kieContainer.newKieSession("rulesSession");
                sessions.put(username, kieSession);
            }
        } else {
            kieSession = sessionsCEP.get(username);
            if (kieSession == null) {
                System.out.println("SESIJA NE POSTOJI");
                kieSession = kieContainer.newKieSession("cepKsession");
                sessionsCEP.put(username, kieSession);
            }
        }
        return kieSession;
    }

    public void clearWorkingMemory(String username, String type) {
        if (type.equals("basic")) {
            KieSession kieSession = sessions.get(username);
            Collection<FactHandle> handlers = kieSession.getFactHandles();
            for (FactHandle handle: handlers) {
                kieSession.delete(handle);
            }
            sessions.put(username, kieSession);
        } else {
            KieSession kieSession = sessionsCEP.get(username);
            Collection<FactHandle> handlers = kieSession.getFactHandles();
            for (FactHandle handle: handlers) {
                kieSession.delete(handle);
            }
            sessionsCEP.put(username, kieSession);
        }
    }
    
    public KieSession generateQuerySession() {
        return kieContainer.newKieSession("querySession");
    }

    public void removeCEPKieSession(String username) {
        sessionsCEP.get(username).dispose();
        sessionsCEP.remove(username);
    }

    public void removeKieSession(String username) {
    	try{
    	    sessions.get(username).dispose();
    	    sessions.remove(username);
        }catch(Exception e) {
    	    System.out.println("NO REGULAR SESSION");
        }

    	try{
    	    sessionsCEP.get(username).dispose();
    	    sessionsCEP.remove(username);
        }catch(Exception e) {
    	    System.out.println("NO CEP SESSION");
        }
    }
}
