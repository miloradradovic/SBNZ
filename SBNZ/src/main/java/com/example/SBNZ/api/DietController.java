package com.example.SBNZ.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.SBNZ.model.diet.Diet;
import com.example.SBNZ.model.diet.InputDataDiet;
import com.example.SBNZ.model.diet.Meal;
import com.example.SBNZ.model.diet.SearchDiet;
import com.example.SBNZ.service.DietService;

@RestController
@RequestMapping(value="/diet")
public class DietController {

    @Autowired
    DietService dietService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Diet> getDiet(@RequestBody InputDataDiet input) {
    	System.out.println(input);
        Diet result = dietService.getDiet(input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/searchMeals")
    public ResponseEntity<List<Meal>> searchMeals(@RequestBody SearchDiet input) {
    	System.out.println(input);
        List<Meal> meals = dietService.getMeals(input);
        return new ResponseEntity<>(meals, HttpStatus.OK);
    }
}
