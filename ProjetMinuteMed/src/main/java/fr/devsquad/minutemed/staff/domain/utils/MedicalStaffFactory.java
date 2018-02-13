package fr.devsquad.minutemed.staff.domain.utils;

import fr.devsquad.minutemed.arborescence.domain.*;
import fr.devsquad.minutemed.authentication.domain.*;
import fr.devsquad.minutemed.specialization.domain.*;
import fr.devsquad.minutemed.staff.domain.*;
import java.util.*;

/**
 *
 * @author enzo
 */
public class MedicalStaffFactory {
    

    public static Doctor createFromDoctorCreator(DoctorCreator doctorCreator, Node node, String specialization) {
        Objects.requireNonNull(doctorCreator);
        return new Doctor(Objects.requireNonNull(specialization),
                doctorCreator.getFirstName(),
                doctorCreator.getLastName(),
                doctorCreator.getAddress(),
                doctorCreator.getEmail(),
                doctorCreator.getPhoneNumber(),
                Objects.requireNonNull(node));
    }
    
    
    public static Nurse createFromNurseCreator(NurseCreator nurseCreator, Node node) {
        Objects.requireNonNull(nurseCreator);
        return new Nurse(nurseCreator.getFirstName(),
                nurseCreator.getLastName(),
                nurseCreator.getAddress(),
                nurseCreator.getEmail(),
                nurseCreator.getPhoneNumber(),
                Objects.requireNonNull(node));
    }
    
}
