package com.example.SBNZ.api;

import com.example.SBNZ.dto.CEPInputDTO;
import com.example.SBNZ.dto.ExerciseDTO;
import com.example.SBNZ.dto.MealDTO;
import com.example.SBNZ.mappers.ExerciseMapper;
import com.example.SBNZ.model.training.Exercise;
import com.example.SBNZ.model.training.cep.CEPOutput;
import com.example.SBNZ.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/exercises")
public class ExerciseController {

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    ExerciseMapper exerciseMapper;

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    public ResponseEntity<ExerciseDTO> createExercise(@RequestBody ExerciseDTO input) {

        Exercise saved = exerciseService.save(exerciseMapper.toEntity(input));
        if (saved != null) {
            return new ResponseEntity<>(exerciseMapper.toDTO(saved), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR')")
    public ResponseEntity<List<ExerciseDTO>> getAllExercises() {

        List<Exercise> result = exerciseService.findAll();
        return new ResponseEntity<>(exerciseMapper.toDTOList(result), HttpStatus.OK);
    }
}
