package com.example.SBNZ.mappers;

import com.example.SBNZ.dto.TrainingDTO;
import com.example.SBNZ.model.training.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TrainingMapper implements MapperInterface<Training, TrainingDTO> {

    @Autowired
    SessionMapper sessionMapper;

    @Autowired
    GoalMapper goalMapper;

    @Autowired
    MuscleMapper muscleMapper;

    @Override
    public Training toEntity(TrainingDTO dto) {
        if (dto.getId() == -1) {
            return new Training(sessionMapper.toEntityList(dto.getSessions()), dto.getRestTime(), dto.getNumberOfSessions(),
                    goalMapper.toEntity(dto.getGoal()), muscleMapper.toEntityList(dto.getMuscles()));
        }
        return new Training(dto.getId(), sessionMapper.toEntityList(dto.getSessions()), dto.getRestTime(), dto.getNumberOfSessions(),
                goalMapper.toEntity(dto.getGoal()), muscleMapper.toEntityList(dto.getMuscles()));
    }

    @Override
    public TrainingDTO toDTO(Training entity) {
        if (entity.getId() == -1) {
            return new TrainingDTO(sessionMapper.toDTOList(entity.getSessionList()), entity.getRestTime(), entity.getNumberOfSessions(),
                    goalMapper.toDTO(entity.getGoal()), muscleMapper.toDTOList(entity.getMuscles()));
        }
        return new TrainingDTO(entity.getId(), sessionMapper.toDTOList(entity.getSessionList()), entity.getRestTime(), entity.getNumberOfSessions(),
                goalMapper.toDTO(entity.getGoal()), muscleMapper.toDTOList(entity.getMuscles()));
    }

    @Override
    public List<Training> toEntityList(List<TrainingDTO> dtos) {
        List<Training> trainings = new ArrayList<>();
        for (TrainingDTO dto: dtos) {
            trainings.add(this.toEntity(dto));
        }
        return trainings;
    }

    @Override
    public List<TrainingDTO> toDTOList(List<Training> entities) {
        List<TrainingDTO> dtos = new ArrayList<>();
        for (Training training: entities) {
            dtos.add(this.toDTO(training));
        }
        return dtos;
    }
}
