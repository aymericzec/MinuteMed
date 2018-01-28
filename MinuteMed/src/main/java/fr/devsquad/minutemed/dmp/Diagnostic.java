/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.staff.Doctor;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author myfou
 */
public class Diagnostic {

    private long id;
    private String title;
    private Doctor diagnostic;
    private MedicalRecord medicalRecord;
    private Date consultDiagnostic;
    private String description;
    
    public Diagnostic() { }
    
    public Diagnostic(String title, Doctor diagnostic, MedicalRecord medicalRecord, Date consultDiagnostic, String description) {
        this.title = Objects.requireNonNull(title);
        this.description = Objects.requireNonNull(description);
        this.diagnostic = Objects.requireNonNull(diagnostic);
        this.medicalRecord = Objects.requireNonNull(medicalRecord);
        this.medicalRecord = Objects.requireNonNull(medicalRecord);
    }
    
    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Date getConsultDiagnostic() {
        return consultDiagnostic;
    }

    public Doctor getDiagnostic() {
        return diagnostic;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public String getDescription() {
        return description;
    }  
}
