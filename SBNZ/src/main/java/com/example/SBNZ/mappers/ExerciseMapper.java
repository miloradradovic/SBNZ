package com.example.SBNZ.mappers;

import com.example.SBNZ.dto.ExerciseDTO;
import com.example.SBNZ.model.training.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExerciseMapper implements MapperInterface<Exercise, ExerciseDTO> {

    @Autowired
    MuscleMapper muscleMapper;

    @Autowired
    DifficultyMapper difficultyMapper;

    @Autowired
    ExerciseCategoryMapper exerciseCategoryMapper;

    @Override
    public Exercise toEntity(ExerciseDTO dto) {
        if (dto.getId() == -1) {
            return new Exercise(dto.getName(), dto.getDescription(), muscleMapper.toEntityList(dto.getMuscleList()),
                    difficultyMapper.toEntity(dto.getDifficulty()), dto.isEquipment(), exerciseCategoryMapper.toEntity(dto.getExerciseCategory()));
        }
        return new Exercise(dto.getId(), dto.getName(), dto.getDescription(), muscleMapper.toEntityList(dto.getMuscleList()),
                difficultyMapper.toEntity(dto.getDifficulty()), dto.isEquipment(), exerciseCategoryMapper.toEntity(dto.getExerciseCategory()));
    }

    @Override
    public ExerciseDTO toDTO(Exercise entity) {
        if (entity.getId() == -1) {
            return new ExerciseDTO(entity.getName(), entity.getDescription(), muscleMapper.toDTOList(entity.getMuscleList()),
                    difficultyMapper.toDTO(entity.getDifficulty()), entity.isEquipment(), exerciseCategoryMapper.toDTO(entity.getExerciseCategory()));
        }
        return new ExerciseDTO(entity.getId(), entity.getName(), entity.getDescription(), muscleMapper.toDTOList(entity.getMuscleList()),
                difficultyMapper.toDTO(entity.getDifficulty()), entity.isEquipment(), exerciseCategoryMapper.toDTO(entity.getExerciseCategory()));

    }

    @Override
    public List<Exercise> toEntityList(List<ExerciseDTO> dtos) {
        List<Exercise> exercises = new ArrayList<>();
        for(ExerciseDTO exerciseDTO: dtos) {
            exercises.add(this.toEntity(exerciseDTO));
        }
        return exercises;
    }

    @Override
    public List<ExerciseDTO> toDTOList(List<Exercise> entities) {
        List<ExerciseDTO> dtos = new ArrayList<>();
        for(Exercise exercise: entities) {
            dtos.add(this.toDTO(exercise));
        }
        return dtos;
    }
}
