package fr.devsquad.minutemed.staff.domain;

import fr.devsquad.minutemed.arborescence.domain.*;
import fr.devsquad.minutemed.dmp.domain.MedicalRecord;
import fr.devsquad.minutemed.dmp.domain.Dosage;
import static fr.devsquad.minutemed.staff.domain.Nurse.FIND_ALL_NURSE;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@DiscriminatorValue("NURSE")
@NamedQuery(name = FIND_ALL_NURSE, query = "SELECT staff FROM Nurse staff")
public class Nurse extends MedicalStaff implements Serializable{

    public static final String FIND_ALL_NURSE = "Nurse.findAllNurse";
    
    private static final String STATUS = "NURSE";
    
    
    public Nurse() {
        super(STATUS);
    }
    
    public Nurse(String firstName, String lastName, String address, String email, String phoneNumber, Node node) { 
        super(STATUS, Objects.requireNonNull(firstName), Objects.requireNonNull(lastName), Objects.requireNonNull(address),
                Objects.requireNonNull(email), Objects.requireNonNull(phoneNumber), Objects.requireNonNull(node));
    }
    
   
}
