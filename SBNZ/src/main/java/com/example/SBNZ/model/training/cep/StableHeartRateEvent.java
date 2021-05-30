package com.example.SBNZ.model.training.cep;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
@Expires("10s")
public class StableHeartRateEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private double currentRate;
    private String message;

    public StableHeartRateEvent(double currentRate, String message) {
        this.currentRate = currentRate;
        this.message = message;
        System.out.println(message);
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(double currentRate) {
        this.currentRate = currentRate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
