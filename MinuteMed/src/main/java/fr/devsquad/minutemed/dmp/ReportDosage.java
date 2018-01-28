/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.staff.IHospitalStaff;
import java.util.Date;

/**
 *
 * @author myfou
 */
public class ReportDosage {

    private long id = 1;
    private IHospitalStaff supervisor;
    private Date createDate;
    private String rapport;

    public ReportDosage(IHospitalStaff supervisor, Date createDate, String rapport) {
        this.supervisor = supervisor;
        this.createDate = createDate;
        this.rapport = rapport;
    }

    public long getId() {
        return id;
    }

    public IHospitalStaff getSupervisor() {
        return supervisor;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getRapport() {
        return rapport;
    }
    
    
    
   
    
}
