package com.example.SBNZ.dto;

import java.util.List;

public class DietDTO {

    private int id;
    private int kCal;
    private int carbonHydrates;
    private int proteins;
    private int fats;
    private int calorieMin;
    private int calorieMax;
    private int recommendedTime = 0;
    private String goal;
    private List<MealDTO> meals;

    public DietDTO() {
    }

    public DietDTO(int kCal, int carbonHydrates, int proteins, int fats, int calorieMin, int calorieMax, int recommendedTime, String goal, List<MealDTO> meals) {
        this.kCal = kCal;
        this.carbonHydrates = carbonHydrates;
        this.proteins = proteins;
        this.fats = fats;
        this.calorieMin = calorieMin;
        this.calorieMax = calorieMax;
        this.recommendedTime = recommendedTime;
        this.goal = goal;
        this.meals = meals;
    }

    public DietDTO(int id, int kCal, int carbonHydrates, int proteins, int fats, int calorieMin, int calorieMax, int recommendedTime, String goal, List<MealDTO> meals) {
        this.id = id;
        this.kCal = kCal;
        this.carbonHydrates = carbonHydrates;
        this.proteins = proteins;
        this.fats = fats;
        this.calorieMin = calorieMin;
        this.calorieMax = calorieMax;
        this.recommendedTime = recommendedTime;
        this.goal = goal;
        this.meals = meals;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getkCal() {
        return kCal;
    }

    public void setkCal(int kCal) {
        this.kCal = kCal;
    }

    public int getCarbonHydrates() {
        return carbonHydrates;
    }

    public void setCarbonHydrates(int carbonHydrates) {
        this.carbonHydrates = carbonHydrates;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getFats() {
        return fats;
    }

    public void setFats(int fats) {
        this.fats = fats;
    }

    public int getCalorieMin() {
        return calorieMin;
    }

    public void setCalorieMin(int calorieMin) {
        this.calorieMin = calorieMin;
    }

    public int getCalorieMax() {
        return calorieMax;
    }

    public void setCalorieMax(int calorieMax) {
        this.calorieMax = calorieMax;
    }

    public int getRecommendedTime() {
        return recommendedTime;
    }

    public void setRecommendedTime(int recommendedTime) {
        this.recommendedTime = recommendedTime;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public List<MealDTO> getMeals() {
        return meals;
    }

    public void setMeals(List<MealDTO> meals) {
        this.meals = meals;
    }
}
