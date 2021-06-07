package com.example.SBNZ.dto;

import java.util.List;

public class TrainingDTO {

    private int id;
    private List<SessionDTO> sessions;
    private int restTime;
    private int numberOfSessions;
    private String goal;
    private List<String> muscles;

    public TrainingDTO() {
    }

    public TrainingDTO(List<SessionDTO> sessions, int restTime, int numberOfSessions, String goal, List<String> muscles) {
        this.sessions = sessions;
        this.restTime = restTime;
        this.numberOfSessions = numberOfSessions;
        this.goal = goal;
        this.muscles = muscles;
    }

    public TrainingDTO(int id, List<SessionDTO> sessions, int restTime, int numberOfSessions, String goal, List<String> muscles) {
        this.id = id;
        this.sessions = sessions;
        this.restTime = restTime;
        this.numberOfSessions = numberOfSessions;
        this.goal = goal;
        this.muscles = muscles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<SessionDTO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionDTO> sessions) {
        this.sessions = sessions;
    }

    public int getRestTime() {
        return restTime;
    }

    public void setRestTime(int restTime) {
        this.restTime = restTime;
    }

    public int getNumberOfSessions() {
        return numberOfSessions;
    }

    public void setNumberOfSessions(int numberOfSessions) {
        this.numberOfSessions = numberOfSessions;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public List<String> getMuscles() {
        return muscles;
    }

    public void setMuscles(List<String> muscles) {
        this.muscles = muscles;
    }
}
