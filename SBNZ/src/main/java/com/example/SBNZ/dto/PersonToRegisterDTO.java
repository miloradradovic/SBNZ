package com.example.SBNZ.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PersonToRegisterDTO {

    private int id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String username;

    @NotBlank
    @Size(min = 8)
    private String password;

    public PersonToRegisterDTO() {
    }

    public PersonToRegisterDTO(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String username, @NotBlank @Size(min = 8) String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
