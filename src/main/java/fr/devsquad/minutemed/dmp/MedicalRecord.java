package fr.devsquad.minutemed.dmp;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class MedicalRecord implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "idMedicalRecord")
    private long id;
    private String ss;
    private String firstName;
    private String lastName;
    private String address;
    private String birthday;
    private String gender;
    private String phoneNumber;
    private String email;

    public MedicalRecord() {

    }

    public MedicalRecord(String ss, String firstName, String lastName, String address, String email, String phoneNumber, String birthday, String gender) {
        this.ss = Objects.requireNonNull(ss);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.address = Objects.requireNonNull(address);
        this.email = Objects.requireNonNull(email);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        this.birthday = Objects.requireNonNull(birthday);
        this.gender = Objects.requireNonNull(gender);
    }

    public long getId() {
        return id;
    }

    public String getSs() {
        return ss;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    
}
