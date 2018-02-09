package fr.devsquad.minutemed.dmp.domain;

import static fr.devsquad.minutemed.dmp.domain.Diagnostic.FIND_ALL_DIAGNOSTIC;
import fr.devsquad.minutemed.staff.domain.Doctor;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = FIND_ALL_DIAGNOSTIC, query = "SELECT u FROM Diagnostic u")
public class Diagnostic implements Serializable {

    public static final String FIND_ALL_DIAGNOSTIC = "Diagnostic.findAllDiagnostic";
    
    @Id @GeneratedValue
    @Column(name = "idDiagnostic")
    private long id;
    private String title;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idDoctor")
    private Doctor diagnosticDoctor;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idMedicalRecord")
    private MedicalRecord medicalRecord;
    private String consultDiagnostic;
    private String description;
    private boolean draft;
    
    public Diagnostic() { }
    
    public Diagnostic(String title, Doctor diagnosticDoctor, MedicalRecord medicalRecord, String consultDiagnostic, String description) {
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

    public String getConsultDiagnostic() {
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
