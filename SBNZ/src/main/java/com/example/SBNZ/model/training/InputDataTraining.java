package com.example.SBNZ.model.training;

import java.util.ArrayList;
import java.util.List;

import com.example.SBNZ.enums.training.Difficulty;
import com.example.SBNZ.enums.training.Muscle;
import com.example.SBNZ.model.InputData;

public class InputDataTraining extends InputData {

	private Difficulty difficulty;
	private ArrayList<Muscle> injuries;
	private boolean equipment;
	private List<Training> training;
	private List<Exercise> exerciseList = new ArrayList<>();

	public InputDataTraining(float currentWeight, float goalWeight, int programDuration, Difficulty difficulty,
			ArrayList<Muscle> injuries, boolean equipment) {
		super(currentWeight, goalWeight, programDuration);
		this.difficulty = difficulty;
		this.injuries = injuries;
		this.equipment = equipment;
		this.training = new ArrayList<>();
	}

	public List<Exercise> getExerciseList() {
		return exerciseList;
	}

	public void setExerciseList(List<Exercise> exerciseList) {
		this.exerciseList = exerciseList;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	public ArrayList<Muscle> getInjuries() {
		return injuries;
	}

	public void setInjuries(ArrayList<Muscle> injuries) {
		this.injuries = injuries;
	}

	public boolean isEquipment() {
		return equipment;
	}

	public void setEquipment(boolean equipment) {
		this.equipment = equipment;
	}

	public List<Training> getTraining() {
		return training;
	}

	public void setTraining(ArrayList<Training> training) {
		this.training = training;
	}

	@Override
	public String toString() {
		return "InputDataTraining [difficulty=" + difficulty + ", injuries=" + injuries + ", equipment=" + equipment
				+ ", training=" + training + "]" + super.toString();
	}


	
	
		
}
