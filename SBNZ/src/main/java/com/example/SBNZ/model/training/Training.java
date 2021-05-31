package com.example.SBNZ.model.training;

import java.util.ArrayList;
import java.util.List;

import com.example.SBNZ.enums.diet.Goal;
import com.example.SBNZ.enums.training.Muscle;

public class Training {

    private List<Session> sessionList = new ArrayList<Session>();
    private double restTime;
    private int numberOfSessions;
    private Goal goal;
    private List<Muscle> muscles = new ArrayList<Muscle>();

	public Training() {
		
	}

	public Training(List<Session> sessionList, double restTime, int numberOfSessions) {
		this.sessionList = sessionList;
		this.restTime = restTime;
		this.numberOfSessions = numberOfSessions;
	}

	public Training(List<Session> sessionList, double restTime, int numberOfSessions, Goal goal) {
		this.sessionList = sessionList;
		this.restTime = restTime;
		this.numberOfSessions = numberOfSessions;
		this.goal = goal;
	}
	
	public void addSession(Session session) {
		this.sessionList.add(session);
		for(Muscle m: session.getExercise().getMuscleList()) {
			this.muscles.add(m);
		}
	}

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
	
	
    
    public List<Muscle> getMuscles() {
		return muscles;
	}

	public void setMuscles(List<Muscle> muscles) {
		this.muscles = muscles;
	}

	public Training(Goal goal) {
		this.goal = goal;
	}

}
