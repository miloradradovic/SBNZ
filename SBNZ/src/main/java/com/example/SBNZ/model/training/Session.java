package com.example.SBNZ.model.training;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Session {

    private Long id;
    private Exercise exercise;
    private float weight; // optional
    private float duration; // optional
}
