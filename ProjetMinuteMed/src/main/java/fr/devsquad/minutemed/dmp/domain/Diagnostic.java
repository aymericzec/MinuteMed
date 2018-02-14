package fr.devsquad.minutemed.dmp.domain;

import static fr.devsquad.minutemed.dmp.domain.Diagnostic.FIND_ALL_DIAGNOSTIC;
import fr.devsquad.minutemed.staff.domain.Doctor;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NamedQuery(name = FIND_ALL_DIAGNOSTIC, query = "SELECT d FROM Diagnostic d")
public class Diagnostic implements Serializable {

    public static final String FIND_ALL_DIAGNOSTIC = "Diagnostic.findAllDiagnostic";
    
    @Id @GeneratedValue
    private Long idDiagnostic;
    
    @NotNull
    @ManyToOne
    private Doctor creator;
    
    @NotNull
    @ManyToOne
    private MedicalRecord medicalRecord;
    
    @NotNull
    private String title;
    
    @NotNull
    private String creationDate;
    
    @NotNull
    private String body;
    
    @NotNull
    private boolean draft;
    
    
    public Diagnostic() { }
    
    public Diagnostic(String title, Doctor creator, MedicalRecord medicalRecord, String creationDate, String body) {
        this.title = Objects.requireNonNull(title);
        this.body = Objects.requireNonNull(body);
        this.creator = Objects.requireNonNull(creator);
        this.creationDate = Objects.requireNonNull(creationDate);
        this.medicalRecord = Objects.requireNonNull(medicalRecord);
        this.draft = true;
    }
    
    public Long getIdDiagnostic() {
        return idDiagnostic;
    }

    public String getTitle() {
        return title;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public Doctor getCreator() {
        return creator;
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
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
