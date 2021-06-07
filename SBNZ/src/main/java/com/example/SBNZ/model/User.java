package com.example.SBNZ.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.example.SBNZ.model.diet.Diet;
import com.example.SBNZ.model.training.HeartRateProblem;
import com.example.SBNZ.model.training.Session;
import com.example.SBNZ.model.training.TrainingPlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
public class User extends Person{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    private TrainingPlan trainingPlan;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diet_id", referencedColumnName = "id")
    private Diet diet;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "userId")
    private List<HeartRateProblem> problems = new ArrayList<>();

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return super.isVerified();
    }

    public User(String firstName, String lastName, String username, String password, boolean verified, int age) {
        super(firstName, lastName, username, password, verified,age);
    }
    
    public User() {
    	super();
    }
    
    public User(int id, String firstName, String lastName, String username, String password, boolean verified, int age) {
        super(id, firstName, lastName, username, password, verified, age);
    }


    public User(String firstName, String lastName, String username, String password, boolean verified,int age, TrainingPlan trainingPlan, Diet diet, List<HeartRateProblem> problems) {
        super(firstName, lastName, username, password, verified, age);
        this.trainingPlan = trainingPlan;
        this.diet = diet;
        this.problems = problems;
    }

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public List<HeartRateProblem> getProblems() {
        return problems;
    }

    public void setProblems(List<HeartRateProblem> problems) {
        this.problems = problems;
    }
}
