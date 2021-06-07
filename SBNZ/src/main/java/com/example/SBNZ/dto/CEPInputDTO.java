package com.example.SBNZ.dto;

public class CEPInputDTO {

    private int exerciseDTO;
    private double heartRate;

    public CEPInputDTO() {
    }

    public CEPInputDTO(int exerciseDTO, double heartRate) {
        this.exerciseDTO = exerciseDTO;
        this.heartRate = heartRate;
    }

    public int getExerciseDTO() {
        return exerciseDTO;
    }

    public void setExerciseDTO(int exerciseDTO) {
        this.exerciseDTO = exerciseDTO;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }
}
