package com.example.SBNZ.model.training;

import com.example.SBNZ.enums.training.Difficulty;
import com.example.SBNZ.enums.training.ExerciseCategory;
import com.example.SBNZ.enums.training.Muscle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exercise {

    private Long id;
    private String name;
    private String description;
    private List<Muscle> muscleList;
    private Difficulty difficulty;
    private boolean equipment;
    private ExerciseCategory exerciseCategory;
}
