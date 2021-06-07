package com.example.SBNZ.model.training.cep;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
@Expires("15s")
public class LowHeartRateEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private double currentRate;
    private String message;

    public LowHeartRateEvent(double currentRate, String message) {
        this.currentRate = currentRate;
        this.message = message;
        System.out.println(message);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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
