package fr.devsquad.minutemed.dmp.domain;

import fr.devsquad.minutemed.arborescence.domain.NodeHU;
import static fr.devsquad.minutemed.dmp.domain.MedicalRecord.FIND_ALL_MEDICAL_RECORD;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = FIND_ALL_MEDICAL_RECORD, query = "SELECT u FROM MedicalRecord u")
public class MedicalRecord implements Serializable {
    
    public static final String FIND_ALL_MEDICAL_RECORD = "MedicalRecord.findAllMedicalRecord";
    
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
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idHu")
    private NodeHU hu;

    public MedicalRecord() {

    }

    public MedicalRecord(String ss, String firstName, String lastName, String address, String email, String phoneNumber, String birthday, String gender, NodeHU hu) {
        this.ss = Objects.requireNonNull(ss);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.address = Objects.requireNonNull(address);
        this.email = Objects.requireNonNull(email);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        this.birthday = Objects.requireNonNull(birthday);
        this.gender = Objects.requireNonNull(gender);
        this.hu = Objects.requireNonNull(hu);
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
    
    public NodeHU getHU() {
        return hu;
    }
    
    public void setHU(NodeHU hu) {
        this.hu = hu;
    } 

}
