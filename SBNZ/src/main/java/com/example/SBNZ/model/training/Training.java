package com.example.SBNZ.model.training;

import com.example.SBNZ.enums.diet.Goal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class Training {

    private List<Session> sessionList;
    private double restTime;
    private int numberOfSessions;
    private Goal goal;

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public List<Session> getSessionList() {
		return sessionList;
	}
	public void setSessionList(List<Session> sessionList) {
		this.sessionList = sessionList;
	}
	public double getRestTime() {
		return restTime;
	}
	public void setRestTime(double restTime) {
		this.restTime = restTime;
	}
	public int getNumberOfSessions() {
		return numberOfSessions;
	}
	public void setNumberOfSessions(int numberOfSessions) {
		this.numberOfSessions = numberOfSessions;
	}
    
    public Training(Goal goal) {
		this.goal = goal;
		this.sessionList = new ArrayList<>();
	}

}
