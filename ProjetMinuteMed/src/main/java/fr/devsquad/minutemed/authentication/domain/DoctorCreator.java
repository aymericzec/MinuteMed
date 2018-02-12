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
    
    public Long specialization;
    
    public DoctorCreator(){
        super();
    }
  
    public DoctorCreator(Long specialization, String username, String password, String firstName, String lastName, String adress, String email, String phoneNumber, String typeNode, long idNode) {
        super(StaffEnum.DOCTOR.name(), username, password, firstName, lastName, adress, email, phoneNumber, typeNode, idNode);
        this.specialization = Objects.requireNonNull(specialization);
    }

    /**
     * @return the specialization
     */
    public Long getSpecialization() {
        return specialization;
    }

    /**
     * @param specialization the specialization to set
     */
    public void setSpecialization(Long specialization) {
        this.specialization = Objects.requireNonNull(specialization);
    }
    
    
    
}
