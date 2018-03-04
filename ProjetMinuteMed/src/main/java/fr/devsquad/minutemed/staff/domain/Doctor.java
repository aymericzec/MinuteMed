package fr.devsquad.minutemed.staff.domain;

import fr.devsquad.minutemed.arborescence.domain.*;
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
    
    private static final StaffEnum STATUS = StaffEnum.DOCTOR;
    
    @OneToOne
    private Specialization specialization;
    
 
    public Doctor() {
        super(STATUS.name());
    }

    public Doctor(Specialization specialization, String firstName, String lastName, String address, String email, String phoneNumber, Node node) {
        super(STATUS.name(), Objects.requireNonNull(firstName), Objects.requireNonNull(lastName), Objects.requireNonNull(address),
                Objects.requireNonNull(email), Objects.requireNonNull(phoneNumber), Objects.requireNonNull(node));
        this.specialization = specialization;
    }
    

    public Specialization getSpecialization() {
        return specialization;
    }
 
    public void setSpecialization(Specialization specialization){
        this.specialization = specialization;
    }

    @Override
    public String toString() {
        return "Doctor [ fN : " + getFirstName() + ", lN : " + getLastName() + " ]";
    }
    
    
}
