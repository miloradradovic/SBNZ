package com.example.SBNZ.model.training;

import com.example.SBNZ.enums.training.ExerciseCategory;
import com.example.SBNZ.enums.training.HeartRateProblemType;
import com.example.SBNZ.model.User;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "heart_rate_problems")
public class HeartRateProblem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @Column(name = "date", nullable = false)
    private LocalDate dateOfProblem;

    @Enumerated(EnumType.STRING)
    private HeartRateProblemType heartRateProblemType;

    public HeartRateProblem() {
    }

    public HeartRateProblem(Exercise exercise, User user, LocalDate dateOfProblem, HeartRateProblemType heartRateProblemType) {
        this.exercise = exercise;
        this.user = user;
        this.dateOfProblem = dateOfProblem;
        this.heartRateProblemType = heartRateProblemType;
    }

    public HeartRateProblem(int id, Exercise exercise, User user, LocalDate dateOfProblem, HeartRateProblemType heartRateProblemType) {
        this.id = id;
        this.exercise = exercise;
        this.user = user;
        this.dateOfProblem = dateOfProblem;
        this.heartRateProblemType = heartRateProblemType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDateOfProblem() {
        return dateOfProblem;
    }

    public void setDateOfProblem(LocalDate dateOfProblem) {
        this.dateOfProblem = dateOfProblem;
    }

    public HeartRateProblemType getHeartRateProblemType() {
        return heartRateProblemType;
    }

    public void setHeartRateProblemType(HeartRateProblemType heartRateProblemType) {
        this.heartRateProblemType = heartRateProblemType;
    }
}
