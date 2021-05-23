package com.example.SBNZ.model.training;

import java.util.ArrayList;

import com.example.SBNZ.enums.training.Difficulty;
import com.example.SBNZ.enums.training.Muscle;
import com.example.SBNZ.model.InputData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataInputTraining extends InputData {

	private Difficulty difficulty;
	private ArrayList<Muscle> injuries;
	private boolean equipment;
	

	public DataInputTraining(float currentWeight, float goalWeight, int programDuration, Difficulty difficulty,
			ArrayList<Muscle> injuries, boolean equipment) {
		super(currentWeight, goalWeight, programDuration);
		this.difficulty = difficulty;
		this.injuries = injuries;
		this.equipment = equipment;
	}
		
}
