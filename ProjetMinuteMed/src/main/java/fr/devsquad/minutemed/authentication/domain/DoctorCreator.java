/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.authentication.domain;

import fr.devsquad.minutemed.staff.domain.StaffEnum;
import java.util.Objects;

/**
 *
 * @author thomas
 */
public class DoctorCreator extends AbstractUserCreator {
    
    public String specialization;
    
    public DoctorCreator(){
        super();
    }
  
    public DoctorCreator(String specialization, String username, String password, String firstName, String lastName, String address, String email, String phoneNumber, long idNode, String floorNode) {
        super(StaffEnum.DOCTOR.name(), username, password, firstName, lastName, address, email, phoneNumber, idNode, floorNode);
        this.specialization = Objects.requireNonNull(specialization);
    }

    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(String specialization) {
        this.specialization = Objects.requireNonNull(specialization);
    }
    
    
    
}
