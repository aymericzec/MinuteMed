package fr.devsquad.minutemed.dmp.domain;

import fr.devsquad.minutemed.arborescence.domain.*;
import static fr.devsquad.minutemed.dmp.domain.MedicalRecord.FIND_ALL_MEDICAL_RECORD;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NamedQuery(name = FIND_ALL_MEDICAL_RECORD, query = "SELECT u FROM MedicalRecord u")
public class MedicalRecord implements Serializable {
    
    public static final String FIND_ALL_MEDICAL_RECORD = "MedicalRecord.findAllMedicalRecord";
    
    @Id @GeneratedValue
    private long idMedicalRecord;
    
    @NotNull
    private String ss;
    
    @NotNull
    private String firstName;
    
    @NotNull
    private String lastName;
    
    @NotNull
    private String address;
    
    @NotNull
    private String birthday;
    
    @NotNull
    private String gender;
    
    @NotNull
    private String phoneNumber;
    
    @NotNull
    private String email;
    
    @NotNull
    @ManyToOne
    private NodeCU careUnit;

    
    public MedicalRecord() {

    }

    public MedicalRecord(String ss, String firstName, String lastName, String address, String email, String phoneNumber, String birthday, String gender, NodeCU careUnit) {
        this.ss = Objects.requireNonNull(ss);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.address = Objects.requireNonNull(address);
        this.email = Objects.requireNonNull(email);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        this.birthday = Objects.requireNonNull(birthday);
        this.gender = Objects.requireNonNull(gender);
        this.careUnit = Objects.requireNonNull(careUnit);
    }

    public long getIdMedicalRecord() {
        return idMedicalRecord;
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
    
    public NodeCU getCU() {
        return careUnit;
    }
    
    public void setCU(NodeCU careUnit) {
        this.careUnit = Objects.requireNonNull(careUnit);
    } 

}
