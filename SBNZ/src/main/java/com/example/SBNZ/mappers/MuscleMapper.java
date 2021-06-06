package com.example.SBNZ.mappers;

import com.example.SBNZ.enums.training.Muscle;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MuscleMapper implements MapperInterface<Muscle, String>{

    @Override
    public Muscle toEntity(String dto) {
        return Muscle.valueOf(dto);
    }

    @Override
    public String toDTO(Muscle entity) {
        return entity.toString();
    }

    @Override
    public List<Muscle> toEntityList(List<String> dtos) {
        List<Muscle> muscles = new ArrayList<>();
        for(String dto: dtos) {
            muscles.add(this.toEntity(dto));
        }
        return muscles;
    }

    @Override
    public List<String> toDTOList(List<Muscle> entities) {
        List<String> dtos = new ArrayList<>();
        for(Muscle muscle: entities){
            dtos.add(this.toDTO(muscle));
        }
        return dtos;
    }
}
