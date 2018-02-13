package fr.devsquad.minutemed.staff.domain;

import fr.devsquad.minutemed.arborescence.domain.*;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("MEDICAL_STAFF") //DTYPE
public class MedicalStaff implements Serializable {
    
    @Id @GeneratedValue
    private long idMedicalStaff;
    
    @NotNull
    private String status;
    
    @NotNull
    private String firstName;
    
    @NotNull
    private String lastName;
    
    @NotNull
    private String address;
    
    @NotNull
    private String email;
    
    @NotNull
    private String phoneNumber;   
    
    @NotNull
    @OneToOne @MapsId
    private Node node;
    
   
    public MedicalStaff() { }
    
    public MedicalStaff(String status){
        this.status = Objects.requireNonNull(status);
    }

    public MedicalStaff(String status, String firstName, String lastName, String address, String email, String phoneNumber, Node node) {
        this.status = Objects.requireNonNull(status);
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.address = Objects.requireNonNull(address);
        this.email = Objects.requireNonNull(email);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        this.node = Objects.requireNonNull(node);
    }

    /**
     * @return the id
     */
    public long getIdMedicalStaff() {
        return idMedicalStaff;
    }


    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = Objects.requireNonNull(status);
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = Objects.requireNonNull(firstName);
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = Objects.requireNonNull(lastName);
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = Objects.requireNonNull(address);
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email);
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
    }

    /**
     * @return the node
     */
    public Node getNode() {
        return node;
    }

    /**
     * @param node the node to set
     */
    public void setNode(Node node) {
        this.node = Objects.requireNonNull(node);
    }
    
}
