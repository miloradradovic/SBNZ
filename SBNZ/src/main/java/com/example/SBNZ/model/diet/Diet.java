package com.example.SBNZ.model.diet;

import java.util.ArrayList;

import javax.persistence.Column;

import com.example.SBNZ.enums.diet.Goal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Diet {

	//output1
    private int kCal;
    
    //output2
    private int carbonHydrates;
    
    //output3
    private int proteins;
    
    //output4
    private int fats;
    
    //hidden
    private int calorieMin;
    
    //hidden
    private int calorieMax;
    
    //hidden
    private int recommendedTime = 0;
    
    //hidden
    private Goal goal;
    
    private ArrayList<Meal> meals = new ArrayList<Meal>();

    

	@Override
	public String toString() {
		return "Diet [kCal=" + kCal + ", carbonHydrates=" + carbonHydrates + ", proteins=" + proteins + ", fats=" + fats
				+ ", calorieMin=" + calorieMin + ", calorieMax=" + calorieMax + ", goal=" + goal + ", meals=" + meals
				+ "]";
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

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public ArrayList<Meal> getMeals() {
		return meals;
	}

	public void setMeals(ArrayList<Meal> meals) {
		this.meals = meals;
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
    
	
	
	
}
