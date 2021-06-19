package com.example.SBNZ.service;

import com.example.SBNZ.enums.training.HeartRateProblemType;
import com.example.SBNZ.model.Person;
import com.example.SBNZ.model.User;
import com.example.SBNZ.model.training.*;
import com.example.SBNZ.model.training.cep.CEPInput;
import com.example.SBNZ.model.training.cep.CEPOutput;
import com.example.SBNZ.model.training.cep.DangerousExerciseAlarm;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TrainingService {

    @Autowired
    private KieService kieService;

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private TrainingPlanService trainingPlanService;

    @Autowired
    private UserService userService;

    @Autowired
    private HeartRateProblemService heartRateProblemService;

    private Exercise currentExercise;

    public TrainingPlan getTrainingPlan(InputDataTraining input) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person) authentication.getPrincipal();
        User user = userService.findByUsername(person.getUsername());
        String username = person.getUsername();
        List<Exercise> exercises = exerciseService.findAll();
        KieSession kieSession = kieService.getKieSession(username, "basic");
        kieSession.insert(input);
        for (Exercise exercise : exercises) {
            kieSession.insert(exercise);
        }
        kieSession.getAgenda().getAgendaGroup("Ruleflow1").setFocus();
        kieSession.fireAllRules();
        kieService.clearWorkingMemory(username, "basic");
        TrainingPlan trainingPlan = new TrainingPlan(input.getTraining(), user);
        trainingPlan = trainingPlanService.save(trainingPlan);
        user.setTrainingPlan(trainingPlan);
        userService.update(user);
        return trainingPlan;
    }


    public CEPOutput doCEP(CEPInput input) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person) authentication.getPrincipal();
        User user = userService.findByUsername(person.getUsername());
        String username = person.getUsername();
        input.setUser(user);
        KieSession kieSession = kieService.getKieSession(username, "cep");
        if (currentExercise == null) {
            currentExercise = input.getExercise();
        } else if (currentExercise.getId() != input.getExercise().getId()) {
            kieService.clearWorkingMemory(username, "cep");
            currentExercise = input.getExercise();
        }
        kieSession.insert(input);
        kieSession.fireAllRules();
        //Collection<Object> objects = (Collection<Object>) kieSession.getObjects();
        Collection<FactHandle> handlers = kieSession.getFactHandles();
        for (FactHandle handle: handlers) {
            Object obj = kieSession.getObject(handle);
            if (obj.getClass() == CEPInput.class) {
                kieSession.delete(handle);
            }
            if (obj.getClass() == DangerousExerciseAlarm.class) {
                kieService.clearWorkingMemory(username, "cep");
                // kieService.removeCEPKieSession(username);
                return new CEPOutput(3);
            }
            if (obj.getClass() == HeartRateProblem.class) {
                HeartRateProblem saved = heartRateProblemService.saveOne((HeartRateProblem) obj);
                kieService.clearWorkingMemory(username, "cep");
                // kieService.removeCEPKieSession(username);
                if (saved.getHeartRateProblemType() == HeartRateProblemType.HIGH) {
                    return new CEPOutput(1);
                } else {
                    return new CEPOutput(2);
                }
            }

        }
        return null;
    }
}
