package com.example.SBNZ.model.training;

import com.example.SBNZ.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "training_plans")
public class TrainingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "planId")
    private List<Training> trainings = new ArrayList<>();

    @OneToOne(mappedBy = "trainingPlan")
    private User user;

    public TrainingPlan() {
    }

    public TrainingPlan(List<Training> trainings) {
        this.trainings = trainings;
    }

    public TrainingPlan(List<Training> trainings, User user) {
        this.trainings = trainings;
        this.user = user;
    }

    public TrainingPlan(int id, List<Training> trainings) {
        this.id = id;
        this.trainings = trainings;
    }

    public TrainingPlan(int id, List<Training> trainings, User user) {
        this.id = id;
        this.trainings = trainings;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
