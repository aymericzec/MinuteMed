package fr.devsquad.minutemed.dmp;

import fr.devsquad.minutemed.staff.Doctor;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Prescription implements Serializable {

    @Id @GeneratedValue
    @Column(name = "idPrescription")
    private long id;
    private String title;
    @OneToOne
    @JoinColumn(name = "idDoctor")
    private Doctor prescriptor;
    @OneToOne
    @JoinColumn(name = "idMedicalRecord")
    private MedicalRecord medicalRecord;
    @Temporal(TemporalType.DATE)
    private Date consultDate;
    @OneToOne
    @JoinColumn(name = "idDiagnostic")
    private Diagnostic diagnostic;
    private String prescription;
    private boolean draft;

    
    public Prescription() { }
    
    public Prescription(String title, Doctor prescriptor, MedicalRecord medicalRecord, Date consultDate, Diagnostic diagnostic, String prescription) {
        this.title = title;
        this.prescriptor = prescriptor;
        this.medicalRecord = medicalRecord;
        this.consultDate = consultDate;
        this.diagnostic = diagnostic;
        this.prescription = prescription;
        this.draft = true;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Doctor getPrescriptor() {
        return prescriptor;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public Date getConsultDate() {
        return consultDate;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public String getPrescription() {
        return prescription;
    }

    public boolean getDraft() {
        return draft;
    }
    
    public void setDraft(boolean draft) {
        this.draft = draft;
    }
}
