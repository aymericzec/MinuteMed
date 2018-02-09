package fr.devsquad.minutemed.dmp.domain;

import static fr.devsquad.minutemed.dmp.domain.Prescription.FIND_ALL_PRESCRIPTION;
import fr.devsquad.minutemed.staff.domain.Doctor;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = FIND_ALL_PRESCRIPTION, query = "SELECT u FROM Prescription u")
public class Prescription implements Serializable {

    public static final String FIND_ALL_PRESCRIPTION = "Diagnostic.findAllPrescription";
    
    @Id @GeneratedValue
    @Column(name = "idPrescription")
    private long id;
    private String title;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idDoctor")
    private Doctor prescriptor;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idMedicalRecord")
    private MedicalRecord medicalRecord;
    private String consultDate;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idDiagnostic")
    private Diagnostic diagnostic;
    private String prescription;
    private boolean draft;

    
    public Prescription() { }
    
    public Prescription(String title, Doctor prescriptor, MedicalRecord medicalRecord, String consultDate, Diagnostic diagnostic, String prescription) {
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

    public String getConsultDate() {
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
