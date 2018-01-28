/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.staff.Doctor;
import fr.devsquad.minutemed.staff.IHospitalStaff;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author myfou
 */
public class Dosage {
    
    private long id;
    private String title;
    private Doctor doctorConsulting;
    private MedicalRecord medicalRecord;
    private Date dateDosage;
    private Diagnostic diagnostic;
    private String dosagePrescription;
    private List<ReportDosage> repport;
    private Date beginDosage;
    private Date endDosage;
    
    public Dosage () {
        
    }
    
    public Dosage (String title, Doctor doctorConsulting, MedicalRecord medicalRecord, Date dateDosage, Diagnostic diagnostic, String dosagePrescription, Date beginDosage, Date endDosage) {
        this.title = title;
        this.doctorConsulting = doctorConsulting;
        this.dateDosage = dateDosage;
        this.diagnostic = diagnostic;
        this.dosagePrescription = dosagePrescription;
        this.repport =new ArrayList();
        this.beginDosage = beginDosage;
        this.endDosage = endDosage;
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public Doctor getDoctorConsulting() {
        return doctorConsulting;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public Date getDateDosage() {
        return dateDosage;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public String getDosagePrescription() {
        return dosagePrescription;
    }

    public List<ReportDosage> getRepport() {
        return repport;
    }

    public Date getBeginDosage() {
        return beginDosage;
    }

    public Date getEndDosage() {
        return endDosage;
    }
    
    public ReportDosage getLastReport () {
        if (repport.size() > 0) {
            return repport.get(0);
        }
        
        return null;
    }
    
    public void addReport (IHospitalStaff staff, Date dateDosage, String repport) {
        ReportDosage reportDosage = new ReportDosage(staff, dateDosage, repport);
        this.repport.add(reportDosage);
    }

    
    
}
