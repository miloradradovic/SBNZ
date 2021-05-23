package com.example.SBNZ.api;

import com.example.SBNZ.model.diet.Diet;
import com.example.SBNZ.model.diet.InputDataDiet;
import com.example.SBNZ.model.training.InputDataTraining;
import com.example.SBNZ.model.training.Training;
import com.example.SBNZ.service.DietService;
import com.example.SBNZ.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/training")
public class DietController {

    @Autowired
    DietService dietService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Diet> getDiet(@RequestBody InputDataDiet input) {

        Diet result = dietService.getDiet(input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
