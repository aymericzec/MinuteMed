package fr.devsquad.minutemed.staff.domain;

import fr.devsquad.minutemed.arborescence.domain.*;
import fr.devsquad.minutemed.authentication.domain.DoctorCreator;
import fr.devsquad.minutemed.specialization.domain.Specialization;
import static fr.devsquad.minutemed.staff.domain.Doctor.FIND_ALL_DOCTOR;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@DiscriminatorValue("DOCTOR")
@NamedQuery(name = FIND_ALL_DOCTOR, query = "SELECT staff FROM Doctor staff")
public class Doctor extends MedicalStaff implements Serializable {

    public static final String FIND_ALL_DOCTOR = "Doctor.findAllDoctor";
    
    private static final String STATUS = "DOCTOR";
    
    @NotNull
    private String specialization;
    
 
    public Doctor() {
        super(STATUS);
    }

    public Doctor(String specialization, String firstName, String lastName, String address, String email, String phoneNumber, Node node) {
        super(STATUS, Objects.requireNonNull(firstName), Objects.requireNonNull(lastName), Objects.requireNonNull(address),
                Objects.requireNonNull(email), Objects.requireNonNull(phoneNumber), Objects.requireNonNull(node));
        this.specialization = Objects.requireNonNull(specialization);
    }
    

    public String getSpecialization() {
        return specialization;
    }
 
    public void setSpecialization(Specialization specialization){
        if(specialization==null){
            throw new NullPointerException();
        }
        this.specialization = specialization.getStaffName();
    }

    @Override
    public String toString() {
        return "Doctor [ fN : " + getFirstName() + ", lN : " + getLastName() + " ]";
    }
    
    
}
