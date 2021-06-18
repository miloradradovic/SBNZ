package com.example.SBNZ.mappers;

import com.example.SBNZ.dto.MealDTO;
import com.example.SBNZ.enums.diet.HealthIssue;
import com.example.SBNZ.model.diet.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class MealMapper implements MapperInterface<Meal, MealDTO>{

    @Autowired
    MealTypeMapper mealTypeMapper;

    @Autowired
    HealthIssueMapper healthIssueMapper;

    @Override
    public Meal toEntity(MealDTO dto) {
        if (dto.getId() == -1) {
            return new Meal(dto.getkCal(), dto.getCarbonHydrates(), dto.getProteins(), dto.getFats(), dto.getName(),
                    mealTypeMapper.toEntity(dto.getMealType()), dto.getJunkPercentage(), healthIssueMapper.toEntitySet(dto.getHealthIssueTypes()),
                    dto.getRecipe());
        }
        return new Meal(dto.getId(), dto.getkCal(), dto.getCarbonHydrates(), dto.getProteins(), dto.getFats(), dto.getName(),
                mealTypeMapper.toEntity(dto.getMealType()), dto.getJunkPercentage(), healthIssueMapper.toEntitySet(dto.getHealthIssueTypes()),
                dto.getRecipe());
    }

    @Override
    public MealDTO toDTO(Meal entity) {
        if (entity.getId() == -1) {
            return new MealDTO(entity.getkCal(), entity.getCarbonHydrates(), entity.getProteins(), entity.getFats(), entity.getName(),
                    mealTypeMapper.toDTO(entity.getMealType()), entity.getJunkPercentage(), healthIssueMapper.toDTOList2(entity.getHealthIssueTypes()),
                    entity.getRecipe());
        }
        return new MealDTO(entity.getId(), entity.getkCal(), entity.getCarbonHydrates(), entity.getProteins(), entity.getFats(), entity.getName(),
                mealTypeMapper.toDTO(entity.getMealType()), entity.getJunkPercentage(), healthIssueMapper.toDTOList2(entity.getHealthIssueTypes()),
                entity.getRecipe());
    }

    @Override
    public List<Meal> toEntityList(List<MealDTO> dtos) {
        List<Meal> meals = new ArrayList<>();
        for (MealDTO dto: dtos) {
            meals.add(this.toEntity(dto));
        }
        return meals;
    }

    @Override
    public List<MealDTO> toDTOList(List<Meal> entities) {
        List<MealDTO> dtos = new ArrayList<>();
        for (Meal meal: entities) {
            dtos.add(this.toDTO(meal));
        }
        return dtos;
    }
}
