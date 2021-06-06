package com.example.SBNZ.dto;

import java.util.List;

public class TrainingPlanDTO {

    private int id;
    private List<TrainingDTO> trainings;

    public TrainingPlanDTO() {
    }

    public TrainingPlanDTO(List<TrainingDTO> trainings) {
        this.trainings = trainings;
    }

    public TrainingPlanDTO(int id, List<TrainingDTO> trainings) {
        this.id = id;
        this.trainings = trainings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TrainingDTO> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<TrainingDTO> trainings) {
        this.trainings = trainings;
    }
}
