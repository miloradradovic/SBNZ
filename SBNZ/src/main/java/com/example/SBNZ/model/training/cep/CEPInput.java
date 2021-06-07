package com.example.SBNZ.model.training.cep;

import com.example.SBNZ.dto.ExerciseDTO;
import com.example.SBNZ.model.User;
import com.example.SBNZ.model.training.Exercise;

public class CEPInput {

    private Exercise exercise;
    private double heartRate;
    private User user;

    public CEPInput() {
    }

    public CEPInput(Exercise exercise, double heartRate) {
        this.exercise = exercise;
        this.heartRate = heartRate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }
}
