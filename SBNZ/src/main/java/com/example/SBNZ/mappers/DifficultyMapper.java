package com.example.SBNZ.mappers;

import com.example.SBNZ.enums.training.Difficulty;
import org.apache.commons.lang3.builder.Diff;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DifficultyMapper implements MapperInterface<Difficulty, String> {

    @Override
    public Difficulty toEntity(String dto) {
        return Difficulty.valueOf(dto);
    }

    @Override
    public String toDTO(Difficulty entity) {
        return entity.toString();
    }

    @Override
    public List<Difficulty> toEntityList(List<String> dtos) {
        List<Difficulty> difficulties = new ArrayList<>();
        for(String dto: dtos) {
            difficulties.add(this.toEntity(dto));
        }
        return difficulties;
    }

    @Override
    public List<String> toDTOList(List<Difficulty> entities) {
        List<String> dtos = new ArrayList<>();
        for(Difficulty difficulty: entities) {
            dtos.add(this.toDTO(difficulty));
        }
        return dtos;
    }
}
