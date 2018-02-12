package fr.devsquad.minutemed.staff.domain;

import fr.devsquad.minutemed.arborescence.domain.*;
import fr.devsquad.minutemed.authentication.domain.DoctorCreator;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import static fr.devsquad.minutemed.staff.domain.Doctor.FIND_ALL_DOCTOR;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;


@Entity
@NamedQuery(name = FIND_ALL_DOCTOR, query = "SELECT staff FROM Doctor staff")
public class Doctor implements Serializable, IHospitalStaff, IMedicalStaff, ISpecialistStaff {

    public static final String FIND_ALL_DOCTOR = "Doctor.findAllDoctor";
    
    @Id
    @Column(name = "idDoctor")
    private Long id; 
    
    @NotNull
    private String type;
    
    @NotNull
    private String firstName;
    
    @NotNull
    private String lastName;
    
    @NotNull
    private String adress;
    
    @NotNull
    private String email;
    
    @NotNull
    private String phoneNumber;
    
    @NotNull
    private String specialization;
    
    @NotNull
    @JoinColumn(name = "idNode")
    private Node node;
 
    public Doctor() { }
    
    public Doctor(Long id, String firstName, String lastName, String adress, String email, String phoneNumber, Node node , Specialization specialization) { 
      
        if( stringNotConform(firstName) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(lastName) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(adress) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(email) ){
            throw new IllegalArgumentException();
        }
        if( stringNotConform(phoneNumber) ){
            throw new IllegalArgumentException();
        }
        this.id = Objects.requireNonNull(id);
        this.type = StaffEnum.DOCTOR.name();
        this.firstName = Objects.requireNonNull(firstName);
        this.lastName = Objects.requireNonNull(lastName);
        this.adress = Objects.requireNonNull(adress);
        this.email = Objects.requireNonNull(email);
        this.phoneNumber = Objects.requireNonNull(phoneNumber);
        this.node = Objects.requireNonNull(node);
        this.specialization = Objects.requireNonNull(specialization).getStaffName();
    }
    
    public static Doctor createFromDoctorCreator(Long id, DoctorCreator doctorCreator, Node node, Specialization specialization){
        Objects.requireNonNull(doctorCreator);
        return new Doctor(Objects.requireNonNull(id), doctorCreator.getFirstName(), doctorCreator.getFirstName(), 
                            doctorCreator.getAdress(), doctorCreator.getEmail(), doctorCreator.getPhoneNumber(),
                            Objects.requireNonNull(node), specialization);
    }
    
    private static boolean stringNotConform(String s){
        return s.matches("[ ]*");
    }

    @Override
    public long getId() {
        return id;
    }
       
    @Override
    public String getType() {
        return type;
    }
    
    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public String getAdress() {
        return adress;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPhoneNumber() {
       return phoneNumber;
    }
    
    @Override
    public Node getNode() {
        return node;
    }

    @Override
    public String getSpecialization() {
        return specialization;
    }
    
    @Override
    public void setFirstName(String firstName) {
        Objects.requireNonNull(firstName);
        if(stringNotConform(firstName)){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
        Objects.requireNonNull(lastName);
        if(stringNotConform(lastName)){
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;
    }

    @Override
    public void setAdress(String adress) {
        Objects.requireNonNull(adress);
        if(stringNotConform(adress)){
            throw new IllegalArgumentException();
        }
        this.adress = adress;
    }

    @Override
    public void setEmail(String email) {
        if(email==null){
            throw new NullPointerException();
        }
        if(stringNotConform(email)){
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber==null){
            throw new NullPointerException();
        }
        if(stringNotConform(phoneNumber)){
            throw new IllegalArgumentException();
        }
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public void setNode(Node node) {
        if(node==null){
            throw new NullPointerException();
        }
        this.node = node;
    }
    
    @Override
    public void setSpecialization(Specialization specialization){
        if(specialization==null){
            throw new NullPointerException();
        }
        this.specialization = specialization.getStaffName();
    }



    @Override
    public String toString() {
        StringBuilder stb =  new StringBuilder();
        stb.append("Infirmière :").append(this.lastName).append(this.firstName);
        return stb.toString();
    }
    
    
}
