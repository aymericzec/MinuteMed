package fr.devsquad.minutemed.specialization.domain;

import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;



@Entity
public class Specialization implements Serializable {
        
    @Id @GeneratedValue
    private Long idSpecialization;
    
    @NotNull
    private String generalName;
    
    @NotNull
    private String staffName;

    
    /**
     * This constructor is the default constructor for the JEE
     */
    public Specialization() { }

    
    /**
     * This constructor can create a specialization by the dataManager
     * 
     * @param specialization the SpecializationEnum of the specialization
     */
    public Specialization(SpecializationEnum specialization) {
        Objects.requireNonNull(specialization);
        this.generalName = specialization.getGeneralName();
        this.staffName = specialization.getStaffName();
    }

    /**
     * This method return the id of this specialization in the data base
     * 
     * @return the id of this specialization
     */
    public long getIdSpecialization() {
        return idSpecialization;
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

    /**
     * This say if the obj is equals to this
     * @param obj is the Object to test
     * @return true if obj==this else false
     */
    @Override
    public boolean equals(Object obj) {
        if(obj==null){
            return false;
        }
        if(obj.getClass() == this.getClass()){
            
            Specialization spe = (Specialization) obj;
            if(spe.getGeneralName().equals(this.generalName)){
                if(spe.getStaffName().equals(this.staffName)){
                    return true;
                }
            }
        }
        return false; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.generalName);
        hash = 11 * hash + Objects.hashCode(this.staffName);
        return hash;
    }


    
    
}
