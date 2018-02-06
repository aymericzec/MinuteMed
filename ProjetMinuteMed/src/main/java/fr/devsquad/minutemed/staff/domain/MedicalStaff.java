package fr.devsquad.minutemed.staff.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MedicalStaff implements Serializable {
    
    @Id @GeneratedValue
    @Column(name = "idStaff")
    private long id;
    private String type;
    private long idMedicalStaff;
    
    public MedicalStaff() { }
    
    public MedicalStaff(String type, long idMedicalStaff) {
        if(type==null){
            throw new NullPointerException();
        }
        if(idMedicalStaff<0){
            throw new IllegalArgumentException();
        }
        this.type = type;
        this.idMedicalStaff = idMedicalStaff;
    }
    
    public long getId() {
        return id;
    }
    
    public String getType() {
        return type;
    }
    
    public long getIdMedicalStaff() {
        return idMedicalStaff;
    }
}
