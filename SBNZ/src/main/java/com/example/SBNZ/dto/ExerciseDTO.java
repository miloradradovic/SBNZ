package com.example.SBNZ.dto;

import java.util.List;

public class ExerciseDTO {

    private int id;
    private String name;
    private String description;
    private List<String> muscleList;
    private String difficulty;
    private boolean equipment;
    private String exerciseCategory;

    public ExerciseDTO() {
    }

    public ExerciseDTO(String name, String description, List<String> muscleList, String difficulty, boolean equipment, String exerciseCategory) {
        this.name = name;
        this.description = description;
        this.muscleList = muscleList;
        this.difficulty = difficulty;
        this.equipment = equipment;
        this.exerciseCategory = exerciseCategory;
    }

    public ExerciseDTO(int id, String name, String description, List<String> muscleList, String difficulty, boolean equipment, String exerciseCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.muscleList = muscleList;
        this.difficulty = difficulty;
        this.equipment = equipment;
        this.exerciseCategory = exerciseCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getMuscleList() {
        return muscleList;
    }

    public void setMuscleList(List<String> muscleList) {
        this.muscleList = muscleList;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isEquipment() {
        return equipment;
    }

    public void setEquipment(boolean equipment) {
        this.equipment = equipment;
    }

    public String getExerciseCategory() {
        return exerciseCategory;
    }

    public void setExerciseCategory(String exerciseCategory) {
        this.exerciseCategory = exerciseCategory;
    }
}
