package com.example.SBNZ;

import com.example.SBNZ.enums.diet.Goal;
import com.example.SBNZ.enums.training.Difficulty;
import com.example.SBNZ.enums.training.HeartRateProblemType;
import com.example.SBNZ.enums.training.Muscle;
import com.example.SBNZ.model.diet.Meal;
import com.example.SBNZ.model.training.CurrentFact;
import com.example.SBNZ.model.training.Exercise;
import com.example.SBNZ.model.training.HeartRateProblem;
import com.example.SBNZ.model.training.InputDataTraining;
import com.example.SBNZ.model.training.cep.CEPInput;
import com.example.SBNZ.model.training.cep.CEPOutput;
import com.example.SBNZ.model.training.cep.DangerousExerciseAlarm;
import com.example.SBNZ.service.ExerciseService;
import com.example.SBNZ.service.KieService;
import com.example.SBNZ.service.MealService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:test.properties")
public class TrainingTest {

   @Autowired
   ExerciseService exerciseService;

   @Autowired
    KieService kieService;

   InputDataTraining inputDataTraining;

   public void generateInputMassGain() {
       inputDataTraining = new InputDataTraining();
       inputDataTraining.setDifficulty(Difficulty.HIGH);
       inputDataTraining.setCurrentWeight(70);
       inputDataTraining.setGoalWeight(80);
       inputDataTraining.setProgramDuration(60);
       ArrayList<Muscle> muscles = new ArrayList<>();
       muscles.add(Muscle.BICEPS);
       inputDataTraining.setInjuries(muscles);
       inputDataTraining.setEquipment(true);
   }

    public void generateInputWeightLoss() {
        inputDataTraining = new InputDataTraining();
        inputDataTraining.setDifficulty(Difficulty.HIGH);
        inputDataTraining.setCurrentWeight(80);
        inputDataTraining.setGoalWeight(70);
        inputDataTraining.setProgramDuration(60);
        ArrayList<Muscle> muscles = new ArrayList<>();
        muscles.add(Muscle.BICEPS);
        inputDataTraining.setInjuries(muscles);
        inputDataTraining.setEquipment(true);
    }

   @Test
   public void testGenerateTrainingGoalMassGain() {
       generateInputMassGain();
       KieSession kieSession = kieService.getKieSession("test", "basic");
       kieSession.insert(inputDataTraining);
       List<Exercise> exercises = exerciseService.findAll();
       for (Exercise exercise: exercises) {
           kieSession.insert(exercise);
       }
       kieSession.getAgenda().getAgendaGroup("Ruleflow1").setFocus();
       kieSession.fireAllRules();
       Collection<FactHandle> handlers = kieSession.getFactHandles();
       for (FactHandle handle: handlers) {
           Object obj = kieSession.getObject(handle);
           if (obj.getClass() == CurrentFact.class) {
               assertEquals(((CurrentFact) obj).getGoal(), Goal.MASS_GAIN);
               assertEquals(((CurrentFact) obj).getDaysWeek(), 3);
               assertEquals(((CurrentFact) obj).getRestTime(), 60);
               assertEquals(((CurrentFact) obj).getNumberOfSessions(), 5);
           }
           if (obj.getClass() == InputDataTraining.class) {
               assertEquals(((InputDataTraining) obj).getTraining().size(), 3);
           }
       }
       kieService.clearWorkingMemory("test", "basic");
   }

    @Test
    public void testGenerateTrainingGoalWeightLoss() {
        generateInputWeightLoss();
        KieSession kieSession = kieService.getKieSession("test", "basic");
        kieSession.insert(inputDataTraining);
        List<Exercise> exercises = exerciseService.findAll();
        for (Exercise exercise: exercises) {
            kieSession.insert(exercise);
        }
        kieSession.getAgenda().getAgendaGroup("Ruleflow1").setFocus();
        kieSession.fireAllRules();
        Collection<FactHandle> handlers = kieSession.getFactHandles();
        for (FactHandle handle: handlers) {
            Object obj = kieSession.getObject(handle);
            if (obj.getClass() == CurrentFact.class) {
                assertEquals(((CurrentFact) obj).getGoal(), Goal.WEIGHT_LOSS);
                assertEquals(((CurrentFact) obj).getDaysWeek(), 3);
                assertEquals(((CurrentFact) obj).getRestTime(), 30);
                assertEquals(((CurrentFact) obj).getNumberOfSessions(), 3);
            }
            if (obj.getClass() == InputDataTraining.class) {
                assertEquals(((InputDataTraining) obj).getTraining().size(), 3);
            }
        }
        kieService.clearWorkingMemory("test", "basic");
    }

}
