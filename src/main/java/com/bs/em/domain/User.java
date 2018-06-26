package com.bs.em.domain;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = {"IDNO"}))
@Access(AccessType.FIELD)
@SequenceGenerator(name = "seq_em", sequenceName = "seq_user", allocationSize = 1, initialValue = 1)
public class User extends AbstractPersistable<Long> {
    private Long idNo;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String race;
    private String username;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
