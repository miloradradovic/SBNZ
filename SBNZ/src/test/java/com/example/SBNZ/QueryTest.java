package com.example.SBNZ;

import com.example.SBNZ.enums.diet.MealType;
import com.example.SBNZ.model.diet.InputDataDiet;
import com.example.SBNZ.model.diet.Meal;
import com.example.SBNZ.model.diet.SearchDiet;
import com.example.SBNZ.service.KieService;
import com.example.SBNZ.service.MealService;
import io.swagger.models.auth.In;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:test.properties")
public class QueryTest {

    @Autowired
    MealService mealService;

    @Autowired
    KieService kieService;

    @Test
    public void testQueryWithMealType() {
        InputDataDiet inputDataDiet = new InputDataDiet();
        inputDataDiet.setMeals(mealService.findAll());
        KieSession kieSession = kieService.generateQuerySession();
        kieSession.insert(inputDataDiet);
        SearchDiet input = new SearchDiet();
        input.setMealType("LUNCH");
        input.setKcalFrom(10);
        input.setKcalTo(0);
        input.setProteinFrom(5);
        input.setProteinTo(0);
        input.setFatFrom(10);
        input.setFatTo(0);
        input.setCarbsFrom(0);
        input.setCarbsTo(0);
        input = checkSearchDietInput(input);
        QueryResults results = kieSession.getQueryResults("Recommend meals with mealtype", MealType.valueOf(input.getMealType()),input.getKcalFrom(),input.getKcalTo()
                ,input.getProteinFrom(),input.getProteinTo(),input.getFatFrom(), input.getFatTo(),
                input.getCarbsFrom(),input.getCarbsTo());
        boolean found = false;
        for(QueryResultsRow queryResult : results) {
            List<Meal> meals = (List<Meal>) queryResult.get("$filteredMeals");
            assertEquals(meals.size(), 6);
            kieSession.dispose();
        }
    }

    @Test
    public void testQueryWithoutMealType() {
        InputDataDiet inputDataDiet = new InputDataDiet();
        inputDataDiet.setMeals(mealService.findAll());
        KieSession kieSession = kieService.generateQuerySession();
        kieSession.insert(inputDataDiet);
        SearchDiet input = new SearchDiet();
        input.setMealType("");
        input.setKcalFrom(10);
        input.setKcalTo(0);
        input.setProteinFrom(5);
        input.setProteinTo(0);
        input.setFatFrom(10);
        input.setFatTo(0);
        input.setCarbsFrom(0);
        input.setCarbsTo(0);
        input = checkSearchDietInput(input);
        QueryResults results = kieSession.getQueryResults("Recommend meals without mealtype", input.getKcalFrom(),input.getKcalTo()
                ,input.getProteinFrom(),input.getProteinTo(),input.getFatFrom(), input.getFatTo(),
                input.getCarbsFrom(),input.getCarbsTo());
        for(QueryResultsRow queryResult : results) {
            List<Meal> meals = (List<Meal>) queryResult.get("$filteredMeals");
            assertEquals(meals.size(), 14);
            kieSession.dispose();
        }
    }

    private SearchDiet checkSearchDietInput(SearchDiet input) {
        if (input.getCarbsTo() == 0) {
            input.setCarbsTo(1000000);
        }
        if (input.getFatTo() == 0) {
            input.setFatTo(10000000);
        }
        if (input.getKcalTo() == 0) {
            input.setKcalTo(10000000);
        }
        if (input.getProteinTo() == 0) {
            input.setProteinTo(10000000);
        }
        return input;
    }
}
