package com.example.SBNZ;

import com.example.SBNZ.enums.diet.Goal;
import com.example.SBNZ.model.User;
import com.example.SBNZ.model.training.CurrentFact;
import com.example.SBNZ.model.training.Exercise;
import com.example.SBNZ.model.training.HeartRateProblem;
import com.example.SBNZ.model.training.InputDataTraining;
import com.example.SBNZ.model.training.cep.CEPInput;
import com.example.SBNZ.model.training.cep.DangerousExerciseAlarm;
import com.example.SBNZ.service.ExerciseService;
import com.example.SBNZ.service.HeartRateProblemService;
import com.example.SBNZ.service.KieService;
import com.example.SBNZ.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:test.properties")
public class CEPTest {

    @Autowired
    private KieService kieService;

    @Autowired
    private UserService userService;

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    HeartRateProblemService heartRateProblemService;

    @Test
    public void testCEP() {
        KieSession kieSession = kieService.getKieSession("micouser", "cep");
        User user = userService.findByUsername("micouser");
        Exercise exercise = exerciseService.findById(1);
        for (int i = 0; i < 6; i++) {
            CEPInput cepInput = new CEPInput();
            cepInput.setUser(user);
            cepInput.setExercise(exercise);
            cepInput.setHeartRate(198);
            kieSession.insert(cepInput);
            kieSession.fireAllRules();
            for (FactHandle factHandle: kieSession.getFactHandles()) {
                if (kieSession.getObject(factHandle).getClass() == CEPInput.class) {
                    kieSession.delete(factHandle);
                }
            }
        }
        boolean found = false;
        Collection<FactHandle> handlers = kieSession.getFactHandles();
        for (FactHandle handle: handlers) {
            Object obj = kieSession.getObject(handle);
            if (obj.getClass() == HeartRateProblem.class) {
                found = true;
                HeartRateProblem saved = heartRateProblemService.saveOne((HeartRateProblem) obj);
                assertNotNull(saved);
            }
        }
        assertTrue(found);
        if (found) {
            found = false;
            CEPInput cepInput = new CEPInput();
            cepInput.setUser(userService.findByUsername("micouser"));
            cepInput.setExercise(exercise);
            cepInput.setHeartRate(198);
            kieSession.insert(cepInput);
            kieSession.fireAllRules();
            Collection<FactHandle> handlers2 = kieSession.getFactHandles();
            for (FactHandle handle: handlers2) {
                Object obj = kieSession.getObject(handle);
                if (obj.getClass() == DangerousExerciseAlarm.class) {
                    found = true;
                }
            }
            assertTrue(found);
        }
    }
}
