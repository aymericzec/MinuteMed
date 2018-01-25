/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.specialization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author JSalmon
 */

@Entity
public class Specialization {
    
    @Id @GeneratedValue
    private long id;
    private String generalName;
    private String staffName;

    
    /**
     * This constructor is the default constructor for the JEE
     */
    public Specialization() {
    }

    
    /**
     * This constructor can create a specialization by the dataManager
     * 
     * @param specialization the SpecializationEnum of the specialization
     */
    public Specialization(SpecializationEnum specialization) {
        this.generalName = specialization.getGeneralName();
        this.staffName = specialization.getStaffName();
    }

    /**
     * This method return the id of this specialization in the data base
     * 
     * @return the id of this specialization
     */
    public long getId() {
        return id;
    }
    
    /**
     * This method return the name of a staff who work in this specialization
     * 
     * @return the name of the staff in this specialization
     */
    public String getStaffName() {
        return staffName;
    }
    
    /**
     * This method return the general name use for this specialization
     * 
     * @return the name of the specialization
     */
    public String getGeneralName() {
        return generalName;
    }
    
}
