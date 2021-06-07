package com.example.SBNZ.model.training;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "exercise_id")
    private Exercise exercise;

    @Column(name = "weight", nullable = false)
    private float weight; // optional

    @Column(name = "repetitions", nullable = false)
    private int repetitions; //optional

    @Column(name = "duration", nullable = false)
    private float duration; // optional

    public Session() {
    }

    public Session(Exercise exercise, float weight, int repetitions, float duration) {
        this.exercise = exercise;
        this.weight = weight;
        this.repetitions = repetitions;
        this.duration = duration;
    }

    public Session(int id, Exercise exercise, float weight, int repetitions, float duration) {
        this.id = id;
        this.exercise = exercise;
        this.weight = weight;
        this.repetitions = repetitions;
        this.duration = duration;
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }
}
