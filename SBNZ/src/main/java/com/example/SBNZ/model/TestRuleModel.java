package com.example.SBNZ.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TestRuleModel {

    private String message;

    public TestRuleModel(String message) {
        this.message = message;
    }


}
