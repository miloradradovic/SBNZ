package com.example.SBNZ.model.training;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class CurrentFact {

    private int layer;
    private List<Exercise> exerciseList = new ArrayList<>();
    private int daysWeek;
    private int restTime;

    public CurrentFact() {

    }

    public CurrentFact(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public CurrentFact(int layer) {
        this.layer = layer;
    }

    public int getDaysWeek() {
        return daysWeek;
    }

    public void setDaysWeek(int daysWeek) {
        this.daysWeek = daysWeek;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public List<Exercise> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public int getRestTime() {
        return restTime;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }
}
