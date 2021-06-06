package com.example.SBNZ.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;


@Entity
@Table(name = "users")
public class User extends Person{


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

    public User(String firstName, String lastName, String username, String password, boolean verified) {
        super(firstName, lastName, username, password, verified);
    }
    
}
