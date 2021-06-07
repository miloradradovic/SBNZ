package com.example.SBNZ.mappers;

import com.example.SBNZ.dto.CEPInputDTO;
import com.example.SBNZ.model.training.cep.CEPInput;
import com.example.SBNZ.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CEPInputMapper implements MapperInterface<CEPInput, CEPInputDTO>{

    @Autowired
    ExerciseMapper exerciseMapper;

    @Autowired
    ExerciseService exerciseService;

    @Override
    public CEPInput toEntity(CEPInputDTO dto) {
        return new CEPInput(exerciseService.findById(dto.getExerciseDTO()), dto.getHeartRate());
    }

    @Override
    public CEPInputDTO toDTO(CEPInput entity) {
        return new CEPInputDTO(entity.getExercise().getId(), entity.getHeartRate());
    }

    @Override
    public List<CEPInput> toEntityList(List<CEPInputDTO> dtos) {
        List<CEPInput> inputs = new ArrayList<>();
        for (CEPInputDTO dto: dtos) {
            inputs.add(this.toEntity(dto));
        }
        return inputs;
    }

    @Override
    public List<CEPInputDTO> toDTOList(List<CEPInput> entities) {
        List<CEPInputDTO> dtos = new ArrayList<>();
        for (CEPInput cepInput: entities) {
            dtos.add(this.toDTO(cepInput));
        }
        return dtos;
    }
}
