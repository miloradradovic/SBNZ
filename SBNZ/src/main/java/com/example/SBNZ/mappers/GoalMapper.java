package com.example.SBNZ.mappers;

import com.example.SBNZ.enums.diet.Goal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GoalMapper implements MapperInterface<Goal, String>{

    @Override
    public Goal toEntity(String dto) {
        return Goal.valueOf(dto);
    }

    @Override
    public String toDTO(Goal entity) {
        return entity.toString();
    }

    @Override
    public List<Goal> toEntityList(List<String> dtos) {
        List<Goal> goals = new ArrayList<>();
        for (String dto: dtos) {
            goals.add(this.toEntity(dto));
        }
        return goals;
    }

    @Override
    public List<String> toDTOList(List<Goal> entities) {
        List<String> dtos = new ArrayList<>();
        for (Goal goal: entities) {
            dtos.add(this.toDTO(goal));
        }
        return dtos;
    }
}
