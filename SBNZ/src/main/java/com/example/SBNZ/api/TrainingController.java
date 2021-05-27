package com.example.SBNZ.api;

import com.example.SBNZ.model.TestRuleModel;
import com.example.SBNZ.model.training.InputDataTraining;
import com.example.SBNZ.model.training.Training;
import com.example.SBNZ.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/training")
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Training> getTraining(@RequestBody InputDataTraining input) {

    	Training result = trainingService.getTraining(input);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


}
