package com.example.SBNZ.mappers;

import com.example.SBNZ.enums.diet.MealType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MealTypeMapper implements MapperInterface<MealType, String>{

    @Override
    public MealType toEntity(String dto) {
        return MealType.valueOf(dto);
    }

    @Override
    public String toDTO(MealType entity) {
        return entity.toString();
    }

    @Override
    public List<MealType> toEntityList(List<String> dtos) {
        List<MealType> mealTypes = new ArrayList<>();
        for (String dto: dtos) {
            mealTypes.add(this.toEntity(dto));
        }
        return mealTypes;
    }

    @Override
    public List<String> toDTOList(List<MealType> entities) {
        List<String> dtos = new ArrayList<>();
        for (MealType mealType: entities) {
            dtos.add(this.toDTO(mealType));
        }
        return dtos;
    }
}
