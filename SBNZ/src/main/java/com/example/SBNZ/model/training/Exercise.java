package com.example.SBNZ.model.training;

import com.example.SBNZ.enums.diet.HealthIssue;
import com.example.SBNZ.enums.training.Difficulty;
import com.example.SBNZ.enums.training.ExerciseCategory;
import com.example.SBNZ.enums.training.Muscle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "description", nullable = false)
    private String description;
    
    @ElementCollection(targetClass = Muscle.class)
    @JoinTable(name = "muscles_exercise", joinColumns = @JoinColumn(name = "exercise_id"))
    @Column(name = "muscleList", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Muscle> muscleList;
    
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    
    @Column(name = "equipment", nullable = false)
    private boolean equipment;
    
    @Enumerated(EnumType.STRING)
    private ExerciseCategory exerciseCategory;

    //@OneToMany(mappedBy = "exercise")
    //private Set<Session> sessionSet = new HashSet<>();

    public Exercise() {
    }

    public Exercise(int id, String name, String description, List<Muscle> muscleList, Difficulty difficulty, boolean equipment, ExerciseCategory exerciseCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.muscleList = muscleList;
        this.difficulty = difficulty;
        this.equipment = equipment;
        this.exerciseCategory = exerciseCategory;
    }

    public Exercise(String name, String description, List<Muscle> muscleList, Difficulty difficulty, boolean equipment, ExerciseCategory exerciseCategory) {
        this.name = name;
        this.description = description;
        this.muscleList = muscleList;
        this.difficulty = difficulty;
        this.equipment = equipment;
        this.exerciseCategory = exerciseCategory;
    }

    public boolean containsAny(List<Exercise> elements) {
    	for(Exercise ex: elements) {
    		if(this.muscleList.contains(ex)) {
    			return false;
    		}
    	}
    	return true;
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

    public List<Muscle> getMuscleList() {
        return muscleList;
    }

    public void setMuscleList(List<Muscle> muscleList) {
        this.muscleList = muscleList;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isEquipment() {
        return equipment;
    }

    public void setEquipment(boolean equipment) {
        this.equipment = equipment;
    }

    public ExerciseCategory getExerciseCategory() {
        return exerciseCategory;
    }

    public void setExerciseCategory(ExerciseCategory exerciseCategory) {
        this.exerciseCategory = exerciseCategory;
    }

	@Override
	public String toString() {
		return "Exercise [id=" + id + ", name=" + name + ", description=" + description + ", muscleList=" + muscleList
				+ ", difficulty=" + difficulty + ", equipment=" + equipment + ", exerciseCategory=" + exerciseCategory
				+ "]";
	}
    
    
}
