package com.example.SBNZ.model.training.cep;

import com.example.SBNZ.model.User;
import com.example.SBNZ.model.training.Exercise;
import com.example.SBNZ.model.training.HeartRateProblem;
import com.example.SBNZ.service.HeartRateProblemService;
import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Role(Role.Type.EVENT)
@Expires("15s")
public class HighHeartRateAlarm implements Serializable {

    private static final long serialVersionUID = 1L;

    HeartRateProblemService heartRateProblemService = new HeartRateProblemService();

    private String message;

    public HighHeartRateAlarm(String message) {
        this.message = message;
        System.out.println(message);
       // heartRateProblemService.saveOne(new HeartRateProblem(exercise, user, LocalDate.now()));
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
