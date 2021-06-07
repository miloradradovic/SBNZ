package com.example.SBNZ.dto;

import java.util.List;

public class MealDTO {

    private int id;
    private int kCal;
    private int carbonHydrates;
    private int proteins;
    private int fats;
    private String name;
    private String mealType;
    private int junkPercentage;
    private List<String> healthIssueTypes;
    private String recipe;

    public MealDTO() {
    }

    public MealDTO(int kCal, int carbonHydrates, int proteins, int fats, String name, String mealType, int junkPercentage, List<String> healthIssueTypes, String recipe) {
        this.kCal = kCal;
        this.carbonHydrates = carbonHydrates;
        this.proteins = proteins;
        this.fats = fats;
        this.name = name;
        this.mealType = mealType;
        this.junkPercentage = junkPercentage;
        this.healthIssueTypes = healthIssueTypes;
        this.recipe = recipe;
    }

    public MealDTO(int id, int kCal, int carbonHydrates, int proteins, int fats, String name, String mealType, int junkPercentage, List<String> healthIssueTypes, String recipe) {
        this.id = id;
        this.kCal = kCal;
        this.carbonHydrates = carbonHydrates;
        this.proteins = proteins;
        this.fats = fats;
        this.name = name;
        this.mealType = mealType;
        this.junkPercentage = junkPercentage;
        this.healthIssueTypes = healthIssueTypes;
        this.recipe = recipe;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public int getJunkPercentage() {
        return junkPercentage;
    }

    public void setJunkPercentage(int junkPercentage) {
        this.junkPercentage = junkPercentage;
    }

    public List<String> getHealthIssueTypes() {
        return healthIssueTypes;
    }

    public void setHealthIssueTypes(List<String> healthIssueTypes) {
        this.healthIssueTypes = healthIssueTypes;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }
}
