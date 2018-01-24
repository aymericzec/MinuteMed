/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author myfou
 */
public class MedicalIRecord {
    private long id;
    private String ss;
    private String firstName;
    private String lastName;
    private String address;
    private Date birthday;
    private String gender;
    private String phoneNumber;
    private String email;
    
    public MedicalIRecord() {
        
    }

    public MedicalIRecord(String ss, String firstName, String lastName, String address, String email, String phoneNumber, Date birthday, String gender) {
        this.ss = Objects.requireNonNull(ss);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.address = Objects.requireNonNull(address);
        this.email = Objects.requireNonNull(email);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        this.birthday = Objects.requireNonNull(birthday);
        this.gender = Objects.requireNonNull(gender);
    }
    
    public String getSs() {
        return this.ss;
    }

    public String getFirstName() {
           return this.firstName;
    }
    
    public String getLastName() {
           return this.lastName;
    }

    public String getAddress() {
        return this.address;
    }
    
    public String getGender() {
        return this.gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setAddress (String address) {
        this.address = address;
    }
    
    public void setPhoneNumber (String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public void setEmail (String email) {
        this.email = email;
    }
    
}
