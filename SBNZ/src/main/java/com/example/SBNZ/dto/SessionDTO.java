package com.example.SBNZ.dto;

public class SessionDTO {

    private int id;
    private ExerciseDTO exerciseDTO;
    private float weight;
    private int repetitions;
    private float duration;

    public SessionDTO() {
    }

    public SessionDTO(ExerciseDTO exerciseDTO, float weight, int repetitions, float duration) {
        this.exerciseDTO = exerciseDTO;
        this.weight = weight;
        this.repetitions = repetitions;
        this.duration = duration;
    }

    public SessionDTO(int id, ExerciseDTO exerciseDTO, float weight, int repetitions, float duration) {
        this.id = id;
        this.exerciseDTO = exerciseDTO;
        this.weight = weight;
        this.repetitions = repetitions;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ExerciseDTO getExerciseDTO() {
        return exerciseDTO;
    }

    public void setExerciseDTO(ExerciseDTO exerciseDTO) {
        this.exerciseDTO = exerciseDTO;
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
