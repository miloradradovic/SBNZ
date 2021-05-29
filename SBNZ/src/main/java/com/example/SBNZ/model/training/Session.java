package com.example.SBNZ.model.training;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class Session {

    private Exercise exercise;
    private float weight; // optional
    private int repetitions; //optional
    private float duration; // optional

    public Session() {
    }

    public Session(Exercise exercise, float weight, int repetitions, float duration) {
        this.exercise = exercise;
        this.weight = weight;
        this.repetitions = repetitions;
        this.duration = duration;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
