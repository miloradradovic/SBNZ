package com.example.SBNZ.mappers;

import com.example.SBNZ.dto.TrainingPlanDTO;
import com.example.SBNZ.model.training.TrainingPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrainingPlanMapper implements MapperInterface<TrainingPlan, TrainingPlanDTO> {

    @Autowired
    TrainingMapper trainingMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public TrainingPlan toEntity(TrainingPlanDTO dto) {
        if (dto.getId() == -1) {
            return new TrainingPlan(trainingMapper.toEntityList(dto.getTrainings()));
        }
        return new TrainingPlan(dto.getId(), trainingMapper.toEntityList(dto.getTrainings()));
    }

    @Override
    public TrainingPlanDTO toDTO(TrainingPlan entity) {
        if (entity.getId() == -1) {
            return new TrainingPlanDTO(trainingMapper.toDTOList(entity.getTrainings()));
        }
        return new TrainingPlanDTO(entity.getId(), trainingMapper.toDTOList(entity.getTrainings()));
    }

    @Override
    public List<TrainingPlan> toEntityList(List<TrainingPlanDTO> dtos) {
        List<TrainingPlan> trainingPlans = new ArrayList<>();
        for (TrainingPlanDTO trainingPlanDTO: dtos) {
            trainingPlans.add(this.toEntity(trainingPlanDTO));
        }
        return trainingPlans;
    }

    @Override
    public List<TrainingPlanDTO> toDTOList(List<TrainingPlan> entities) {
        List<TrainingPlanDTO> dtos = new ArrayList<>();
        for (TrainingPlan trainingPlan: entities) {
            dtos.add(this.toDTO(trainingPlan));
        }
        return dtos;
    }
}
