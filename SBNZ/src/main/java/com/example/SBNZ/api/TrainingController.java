package com.example.SBNZ.api;

import com.example.SBNZ.dto.TrainingPlanDTO;
import com.example.SBNZ.mappers.TrainingPlanMapper;
import com.example.SBNZ.model.Person;
import com.example.SBNZ.model.TestRuleModel;
import com.example.SBNZ.model.training.InputDataTraining;
import com.example.SBNZ.model.training.Training;
import com.example.SBNZ.model.training.TrainingPlan;
import com.example.SBNZ.model.training.cep.CEPInput;
import com.example.SBNZ.service.TrainingPlanService;
import com.example.SBNZ.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/training")
public class TrainingController {

    @Autowired
    TrainingService trainingService;

    @Autowired
    TrainingPlanService trainingPlanService;

    @Autowired
    TrainingPlanMapper trainingPlanMapper;

    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<TrainingPlanDTO> getTraining(@RequestBody InputDataTraining input) {

        TrainingPlan result = trainingService.getTrainingPlan(input);
        return new ResponseEntity<>(trainingPlanMapper.toDTO(result), HttpStatus.OK);
    }

    @RequestMapping(value = "/cep", method = RequestMethod.POST)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> doCEP(@RequestBody List<CEPInput> input) {

        trainingService.doCEP(input);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/get-plan-by-logged-in-user", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<TrainingPlanDTO> getPlanOfLoggedInUser() {

        TrainingPlan plan = trainingPlanService.findByUser();
        return new ResponseEntity<TrainingPlanDTO>(trainingPlanMapper.toDTO(plan), HttpStatus.OK);
    }

}
