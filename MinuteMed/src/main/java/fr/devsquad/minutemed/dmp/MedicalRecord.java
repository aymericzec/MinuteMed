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
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private String gender;
    private String phoneNumber;
    private String email;

    public MedicalRecord() {

    }

    public MedicalRecord(String ss, String firstName, String lastName, String address, String email, String phoneNumber, Date birthday, GenderEnum gender) {
        this.ss = Objects.requireNonNull(ss);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.address = Objects.requireNonNull(address);
        this.email = Objects.requireNonNull(email);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        this.birthday = Objects.requireNonNull(birthday);
        this.gender = Objects.requireNonNull(gender.name());
    }

    public String getSs() {
        return this.ss;
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

    public String getGender() {
        return gender;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
