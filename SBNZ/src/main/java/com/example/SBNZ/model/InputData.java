package com.example.SBNZ.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public abstract class InputData {

	private float currentWeight;
	private float goalWeight;
	private int programDuration;
	
	public InputData(float currentWeight, float goalWeight, int programDuration) {
		this.currentWeight = currentWeight;
		this.goalWeight = goalWeight;
		this.programDuration = programDuration;
	}

	public float getCurrentWeight() {
		return currentWeight;
	}

	public void setCurrentWeight(float currentWeight) {
		this.currentWeight = currentWeight;
	}

	public float getGoalWeight() {
		return goalWeight;
	}

	public void setGoalWeight(float goalWeight) {
		this.goalWeight = goalWeight;
	}

	public int getProgramDuration() {
		return programDuration;
	}

	public void setProgramDuration(int programDuration) {
		this.programDuration = programDuration;
	}

	@Override
	public String toString() {
		return "InputData [currentWeight=" + currentWeight + ", goalWeight=" + goalWeight + ", programDuration="
				+ programDuration + "]";
	}
	
	
	
}
