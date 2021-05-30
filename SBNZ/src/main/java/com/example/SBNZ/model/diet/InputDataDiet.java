package com.example.SBNZ.model.diet;

import java.util.ArrayList;

import com.example.SBNZ.enums.diet.HealthIssue;
import com.example.SBNZ.enums.diet.JunkFoodFrequency;
import com.example.SBNZ.model.InputData;

import java.util.List;

public class InputDataDiet extends InputData {

	private int fatPercentage;
	private int dailyCalBurn;
	private JunkFoodFrequency junkFoodFrequency;
	private ArrayList<HealthIssue> healthIssues = new ArrayList<HealthIssue>();
	private Diet diet;
	private List<Meal> meals;
	
	public InputDataDiet(float currentWeight, float goalWeight, int programDuration, int fatPercentage,
			int dailyCalBurn, JunkFoodFrequency junkFoodFrequency, ArrayList<HealthIssue> healthIssues) {
		super(currentWeight, goalWeight, programDuration);
		this.fatPercentage = fatPercentage;
		this.dailyCalBurn = dailyCalBurn;
		this.junkFoodFrequency = junkFoodFrequency;
		this.healthIssues = healthIssues;
		this.diet = new Diet();
	}
	
	public InputDataDiet() {
		super();
	}


	public List<Meal> getMeals() {
		return meals;
	}

	


	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}




	public int getFatPercentage() {
		return fatPercentage;
	}

	public void setFatPercentage(int fatPercentage) {
		this.fatPercentage = fatPercentage;
	}

	public int getDailyCalBurn() {
		return dailyCalBurn;
	}

	public void setDailyCalBurn(int dailyCalBurn) {
		this.dailyCalBurn = dailyCalBurn;
	}

	public JunkFoodFrequency getJunkFoodFrequency() {
		return junkFoodFrequency;
	}

	public void setJunkFoodFrequency(JunkFoodFrequency junkFoodFrequency) {
		this.junkFoodFrequency = junkFoodFrequency;
	}

	public ArrayList<HealthIssue> getHealthIssues() {
		return healthIssues;
	}

	public void setHealthIssues(ArrayList<HealthIssue> healthIssues) {
		this.healthIssues = healthIssues;
	}

	public Diet getDiet() {
		return diet;
	}

	public void setDiet(Diet diet) {
		this.diet = diet;
	}




	@Override
	public String toString() {
		return "InputDataDiet [fatPercentage=" + fatPercentage + ", dailyCalBurn=" + dailyCalBurn
				+ ", junkFoodFrequency=" + junkFoodFrequency + ", healthIssues=" + healthIssues + ", diet=" + diet
				+ ", meals=" + meals + "]";
	}
	
	
	
}
