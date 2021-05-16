package com.example.SBNZ.model.diet;

import com.example.SBNZ.enums.diet.MealType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meal {

    private String name;
    private MealType mealType;
    private NutritionValue nutritionValue;
    private int junkPercentage;
    private List<Ingredient> ingredientList;
    private String recipe;
}
