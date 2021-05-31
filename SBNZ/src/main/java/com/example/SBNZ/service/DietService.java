package com.example.SBNZ.service;

import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.QueryResults;
import org.kie.api.runtime.rule.QueryResultsRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SBNZ.enums.diet.MealType;
import com.example.SBNZ.model.diet.Diet;
import com.example.SBNZ.model.diet.InputDataDiet;
import com.example.SBNZ.model.diet.Meal;
import com.example.SBNZ.model.diet.SearchDiet;
import com.example.SBNZ.repository.MealRepository;

@Service
public class DietService {

    private final KieContainer kieContainer;

    @Autowired
    private MealRepository mealRepository;
    
    @Autowired
    public DietService(KieContainer kieContainer) {
        this.kieContainer = kieContainer;
    }

    public Diet getDiet(InputDataDiet inputData) {
    	
        KieSession kieSession = kieContainer.newKieSession("dietSession");
        inputData.setMeals(mealRepository.findAll());
        kieSession.insert(inputData);
        kieSession.getAgenda().getAgendaGroup("Ruleflow1").setFocus();
        kieSession.fireAllRules();
        kieSession.dispose();
        return inputData.getDiet();
    }
    
    public List<Meal> getMeals(SearchDiet input){
    	KieSession kieSession = kieContainer.newKieSession("dietSession");
    	InputDataDiet mockInput = new InputDataDiet();
    	mockInput.setMeals(mealRepository.findAll());
        kieSession.insert(mockInput);
     	QueryResults results = kieSession.getQueryResults("Recommend meals", input.getMealType(),input.getKcalFrom(),input.getKcalTo()
     														,input.getProteinFrom(),input.getProteinTo(),input.getFatFrom(), input.getFatTo(),
     														input.getCarbsFrom(),input.getCarbsTo());

     	for(QueryResultsRow queryResult : results) {
     		List<Meal> meals = (List<Meal>) queryResult.get("$filteredMeals");
     		kieSession.dispose();
     		return meals;
     	}
     	kieSession.dispose();
     	return null;
    }
}
