package com.example.SBNZ.model;

import com.example.SBNZ.model.diet.Diet;
import com.example.SBNZ.model.training.TrainingPlan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends Person{

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "plan_id", referencedColumnName = "id")
    private TrainingPlan trainingPlan;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diet_id", referencedColumnName = "id")
    private Diet diet;

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

    public User(int id, String firstName, String lastName, String username, String password, boolean verified) {
        super(id, firstName, lastName, username, password, verified);
    }

    public User(String firstName, String lastName, String username, String password, boolean verified) {
        super(firstName, lastName, username, password, verified);
    }

    public User(){
        super();
    }

    public User(String firstName, String lastName, String username, String password, boolean verified, TrainingPlan trainingPlan, Diet diet) {
        super(firstName, lastName, username, password, verified);
        this.trainingPlan = trainingPlan;
        this.diet = diet;
    }

}
