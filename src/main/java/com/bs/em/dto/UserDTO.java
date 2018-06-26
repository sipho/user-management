package com.bs.em.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class UserDTO {

    private Long id;
    @NotNull
    @JsonProperty("id_number")
    private Long idNo;
    @NotEmpty
    @NotBlank
    private String username;
    @NotEmpty
    @NotBlank
    @JsonProperty("first_name")
    private String firstName;
    @NotEmpty
    @NotBlank
    @JsonProperty("last_name")
    private String lastName;
    @NotEmpty
    @NotBlank
    private String email;
    @NotEmpty
    @NotBlank
    @JsonProperty("mobile_number")
    private String mobileNumber;
    @NotEmpty
    @NotBlank
    private String race;

    public Long getIdNo() {
        return idNo;
    }

    public void setIdNo(Long idNo) {
        this.idNo = idNo;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
