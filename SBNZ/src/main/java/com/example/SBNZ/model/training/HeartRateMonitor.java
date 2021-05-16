package com.example.SBNZ.model.training;

import com.example.SBNZ.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HeartRateMonitor {

    private Long id;
    private User user;
    private float highestRate;
    private float lowestRate;
    private float currentRate;
}
