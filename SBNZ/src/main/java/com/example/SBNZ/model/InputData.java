package com.example.SBNZ.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public abstract class InputData {

	private float currentWeight;
	private float goalWeight;
	private int programDuration;
	
	public InputData(float currentWeight, float goalWeight, int programDuration) {
		this.currentWeight = currentWeight;
		this.goalWeight = goalWeight;
		this.programDuration = programDuration;
	}
	
}
