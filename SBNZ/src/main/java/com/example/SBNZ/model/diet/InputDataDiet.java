package com.example.SBNZ.model.diet;

import java.util.ArrayList;

import com.example.SBNZ.enums.diet.HealthIssue;
import com.example.SBNZ.enums.diet.JunkFoodFrequency;
import com.example.SBNZ.model.InputData;

import antlr.collections.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InputDataDiet extends InputData {

	private int fatPercentage;
	private int dailyCalBurn;
	private JunkFoodFrequency junkFoodFrequency;
	private ArrayList<HealthIssue> healthIssues = new ArrayList<HealthIssue>();
	
	public InputDataDiet(float currentWeight, float goalWeight, int programDuration, int fatPercentage,
			int dailyCalBurn, JunkFoodFrequency junkFoodFrequency, ArrayList<HealthIssue> healthIssues) {
		super(currentWeight, goalWeight, programDuration);
		this.fatPercentage = fatPercentage;
		this.dailyCalBurn = dailyCalBurn;
		this.junkFoodFrequency = junkFoodFrequency;
		this.healthIssues = healthIssues;
	}
	
}
