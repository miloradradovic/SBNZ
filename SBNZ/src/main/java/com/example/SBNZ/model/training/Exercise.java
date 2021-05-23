package com.example.SBNZ.model.training;

import com.example.SBNZ.enums.diet.HealthIssue;
import com.example.SBNZ.enums.training.Difficulty;
import com.example.SBNZ.enums.training.ExerciseCategory;
import com.example.SBNZ.enums.training.Muscle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinTable(name = "muscles", joinColumns = @JoinColumn(name = "exercise_id"))
    @Column(name = "muscleList", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Muscle> muscleList;
    
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    
    @Column(name = "equipment", nullable = false)
    private boolean equipment;
    
    @Enumerated(EnumType.STRING)
    private ExerciseCategory exerciseCategory;
    
}
