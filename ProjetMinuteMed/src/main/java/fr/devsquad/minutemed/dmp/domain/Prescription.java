package fr.devsquad.minutemed.dmp.domain;

import static fr.devsquad.minutemed.dmp.domain.Prescription.FIND_ALL_PRESCRIPTION;
import fr.devsquad.minutemed.staff.domain.Doctor;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NamedQuery(name = FIND_ALL_PRESCRIPTION, query = "SELECT u FROM Prescription u")
public class Prescription implements Serializable {

    public static final String FIND_ALL_PRESCRIPTION = "Diagnostic.findAllPrescription";
    
    @Id @GeneratedValue
    private long idPrescription;
    
    @NotNull
    @ManyToOne
    private Doctor prescriptor;
    
    @NotNull
    @ManyToOne
    private MedicalRecord medicalRecord;
    
    @ManyToOne
    private Diagnostic diagnostic;
    
    @NotNull
    private String title;
    
    @NotNull
    private String creationDate;

    @NotNull
    private String body;
    
    @NotNull
    private boolean draft;

    
    public Prescription() { }
    
    public Prescription(String title, Doctor prescriptor, MedicalRecord medicalRecord, String creationDate, Diagnostic diagnostic, String body) {
        this.title = Objects.requireNonNull(title);
        this.prescriptor = Objects.requireNonNull(prescriptor);
        this.medicalRecord = Objects.requireNonNull(medicalRecord);
        this.creationDate = Objects.requireNonNull(creationDate);
        this.diagnostic = Objects.requireNonNull(diagnostic);
        this.body = Objects.requireNonNull(body);
        this.draft = true;
    }

    public long getIdPrescription() {
        return idPrescription;
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

    public String getCreationDate() {
        return creationDate;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public String getBody() {
        return body;
    }

    public boolean isDraft() {
        return draft;
    }
    
    public void setDraft() {
        this.draft = false;
    }
}
