package com.example.SBNZ.api;

import com.example.SBNZ.model.TestRuleModel;
import com.example.SBNZ.model.training.InputDataTraining;
import com.example.SBNZ.model.training.Training;
import com.example.SBNZ.model.training.cep.CEPInput;
import com.example.SBNZ.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/training")
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<List<Training>> getTraining(@RequestBody InputDataTraining input) {

    	List<Training> result = trainingService.getTraining(input, "username");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/cep", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> doCEP(@RequestBody List<CEPInput> input) {

        trainingService.doCEP(input);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
