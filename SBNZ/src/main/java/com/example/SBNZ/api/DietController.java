package com.example.SBNZ.api;

import java.util.List;

import com.example.SBNZ.dto.DietDTO;
import com.example.SBNZ.dto.MealDTO;
import com.example.SBNZ.dto.TrainingPlanDTO;
import com.example.SBNZ.mappers.DietMapper;
import com.example.SBNZ.mappers.MealMapper;
import com.example.SBNZ.model.training.TrainingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.SBNZ.model.diet.Diet;
import com.example.SBNZ.model.diet.InputDataDiet;
import com.example.SBNZ.model.diet.Meal;
import com.example.SBNZ.model.diet.SearchDiet;
import com.example.SBNZ.service.DietService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/diet")
public class DietController {

    @Autowired
    DietService dietService;

    @Autowired
    DietMapper dietMapper;

    @Autowired
    MealMapper mealMapper;

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<DietDTO> getDiet(@RequestBody InputDataDiet input) {
        Diet result = dietService.getDiet(input);
        return new ResponseEntity<>(dietMapper.toDTO(result), HttpStatus.OK);
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/searchMeals")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<MealDTO>> searchMeals(@RequestBody SearchDiet input) {
    	System.out.println(input);
        List<Meal> meals = dietService.getMeals(input);
        return new ResponseEntity<>(mealMapper.toDTOList(meals), HttpStatus.OK);
    }

    @RequestMapping(value = "/get-diet-by-logged-in-user", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<DietDTO> getDietOfLoggedInUser() {

        Diet diet = dietService.findByUser();
        return new ResponseEntity<DietDTO>(dietMapper.toDTO(diet), HttpStatus.OK);
    }
}
