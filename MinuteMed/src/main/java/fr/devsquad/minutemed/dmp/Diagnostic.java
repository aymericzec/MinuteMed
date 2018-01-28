package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.staff.Doctor;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Diagnostic implements Serializable {

    @Id @GeneratedValue
    @Column(name = "idDiagnostic")
    private long id;
    private String title;
    @OneToOne
    @JoinColumn(name = "idStaff")
    private Doctor diagnosticDoctor;
    @OneToOne
    @JoinColumn(name = "idMedicalRecord")
    private MedicalRecord medicalRecord;
    @Temporal(TemporalType.DATE)
    private Date consultDiagnostic;
    private String description;
    private boolean draft;
    
    public Diagnostic() { }
    
    public Diagnostic(String title, Doctor diagnosticDoctor, MedicalRecord medicalRecord, Date consultDiagnostic, String description) {
        this.title = Objects.requireNonNull(title);
        this.description = Objects.requireNonNull(description);
        this.diagnosticDoctor = Objects.requireNonNull(diagnosticDoctor);
        this.medicalRecord = Objects.requireNonNull(medicalRecord);
        this.medicalRecord = Objects.requireNonNull(medicalRecord);
        this.draft = true;
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
        return diagnosticDoctor;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public String getDescription() {
        return description;
    }  
    
    public boolean getDraft() {
        return draft;
    }
    
    public void setDraft(boolean draft) {
        this.draft = draft;
    }
}
