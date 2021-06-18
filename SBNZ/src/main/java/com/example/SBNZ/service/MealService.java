package com.example.SBNZ.service;

import com.example.SBNZ.model.diet.Meal;
import com.example.SBNZ.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    MealRepository mealRepository;

    public Meal save(Meal mealToCreate) {
        if (mealRepository.findByName(mealToCreate.getName()) == null) {
            return mealRepository.save(mealToCreate);
        }
        return null;
    }

    public List<Meal> findAll() {
        return mealRepository.findAll();
    }
}
