package com.example.SBNZ.api;

import com.example.SBNZ.dto.ExerciseDTO;
import com.example.SBNZ.dto.MealDTO;
import com.example.SBNZ.mappers.MealMapper;
import com.example.SBNZ.model.diet.Meal;
import com.example.SBNZ.model.training.Exercise;
import com.example.SBNZ.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/meals")
public class MealController {

    @Autowired
    MealService mealService;

    @Autowired
    MealMapper mealMapper;

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    public ResponseEntity<MealDTO> createMeal(@RequestBody MealDTO input) {

        Meal saved = mealService.save(mealMapper.toEntity(input));
        if (saved != null) {
            return new ResponseEntity<>(mealMapper.toDTO(saved), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR') || hasRole('ROLE_USER')")
    public ResponseEntity<List<MealDTO>> getAllMeals() {

        List<Meal> result = mealService.findAll();
        return new ResponseEntity<>(mealMapper.toDTOList(result), HttpStatus.OK);
    }
}
