package com.example.SBNZ.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ")
    @SequenceGenerator(sequenceName = "person_seq", name = "PERSON_SEQ", allocationSize = 1)
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "verified", unique = false, nullable = true)
    private boolean verified;

    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;

    public Person() {
        authorities = new ArrayList<>();
    }
}
