package com.example.SBNZ;

import com.example.SBNZ.enums.diet.Goal;
import com.example.SBNZ.enums.diet.HealthIssue;
import com.example.SBNZ.enums.diet.JunkFoodFrequency;
import com.example.SBNZ.model.diet.InputDataDiet;
import com.example.SBNZ.model.diet.Meal;
import com.example.SBNZ.model.training.CurrentFact;
import com.example.SBNZ.model.training.InputDataTraining;
import com.example.SBNZ.service.KieService;
import com.example.SBNZ.service.MealService;
import org.checkerframework.checker.units.qual.A;
import org.junit.Test;
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
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:test.properties")
public class DietTest {

    @Autowired
    MealService mealService;

    @Autowired
    KieService kieService;

    InputDataDiet inputDataDiet;

    public void generateInputMassGain() {
        inputDataDiet = new InputDataDiet();
        inputDataDiet.setCurrentWeight(60);
        inputDataDiet.setGoalWeight(70);
        inputDataDiet.setProgramDuration(50);
        inputDataDiet.setFatPercentage(20);
        inputDataDiet.setDailyCalBurn(0);
        inputDataDiet.setJunkFoodFrequency(JunkFoodFrequency.NEVER);
        ArrayList<HealthIssue> healthIssues = new ArrayList<>();
        healthIssues.add(HealthIssue.HIGH_FAT);
        healthIssues.add(HealthIssue.DIABETES);
        inputDataDiet.setHealthIssues(healthIssues);
    }

    public void generateInputWeightLoss() {
        inputDataDiet = new InputDataDiet();
        inputDataDiet.setCurrentWeight(70);
        inputDataDiet.setGoalWeight(60);
        inputDataDiet.setProgramDuration(50);
        inputDataDiet.setFatPercentage(20);
        inputDataDiet.setDailyCalBurn(0);
        inputDataDiet.setJunkFoodFrequency(JunkFoodFrequency.NEVER);
        ArrayList<HealthIssue> healthIssues = new ArrayList<>();
        healthIssues.add(HealthIssue.HIGH_FAT);
        healthIssues.add(HealthIssue.DIABETES);
        inputDataDiet.setHealthIssues(healthIssues);
    }

    @Test
    public void testGenerateDietMassGain() {
        generateInputMassGain();
        KieSession kieSession = kieService.getKieSession("test", "basic");
        kieSession.insert(inputDataDiet);
        List<Meal> meals = mealService.findAll();
        for (Meal meal: meals) {
            kieSession.insert(meal);
        }
        kieSession.getAgenda().getAgendaGroup("Ruleflow1").setFocus();
        kieSession.fireAllRules();
        Collection<FactHandle> handlers = kieSession.getFactHandles();
        for (FactHandle handle: handlers) {
            Object obj = kieSession.getObject(handle);
            if (obj.getClass() == InputDataDiet.class) {
                assertEquals(((InputDataDiet) obj).getDiet().getkCal(), 1866);
                assertEquals(((InputDataDiet) obj).getDiet().getCarbonHydrates(), 52);
                assertEquals(((InputDataDiet) obj).getDiet().getProteins(), 72);
                assertEquals(((InputDataDiet) obj).getDiet().getFats(), 72);
                assertEquals(((InputDataDiet) obj).getDiet().getCalorieMin(), 1600);
                assertEquals(((InputDataDiet) obj).getDiet().getCalorieMax(), 2000);
                assertEquals(((InputDataDiet) obj).getDiet().getRecommendedTime(), 150);
                assertEquals(((InputDataDiet) obj).getDiet().getGoal(), Goal.MASS_GAIN);
                assertTrue(((InputDataDiet) obj).getDiet().getMeals().size() > 0);
            }
        }
        kieService.clearWorkingMemory("test", "basic");
    }

    @Test
    public void testGenerateDietWeightLoss() {
        generateInputWeightLoss();
        KieSession kieSession = kieService.getKieSession("test", "basic");
        kieSession.insert(inputDataDiet);
        List<Meal> meals = mealService.findAll();
        for (Meal meal: meals) {
            kieSession.insert(meal);
        }
        kieSession.getAgenda().getAgendaGroup("Ruleflow1").setFocus();
        kieSession.fireAllRules();
        Collection<FactHandle> handlers = kieSession.getFactHandles();
        for (FactHandle handle: handlers) {
            Object obj = kieSession.getObject(handle);
            if (obj.getClass() == InputDataDiet.class) {
                assertEquals(((InputDataDiet) obj).getDiet().getkCal(), 2133);
                assertEquals(((InputDataDiet) obj).getDiet().getCarbonHydrates(), 78);
                assertEquals(((InputDataDiet) obj).getDiet().getProteins(), 78);
                assertEquals(((InputDataDiet) obj).getDiet().getFats(), 56);
                assertEquals(((InputDataDiet) obj).getDiet().getCalorieMin(), 2000);
                assertEquals(((InputDataDiet) obj).getDiet().getCalorieMax(), 2400);
                assertEquals(((InputDataDiet) obj).getDiet().getRecommendedTime(), 150);
                assertEquals(((InputDataDiet) obj).getDiet().getGoal(), Goal.WEIGHT_LOSS);
                assertTrue(((InputDataDiet) obj).getDiet().getMeals().size() > 0);
            }
        }
        kieService.clearWorkingMemory("test", "basic");
    }
}
