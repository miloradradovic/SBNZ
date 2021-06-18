package com.example.SBNZ.service;

import java.util.ArrayList;
import java.util.List;

import com.example.SBNZ.model.Person;
import com.example.SBNZ.model.User;
import com.example.SBNZ.repository.DietRepository;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.SBNZ.enums.diet.MealType;
import com.example.SBNZ.model.diet.Diet;
import com.example.SBNZ.model.diet.InputDataDiet;
import com.example.SBNZ.model.diet.Meal;
import com.example.SBNZ.model.diet.SearchDiet;
import com.example.SBNZ.repository.MealRepository;

@Service
public class DietService {

    
    @Autowired
    private KieService kieService;

    @Autowired
    private MealService mealService;

    @Autowired
    private DietRepository dietRepository;

    @Autowired
    private UserService userService;

    public Diet getDiet(InputDataDiet inputData) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person) authentication.getPrincipal();
        User user = userService.findByUsername(person.getUsername());
        String username = person.getUsername();
        KieSession kieSession = kieService.getKieSession(username, "basic");
        List<Meal> meals = mealService.findAll();
        for (Meal meal: meals) {
            kieSession.insert(meal);
        }
        // inputData.setMeals(new ArrayList<>());
        kieSession.insert(inputData);
        kieSession.getAgenda().getAgendaGroup("Ruleflow1").setFocus();
        kieSession.fireAllRules();
        kieService.clearWorkingMemory(username, "basic");
        Diet saved = dietRepository.save(inputData.getDiet());
        user.setDiet(saved);
        userService.update(user);
        return inputData.getDiet();
    }
    
    public List<Meal> getMeals(SearchDiet input){
    	KieSession kieSession = kieService.generateQuerySession();
    	InputDataDiet mockInput = new InputDataDiet();
    	mockInput.setMeals(mealService.findAll());
        kieSession.insert(mockInput);
        QueryResults results;
        input = checkSearchDietInput(input);
        if (!input.getMealType().equals("")) {
            results = kieSession.getQueryResults("Recommend meals with mealtype", MealType.valueOf(input.getMealType()),input.getKcalFrom(),input.getKcalTo()
                    ,input.getProteinFrom(),input.getProteinTo(),input.getFatFrom(), input.getFatTo(),
                    input.getCarbsFrom(),input.getCarbsTo());
        } else {
            results = kieSession.getQueryResults("Recommend meals without mealtype", input.getKcalFrom(),input.getKcalTo()
                    ,input.getProteinFrom(),input.getProteinTo(),input.getFatFrom(), input.getFatTo(),
                    input.getCarbsFrom(),input.getCarbsTo());
        }

     	for(QueryResultsRow queryResult : results) {
     		List<Meal> meals = (List<Meal>) queryResult.get("$filteredMeals");
     		kieSession.dispose();
     		return meals;
     	}
     	kieSession.dispose();
     	return null;
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

    public Diet findByUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Person person = (Person) authentication.getPrincipal();
        return userService.findByUsername(person.getUsername()).getDiet();
    }
}
