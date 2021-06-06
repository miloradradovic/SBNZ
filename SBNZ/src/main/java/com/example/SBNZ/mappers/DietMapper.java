package com.example.SBNZ.mappers;

import com.example.SBNZ.dto.DietDTO;
import com.example.SBNZ.model.diet.Diet;
import com.example.SBNZ.model.diet.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DietMapper implements MapperInterface<Diet, DietDTO>{

    @Autowired
    GoalMapper goalMapper;

    @Autowired
    MealMapper mealMapper;

    @Override
    public Diet toEntity(DietDTO dto) {
        if (dto.getId() == -1) {
            return new Diet(dto.getkCal(), dto.getCarbonHydrates(), dto.getProteins(), dto.getFats(),
                    dto.getCalorieMin(), dto.getCalorieMax(), dto.getRecommendedTime(), goalMapper.toEntity(dto.getGoal()),
                    mealMapper.toEntityList(dto.getMeals()));
        }
        return new Diet(dto.getId(), dto.getkCal(), dto.getCarbonHydrates(), dto.getProteins(), dto.getFats(),
                dto.getCalorieMin(), dto.getCalorieMax(), dto.getRecommendedTime(), goalMapper.toEntity(dto.getGoal()),
                mealMapper.toEntityList(dto.getMeals()));
    }

    @Override
    public DietDTO toDTO(Diet entity) {
        if (entity.getId() == -1) {
            return new DietDTO(entity.getkCal(), entity.getCarbonHydrates(), entity.getProteins(), entity.getFats(),
                    entity.getCalorieMin(), entity.getCalorieMax(), entity.getRecommendedTime(), goalMapper.toDTO(entity.getGoal()),
                    mealMapper.toDTOList(entity.getMeals()));
        }
        return new DietDTO(entity.getId(), entity.getkCal(), entity.getCarbonHydrates(), entity.getProteins(), entity.getFats(),
                entity.getCalorieMin(), entity.getCalorieMax(), entity.getRecommendedTime(), goalMapper.toDTO(entity.getGoal()),
                mealMapper.toDTOList(entity.getMeals()));
    }

    @Override
    public List<Diet> toEntityList(List<DietDTO> dtos) {
        List<Diet> diets = new ArrayList<>();
        for (DietDTO dto: dtos) {
            diets.add(this.toEntity(dto));
        }
        return diets;
    }

    @Override
    public List<DietDTO> toDTOList(List<Diet> entities) {
        List<DietDTO> dtos = new ArrayList<>();
        for (Diet diet: entities) {
            dtos.add(this.toDTO(diet));
        }
        return dtos;
    }
}
