package com.example.SBNZ.api;

import com.example.SBNZ.model.TestRuleModel;
import com.example.SBNZ.service.TestingRulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/test")
public class TestingRulesController {

    @Autowired
    TestingRulesService testingRulesService;

    @RequestMapping(method = RequestMethod.GET, value = "/{message}")
    public ResponseEntity<TestRuleModel> testRules(@PathVariable String message) {
        TestRuleModel success = testingRulesService.tryRules(new TestRuleModel(message));

        return new ResponseEntity<>(success, HttpStatus.OK);
    }


}
