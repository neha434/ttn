package com.springboot.ecommerceApplication.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotEmpty;

public class UserDto {
    @NotEmpty
    private Integer id;
    @NotEmpty
    private String email;
    @NotEmpty
    @JsonIgnore  //Using Json ignore here will create internal server error at registration time
    private String password;
    @NotEmpty
    @JsonIgnore
    private String ConfirmPassword;
    @NotEmpty
    private String firstName;
    private String middleName;
    @NotEmpty
    private String lastName;

    public UserDto(){

    }

    public UserDto(@NotEmpty Integer id, @NotEmpty String email, @NotEmpty String firstName, String middleName, @NotEmpty String lastName) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return ConfirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        ConfirmPassword = confirmPassword;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", ConfirmPassword='" + ConfirmPassword + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
