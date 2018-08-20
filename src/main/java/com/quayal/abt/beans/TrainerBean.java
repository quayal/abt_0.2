package com.quayal.abt.beans;

import org.springframework.context.annotation.Bean;

public class TrainerBean {

    private short id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;

    public TrainerBean() {
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
