package com.example.SBNZ.model.training.cep;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;

import java.io.Serializable;

@Role(Role.Type.EVENT)
@Expires("10s")
public class HighHeartRateAlarm implements Serializable {

    private static final long serialVersionUID = 1L;

    private String message;

    public HighHeartRateAlarm(String message) {
        this.message = message;
        System.out.println(message);
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
