package com.example.SBNZ.mappers;

import com.example.SBNZ.dto.SessionDTO;
import com.example.SBNZ.model.training.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SessionMapper implements MapperInterface<Session, SessionDTO> {

    @Autowired
    private ExerciseMapper exerciseMapper;

    @Override
    public Session toEntity(SessionDTO dto) {
        if (dto.getId() == -1) {
            return new Session(exerciseMapper.toEntity(dto.getExerciseDTO()), dto.getWeight(),
                    dto.getRepetitions(), dto.getDuration());
        }
        return new Session(dto.getId(), exerciseMapper.toEntity(dto.getExerciseDTO()), dto.getWeight(),
                dto.getRepetitions(), dto.getDuration());
    }

    @Override
    public SessionDTO toDTO(Session entity) {
        if (entity.getId() == -1) {
            return new SessionDTO(exerciseMapper.toDTO(entity.getExercise()), entity.getWeight(),
                    entity.getRepetitions(), entity.getDuration());
        }
        return new SessionDTO(entity.getId(), exerciseMapper.toDTO(entity.getExercise()), entity.getWeight(),
                entity.getRepetitions(), entity.getDuration());
    }

    @Override
    public List<Session> toEntityList(List<SessionDTO> dtos) {
        List<Session> sessions = new ArrayList<>();
        for (SessionDTO dto: dtos) {
            sessions.add(this.toEntity(dto));
        }
        return sessions;
    }

    @Override
    public List<SessionDTO> toDTOList(List<Session> entities) {
        List<SessionDTO> dtos = new ArrayList<>();
        for (Session session: entities) {
            dtos.add(this.toDTO(session));
        }
        return dtos;
    }
}
