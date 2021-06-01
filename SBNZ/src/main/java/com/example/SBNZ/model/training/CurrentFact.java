package com.example.SBNZ.model.training;

import com.example.SBNZ.enums.diet.Goal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class CurrentFact {

    private Goal goal;
    private List<Exercise> exerciseList = new ArrayList<>();
    private int daysWeek = -1;
    private int restTime = -1;
    private int numberOfSessions = -1;

    public CurrentFact() {

    }

    public CurrentFact(Goal goal) {
        this.goal = goal;
    }

    public CurrentFact(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public int getNumberOfSessions() {
        return numberOfSessions;
    }

    public void setNumberOfSessions(int numberOfSessions) {
        this.numberOfSessions = numberOfSessions;
    }

    public int getDaysWeek() {
        return daysWeek;
    }

    public void setDaysWeek(int daysWeek) {
        this.daysWeek = daysWeek;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
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
