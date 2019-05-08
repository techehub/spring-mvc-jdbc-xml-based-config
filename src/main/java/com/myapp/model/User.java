package com.myapp.model;


import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotEmpty (message="Username required")
    @Size(min=5, max=10 , message = "Min size 5 max size 10")
    private String username;

    @NotEmpty (message="Password required")
    private String password;

    @NotEmpty (message="Password required")
    private String firstname;

    @NotEmpty (message="Password required")

    private String lastname;

    @NotEmpty (message="Password required")
    @Email(message ="Not valid email")
    private String email;
    private String address;
    private int phone;

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
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
}