package com.example.SBNZ.mappers;

import com.example.SBNZ.enums.training.ExerciseCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExerciseCategoryMapper implements MapperInterface<ExerciseCategory, String> {

    @Override
    public ExerciseCategory toEntity(String dto) {
        return ExerciseCategory.valueOf(dto);
    }

    @Override
    public String toDTO(ExerciseCategory entity) {
        return entity.toString();
    }

    @Override
    public List<ExerciseCategory> toEntityList(List<String> dtos) {
        List<ExerciseCategory> entities = new ArrayList<>();
        for(String dto: dtos) {
            entities.add(this.toEntity(dto));
        }
        return entities;
    }

    @Override
    public List<String> toDTOList(List<ExerciseCategory> entities) {
        List<String> dtos = new ArrayList<>();
        for(ExerciseCategory exerciseCategory: entities) {
            dtos.add(this.toDTO(exerciseCategory));
        }
        return dtos;
    }
}
