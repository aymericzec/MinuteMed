package fr.devsquad.minutemed.dmp.domain;

import static fr.devsquad.minutemed.dmp.domain.Exam.FIND_ALL_EXAM;
import fr.devsquad.minutemed.staff.domain.Doctor;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NamedQuery(name = FIND_ALL_EXAM, query = "SELECT u FROM Exam u")
public class Exam implements Serializable {
    
    public static final String FIND_ALL_EXAM = "Diagnostic.findAllExam";
    
    @Id @GeneratedValue
    private long idExam;
    
    @NotNull
    @ManyToOne
    private Doctor doctor;
    
    @NotNull
    @ManyToOne
    private MedicalRecord medicalRecord;
    
    @NotNull
    private String title;
    
    @NotNull
    private String description;
    
    @NotNull
    private String dateExam;
    
    @OneToOne
    private ResultExam resultExam;
    
    @NotNull
    private boolean draft;
    

    public Exam() { }
    
    public Exam(String title, String description, String dateExam, Doctor doctor, MedicalRecord medicalRecord) {
        this.title = Objects.requireNonNull(title);
        this.description = Objects.requireNonNull(description);
        this.dateExam = Objects.requireNonNull(dateExam);
        this.doctor = Objects.requireNonNull(doctor);
        this.medicalRecord = Objects.requireNonNull(medicalRecord);
        this.draft = true;
    }
    
    public long getIdExam() {
        return idExam;
    }

    public String getTitle() {
        return title;
    }
    
    public Doctor getDoctor () {
         return doctor;
    }
    
    public MedicalRecord getMedicalRecord () {
         return medicalRecord;
    }
    
    public String getDescription () {
        return description;
    }
    
    public String getDateExam() {
        return dateExam;
    }
    
    public boolean getDraft() {
        return draft;
    }
   
    public void setDraft() {
        this.draft = false;
    }
    
    public ResultExam getResultExam() {
        return resultExam;
    }
    
    public void setResultExam (ResultExam resultExam) {
        this.resultExam = Objects.requireNonNull(resultExam);
    }
    
}
